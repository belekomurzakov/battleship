package cz.mendelu.pjj.battleship;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ship implements Serializable {
    /**
     * @author xomurzak
     * @version etapa 3
     */
    Set<Cell> location;

    Player owner;
    private final int size;

    public Ship(int size) {
        this.size = size;
        this.location = new HashSet<>();
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }


    /**
     * @author xomurzak
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return getSize() == ship.getSize() && Objects.equals(location, ship.location) && Objects.equals(getOwner(), ship.getOwner());
    }

    /**
     * @author xomurzak
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        Coordinate start = (location.isEmpty()) ? null : location.iterator().next().getCoordinate();
        return Objects.hash(start, getOwner(), getSize());
    }

    /**
     * @author xomurzak
     * @version etapa 3
     */
    @Override
    public String toString() {
        return "Owner of ship: " + getOwner() + "\nSize of ship: " + size + "\nLocation of ship: " + location;
    }

    public int getSize() {
        return size;
    }

    /**
     * Metoda kontroluje, jestli vsechny poli lodi jsou zasazeny.
     *
     * @return boolean - bud potopeny nebo neni.
     * @author xomurzak
     * @version etapa 2
     */
    public boolean isShipWrecked() {
        int counter = 0;
        for (Cell cell : this.location) {
            if (cell.getCellState() == CellState.SUCCESS_SHOT) {
                counter++;
            }
        }
        return counter == size;
    }
}