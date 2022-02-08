package cz.mendelu.pjj;

import cz.mendelu.pjj.battleship.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipTest {

    /**
     * @author xomurzak
     * @version etapa 2
     */
    @Test
    void isShipWrecked() {
        //setup
        Battleship battleship = new Battleship();
        Ship smallShip = new Ship(1);
        battleship.me.enemyBoard.location.get(new Coordinate(3, 3)).setShip(smallShip);
        Cell cell = battleship.me.enemyBoard.location.get(new Coordinate(3, 3));
        //when
        battleship.me.handleShot(cell);
        boolean result = smallShip.isShipWrecked();
        //then
        assertTrue(result, "All cells of ship should be shot!");
    }
}