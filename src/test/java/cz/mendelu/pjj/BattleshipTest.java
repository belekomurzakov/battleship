package cz.mendelu.pjj;

import cz.mendelu.pjj.battleship.Battleship;
import cz.mendelu.pjj.battleship.Board;
import cz.mendelu.pjj.battleship.Cell;
import cz.mendelu.pjj.battleship.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BattleshipTest {

    /**
     * @author xomurzak
     * @version etapa 2
     */
    @Test
    void loadGame() {
        //setup
        Battleship battleship = new Battleship();
        Board myBoard = battleship.me.myBoard;
        Board enemyBoard = battleship.me.enemyBoard;
        Cell cell = battleship.me.myBoard.location.get(new Coordinate(0, 0));
        //when + then
        assertNotNull(battleship);
        assertNotNull(myBoard);
        assertNotNull(enemyBoard);
        assertNotNull(cell);
    }
}