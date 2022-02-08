package cz.mendelu.pjj.battleship;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Player implements Serializable {
    private final String name;
    public Board myBoard;
    public Board enemyBoard;
    private Integer result;

    /**
     * Required for AI, to get know which cell was shot by computer
     *
     * @author xomurzak
     * @version etapa 3
     */
    LinkedList<Cell> shotCells = new LinkedList<>();

    public Player(String name) {
        this.name = name;
        this.myBoard = new Board(Board.Type.MY);
        this.enemyBoard = new Board(Board.Type.ENEMY);
    }

    public String getName() {
        return name;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }


    /**
     * Private metoda pro pouziti v metode placeShip
     *
     * @param row    je cislo je číslo v rozsahu: 1 az 10
     * @param column je písmeno v rozsahu: A az J
     * @author xomurzak
     * @version etapa 3
     */
    private boolean setLocation(int row, int column, Ship ship) {
        Cell cell = myBoard.location.get(new Coordinate(row, column));
        if (cell.getShip() == null) {
            cell.setShip(ship);
            ship.location.add(myBoard.location.get(new Coordinate(row, column)));
            ship.setOwner(this);
            return true;
        }
        return false;
    }

    /**
     * @param row      je číslo v rozsahu: 0 az 9
     * @param column   je číslo v rozsahu: 0 az 9
     * @param rotation je jeden ze smeru: DOWN, UP, RIGHT, LEFT
     * @param ship     je lod
     * @throws IndexOutOfBoundsException je dotazováno mimo rozsah
     * @author xomurzak
     * @version etapa 2
     */
    public boolean placeShip(int row, int column, Rotation rotation, Ship ship) {
        if (!shipInBoard(row, column, rotation, ship)) {
            throw new IndexOutOfBoundsException("Please, choose coordinates in A-J and 0-9");
        }
        for (int i = 0; i < ship.getSize(); i++) {
            if (rotation == Rotation.UP) {
                if (!setLocation(row - i, column, ship)) {
                    return false;
                }
            } else if (rotation == Rotation.DOWN) {
                if (!setLocation(row + i, column, ship)) {
                    return false;
                }
            } else if (rotation == Rotation.RIGHT) {
                if (!setLocation(row, column + i, ship)) {
                    return false;
                }
            } else if (rotation == Rotation.LEFT) {
                if (!setLocation(row, column - i, ship)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * TODO: pridej popis
     *
     * @param column   je písmeno v rozsahu: A az J
     * @param row      je cislo je číslo v rozsahu: 1 az 10
     * @param rotation je jeden ze smeru: DOWN, UP, RIGHT, LEFT
     * @throws IndexOutOfBoundsException je dotazováno mimo rozsah
     * @author xomurzak
     * @version etapa 2
     */
    private boolean shipInBoard(int row, int column, Rotation rotation, Ship ship) {
        if (row >= 0 && column >= 0 && row < 10 && column < 10) {
            return true;
        }

        switch (rotation) {
            case RIGHT:
                return (row >= 0 && column + ship.getSize() >= 0) && (row < 10 && column + ship.getSize() < 10);
            case LEFT:
                return (row >= 0 && column - ship.getSize() >= 0) && (row < 10 && column - ship.getSize() < 10);
            case UP:
                return (row + ship.getSize() >= 0 && column >= 0) && (row + ship.getSize() < 10 && column < 10);
            case DOWN:
                return (row - ship.getSize() >= 0 && column >= 0) && (row - ship.getSize() < 10 && column < 10);
            default:
                return false;
        }
    }

    /**
     * Metoda slouzi pro strelbu na urcitou policku.
     *
     * @param cell je bunka s koordinatou {0,0} az {9,9}
     * @throws IndexOutOfBoundsException je dotazováno mimo rozsah
     * @author xomurzak
     * @version etapa 2
     */
    public void handleShot(Cell cell) {
        if (cell.getColumn() >= 0 && cell.getColumn() < 10 && cell.getRow() >= 0 && cell.getRow() < 10) {
            shotCells.add(cell);
            if (cell.getCellState() == CellState.PLACED_SHIP) {
                cell.setCellState(CellState.SUCCESS_SHOT);
            } else if (cell.getCellState() == CellState.BLANK) {
                cell.setCellState(CellState.INSUCCESS_SHOT);
            }
        } else {
            throw new IndexOutOfBoundsException("Please, choose coordinates in A-J and 0-9");
        }
    }
}