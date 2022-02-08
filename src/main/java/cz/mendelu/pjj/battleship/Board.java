package cz.mendelu.pjj.battleship;

import java.io.Serializable;
import java.util.*;

public class Board implements Serializable {
    public enum Type {
        MY,
        ENEMY
    }

    private final Type type;

    /**
     * @author xomurzak
     * @version etapa 3
     */
    public Map<Coordinate, Cell> location = new HashMap<>();

    public Board(Type type) {
        this.buildBoard();
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    /**
     * Metoda vytvari herni plochu 10 x 10
     *
     * @author xomurzak
     * @version etapa 2
     */
    public void buildBoard() {
        for (int column = 0; column < 10; column++) {
            for (int row = 0; row < 10; row++) {
                location.put(
                        new Coordinate(column, row),
                        new Cell(this, column, row, null)
                );
            }
        }
    }
}
