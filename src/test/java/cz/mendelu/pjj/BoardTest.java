package cz.mendelu.pjj;

import cz.mendelu.pjj.battleship.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void buildBoard() {
        //setup
        Board board = new Board(Board.Type.MY);
        //when
        board.buildBoard();
        //then
        assertNotNull(board);
    }
}
