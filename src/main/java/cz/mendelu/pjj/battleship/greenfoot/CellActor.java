package cz.mendelu.pjj.battleship.greenfoot;

import cz.mendelu.pjj.battleship.*;
import greenfoot.Actor;
import greenfoot.Greenfoot;

import java.util.Objects;

/**
 * Třída reprezentuje jednu buňku na desce hráče.
 * Buňka muže se nacházet v několika stavech na zakladě vlastníctví desky:
 * Desca oponenta:
 * Zasažený - pokud hráč zasáhl loď.
 * Nezasažený - pokud hráč nezasáhl loď.
 * Vlastní desca:
 * Zasažený - pokud oponent zasáhl loď.
 * Umístěná loď - umístěna nezasažená loď.
 *
 * @author xomurzak
 * @version etapa 4
 */
class CellActor extends Actor {
    private final Cell cell;
    private final Battleship battleship;
    private Ship ship;

    public CellActor(Cell cell, Battleship battleship, Ship ship) {
        this.cell = cell;
        this.battleship = battleship;
        this.ship = ship;
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this) && cell.getBoard().getType() == Board.Type.ENEMY) {
            battleship.me.handleShot(cell);
        } else if (Greenfoot.mouseClicked(this)) {
            if (battleship.getShipSize() > 0) {
                ship = new Ship(battleship.getShipSize());
                showRotation();

                //Hide CellToChoose
                for (LabelActor labelActor : getWorld().getObjects(LabelActor.class)) {
                    if (Objects.equals(labelActor.getName(), "CellToChoose")) {
                        getWorld().removeObject(labelActor);
                        break;
                    }
                }
            }
        }

        //Setting cell image based on cell state
        switch (cell.getCellState()) {
            case BLANK:
                setImage("cell_blank.png");
                break;
            case PLACED_SHIP:
                if (cell.getBoard() == battleship.me.myBoard) {
                    setImage("ship_neutral.png");
                } else {
                    setImage("cell_blank.png");
                }
                break;
            case SUCCESS_SHOT:
                if (cell.getBoard() == battleship.me.myBoard) {
                    setImage("ship_hit.png");
                } else {
                    setImage("cell_hit.png");
                }
                break;
            case INSUCCESS_SHOT:
                if (cell.getBoard() == battleship.me.enemyBoard) {
                    setImage("cell_miss.png");
                }
        }
    }

    public void showRotation() {
        getWorld().addObject(new LabelActor("Please choose rotation to place", "RotationToChoose"), 887, 50);
        getWorld().addObject(new RotationActor(Rotation.UP, battleship, cell, ship), 825, 100);
        getWorld().addObject(new RotationActor(Rotation.RIGHT, battleship, cell, ship), 880, 100);
        getWorld().addObject(new RotationActor(Rotation.DOWN, battleship, cell, ship), 935, 100);
        getWorld().addObject(new RotationActor(Rotation.LEFT, battleship, cell, ship), 990, 100);
    }
}