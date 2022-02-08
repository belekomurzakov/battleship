package cz.mendelu.pjj;

import cz.mendelu.pjj.battleship.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    /**
     * @author xomurzak
     * @version etapa 2
     */
    @Test
    void successShot() {
        //setup
        Battleship battleship = new Battleship();
        battleship.placeEnemyShips();
        Cell cell = battleship.me.enemyBoard.location.get(new Coordinate(0, 0));
        //when
        battleship.me.handleShot(cell);
        //then
        CellState result = battleship.me.enemyBoard.location.get(new Coordinate(0, 0)).getCellState();
        assertEquals(result, CellState.SUCCESS_SHOT, "Shot should be on coordinate, where ship is located.");
    }

    /**
     * @author xomurzak
     * @version etapa 2
     */
    @Test
    void unSuccessShot() {
        //setup
        Battleship battleship = new Battleship();
        battleship.placeEnemyShips();
        Cell cell = battleship.me.enemyBoard.location.get(new Coordinate(3, 4));
        //when
        battleship.me.handleShot(cell);
        //then
        CellState result = cell.getCellState();
        assertEquals(result, CellState.INSUCCESS_SHOT, "Shot should be on coordinate, where ship is not located.");
    }


    /**
     * @author xomurzak
     * @version etapa 2
     */
    @Test
    void shotOutOfBoard() {
        //setup
        Battleship battleship = new Battleship();
        Cell cell = new Cell(battleship.me.enemyBoard, 12, 12, null);
        //when + then:
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> battleship.me.handleShot(cell));
    }

    /**
     * @author xomurzak
     * @version etapa 2
     */
    @Test
    void successPlaced() {
        //setup
        List<CellState> result = new LinkedList<>();
        Battleship battleship = new Battleship();
        Ship ship = new Ship(4);
        //when
        battleship.me.placeShip(1, 1, Rotation.RIGHT, ship);
        for (int i = 1; i < ship.getSize(); i++) {
            result.add(battleship.me.myBoard.location.get(new Coordinate(1, i)).getCellState());
        }
        //then
        for (CellState cellState : result) {
            assertEquals(CellState.PLACED_SHIP, cellState, "Place ship on free coordinates!");
        }
    }

    /**
     * @author xomurzak
     * @version etapa 2
     */

    @Test
    void unSuccessPlaced() {
        //setup
        Battleship battleship = new Battleship();
        Ship ship = new Ship(3);
        Ship newShip = new Ship(1);
        battleship.me.placeShip(3, 3, Rotation.DOWN, ship);
        //when
        boolean result = battleship.me.placeShip(4, 3, Rotation.DOWN, newShip);
        //then
        assertEquals(false, result, "Place is already taken!");

    }
}

