package cz.mendelu.pjj.battleship.greenfoot;

import cz.mendelu.pjj.battleship.Battleship;
import cz.mendelu.pjj.battleship.Cell;
import cz.mendelu.pjj.battleship.Ship;
import greenfoot.World;

/**
 * Třída určená pro okolí hry a manipulace s objekty na ploše.
 *
 * @author xomurzak
 * @version etapa 4
 */
public class BattleshipWorld extends World {

    private Battleship battleship;

    public BattleshipWorld() {
        this(new Battleship());
    }

    public BattleshipWorld(Battleship battleship) {
        super(1024, 442, 1);
        this.battleship = battleship;
        this.battleship.placeEnemyShips();
        setBackground("board.jpg");

        //Adding cells for each board
        for (Cell cell : battleship.me.myBoard.location.values()) {
            var c = new CellActor(cell, battleship, null);
            int x = 74 + (cell.getColumn() * 30);
            int y = 116 + (cell.getRow() * 30);
            addObject(c, x, y);
        }

        for (Cell cell : battleship.me.enemyBoard.location.values()) {
            var c = new CellActor(cell, battleship, null);
            int x = 435 + (cell.getColumn() * 30);
            int y = 116 + (cell.getRow() * 30);
            addObject(c, x, y);
        }

        //Adding ship types to build
        addObject(new ShipActor(new Ship(1), battleship), 994, 285);
        addObject(new ShipActor(new Ship(2), battleship), 979, 320);
        addObject(new ShipActor(new Ship(3), battleship), 964, 355);
        addObject(new ShipActor(new Ship(4), battleship), 949, 390);
        addObject(new LabelActor("Please choose ship type to place", "ShipToChoose"), 887, 425);

        //Save and Load buttons
        addObject(new SaveActor(battleship), 360, 425);
        addObject(new LoadActor(battleship), 435, 424);

        /**
         * Napoveda
         *
         * @author xomurzak
         * @version etapa 4
         */
        addObject(new LabelActor(Battleship.readHelper(), "Helper"), 900, 140);
    }
}
