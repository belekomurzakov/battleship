package cz.mendelu.pjj.battleship.greenfoot;

import cz.mendelu.pjj.battleship.Battleship;
import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Trida reprezentuje tlacitko, ktera vola metodu ze hry pro ukladani stavu hry.
 *
 * @author xomurzak
 * @version etapa 4
 */
public class SaveActor extends Actor {
    private final Battleship battleship;

    public SaveActor(Battleship battleship) {
        GreenfootImage image = new GreenfootImage("save.png");
        image.scale(50, 50);
        setImage(image);
        this.battleship = battleship;
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            String name = Greenfoot.ask("Name of game: ");
            Battleship.save(battleship, name);
        }
    }
}
