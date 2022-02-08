package cz.mendelu.pjj.battleship.greenfoot;

import cz.mendelu.pjj.battleship.Battleship;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Trida reprezentuje tlacitko, ktera vola metodu ze hry pro nacteni ulozene hry.
 *
 * @author xomurzak
 * @version etapa 4
 */
public class LoadActor extends Actor {

    public LoadActor(Battleship battleship) {
        GreenfootImage image = new GreenfootImage("load.png");
        image.scale(45, 45);
        setImage(image);
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            String name = Greenfoot.ask("Name of game: ");
            var battleship = Battleship.load(name);
            var world = new BattleshipWorld(battleship);
            Greenfoot.setWorld(world);
        }
    }
}
