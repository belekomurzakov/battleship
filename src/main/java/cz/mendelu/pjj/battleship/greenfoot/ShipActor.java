package cz.mendelu.pjj.battleship.greenfoot;

import cz.mendelu.pjj.battleship.Battleship;
import cz.mendelu.pjj.battleship.Ship;
import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.Objects;

/**
 * Třída reprezentuje typy lodi na vyber uzivatelovi.
 * Nezbytna trida pro umistovani lodi.
 *
 * @author xomurzak
 * @version etapa 4
 */
public class ShipActor extends Actor {
    private final Ship ship;
    private final Battleship battleship;

    public ShipActor(Ship ship, Battleship battleship) {
        this.ship = ship;
        this.battleship = battleship;
        switch (ship.getSize()) {
            case 4:
                setImage("Ship_4x.png");
                break;
            case 3:
                setImage("Ship_3x.png");
                break;
            case 2:
                setImage("Ship_2x.png");
                break;
            case 1:
                setImage("ship_neutral.png");
                break;
        }
    }

    @Override
    public void act() {
        if (battleship.SHIP_COUNT.get(ship.getSize()) == 0) {
            if (ship.getSize() == 1) {
                hideLabelActor("ShipToChoose");
            }
            getWorld().removeObject(this);
        }

        if (Greenfoot.mouseClicked(this)) {
            getWorld().addObject(new LabelActor("Please choose cell on your desk", "CellToChoose"), 887, 30);
            battleship.setShipSize(ship.getSize());
            hideLabelActor("Helper");
        }
    }

    private void hideLabelActor(String name) {
        for (LabelActor labelActor : getWorld().getObjects(LabelActor.class)) {
            if (Objects.equals(labelActor.getName(), name)) {
                getWorld().removeObject(labelActor);
            }
        }
    }
}