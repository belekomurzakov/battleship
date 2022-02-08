package cz.mendelu.pjj.battleship.greenfoot;

import cz.mendelu.pjj.battleship.Battleship;
import cz.mendelu.pjj.battleship.Cell;
import cz.mendelu.pjj.battleship.Rotation;
import cz.mendelu.pjj.battleship.Ship;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.Objects;

/**
 * Třída reprezentuje sipku na plose. Vola placeShip metodu z tridy Player
 * pro umisteni lodi na desce.
 *
 * @author xomurzak
 * @version etapa 4
 */
public class RotationActor extends Actor {
    private final Rotation rotation;
    private final Battleship battleship;
    private final Cell cell;
    private Ship ship;
    private GreenfootImage image;

    public RotationActor(Rotation rotation, Battleship battleship, Cell cell, Ship ship) {
        this.rotation = rotation;
        this.battleship = battleship;
        this.cell = cell;
        this.ship = ship;
        showRotations();
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (battleship.me.placeShip(cell.getRow(), cell.getColumn(), rotation, ship)) {
                battleship.SHIP_COUNT.put(ship.getSize(), battleship.SHIP_COUNT.get(ship.getSize()) - 1);
            }
            //Hide RotationToChoose
            for (LabelActor labelActor : getWorld().getObjects(LabelActor.class)) {
                if (Objects.equals(labelActor.getName(), "RotationToChoose")) {
                    getWorld().removeObject(labelActor);
                    break;
                }
            }
            hideRotations();
        }
    }

    private void hideRotations() {
        for (RotationActor rotationActor : getWorld().getObjects(RotationActor.class)) {
            if (rotationActor != this) {
                getWorld().removeObject(rotationActor);
            }
        }
        getWorld().removeObject(this);
    }

    private void showRotations() {
        switch (rotation) {
            case UP:
                image = new GreenfootImage("arrow_up.png");
                break;
            case DOWN:
                image = new GreenfootImage("arrow_down.png");
                break;
            case RIGHT:
                image = new GreenfootImage("arrow_right.png");
                break;
            case LEFT:
                image = new GreenfootImage("arrow_left.png");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rotation);
        }
        image.scale(70, 70);
        setImage(image);
    }
}
