package cz.mendelu.pjj.battleship;

import java.io.Serializable;
import java.util.Objects;

public class Coordinate implements Serializable {
    private final int row;
    private final int column;

    public Coordinate(int row, int column) {
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    /**
     * @author xomurzak
     * @version etapa 3
     */
    @Override
    public String toString() {
        return "Coordinate{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    /**
     * @author xomurzak
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return getRow() == that.getRow() && getColumn() == that.getColumn();
    }

    /**
     * @author xomurzak
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn());
    }

    public Coordinate getRightCell() {
        return new Coordinate(column + 1, row);
    }

    public Coordinate getLeftCell() {
        return new Coordinate(column - 1, row);
    }

    public Coordinate getUpCell() {
        return new Coordinate(column, row + 1);
    }

    public Coordinate getDownCell() {
        return new Coordinate(column, row - 1);
    }
}
