package cz.mendelu.pjj.battleship;

import java.io.Serializable;
import java.util.Objects;

public class Cell implements Serializable {
    private final Board board;
    private final Coordinate coordinate;
    private CellState state;
    private Ship ship;

    public Cell(Board board, int col, int row, Ship ship) {
        this.coordinate = new Coordinate(col, row);
        this.board = board;
        this.ship = ship;

        if (ship == null) {
            this.state = CellState.BLANK;
        } else {
            this.state = CellState.PLACED_SHIP;
        }
    }

    /**
     * @author xomurzak
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return getBoard().equals(cell.getBoard()) && getCoordinate().equals(cell.getCoordinate()) && state == cell.state && Objects.equals(getShip(), cell.getShip());
    }

    /**
     * @author xomurzak
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(getBoard(), getCoordinate(), state, getShip());
    }

    public CellState getCellState() {
        return state;
    }

    public void setCellState(CellState state) {
        this.state = state;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        this.state = CellState.PLACED_SHIP;
        ship.location.add(this);
    }

    public Board getBoard() {
        return board;
    }

    public int getColumn() {
        return coordinate.getColumn();
    }

    public int getRow() {
        return coordinate.getRow();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
