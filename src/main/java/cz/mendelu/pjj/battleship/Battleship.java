package cz.mendelu.pjj.battleship;

import java.io.*;
import java.util.*;

public class Battleship implements Serializable {
    public Map<Integer, Integer> SHIP_COUNT = new HashMap<>() {{
        put(4, 1);
        put(3, 2);
        put(2, 3);
        put(1, 4);
    }};

    public Player me;
    public Player computer;
    Boolean turn;
    private Integer shipSize;

    /**
     * Konstruktor nenastavuje pouze vlastnosti, ale vola metodu loadGame,
     * ktera vytvari 2 board'y pro kazdeho hrace s 100 cell'ami pro kazdou board'u
     *
     * @author xomurzak
     * @version etapa 2
     */
    public Battleship() {
        setShipSize(0);
        loadGame();
    }

    public void setShipSize(Integer shipSize) {
        this.shipSize = shipSize;
    }

    public Integer getShipSize() {
        return shipSize;
    }

    public void placeEnemyShips() {
        me.enemyBoard.location.get(new Coordinate(0, 0)).setShip(new Ship(1));
        me.enemyBoard.location.get(new Coordinate(2, 0)).setShip(new Ship(1));
        me.enemyBoard.location.get(new Coordinate(9, 9)).setShip(new Ship(1));
    }

    public void loadGame() {
        this.me = new Player("Belek");
        this.computer = new Player("Machine");
    }

    private static File file(String name) {
        var dir = new File("save");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return new File(dir, name + ".battleship");
    }

    /**
     * Save game to folder <i>save/</i>
     *
     * @param battleship the game
     * @param name       name of file: <code>save/{name}.battleship</code>
     * @author xomurzak
     * @version etapa 4
     */
    public static void save(Battleship battleship, String name) {
        try (var out = new ObjectOutputStream(new FileOutputStream(file(name)))) {
            out.writeObject(battleship);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read helper from helper folder.
     *
     * @return helper
     * @author xomurzak
     * @version etapa 4
     */
    public static String readHelper() {
        String data = "";
        try {
            File helper = new File("helper", "helper.txt");
            Scanner myReader = new Scanner(helper);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "An error occurred.";
        }
        return data;
    }

    /**
     * Load game from save folder.
     *
     * @param name name of file: <code>save/{name}.battleship</code>
     * @return loaded game
     * @author xomurzak
     * @version etapa 4
     */
    public static Battleship load(String name) {
        try (var in = new ObjectInputStream(new FileInputStream(file(name)))) {
            return (Battleship) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Load game failed.", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Load game failed.", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Load game failed.", e);
        }
    }
}