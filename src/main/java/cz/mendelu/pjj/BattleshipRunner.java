package cz.mendelu.pjj;

import bh.greenfoot.runner.GreenfootRunner;
import cz.mendelu.pjj.battleship.greenfoot.*;

public class BattleshipRunner extends GreenfootRunner {
    static {
        // 2. Bootstrap the runner class.
        bootstrap(BattleshipRunner.class,
                // 3. Prepare the configuration for the runner based on the world-class
                Configuration.forWorld(BattleshipWorld.class)
                        // Set the project name as you wish
                        .projectName("Battleship")
                        .hideControls(true)
        );
    }

    public static void main(String[] args) {
        GreenfootRunner.main(args);
    }
}
