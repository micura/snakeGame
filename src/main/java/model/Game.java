package model;

/**
 * @author  Adam Micura
 * @version 1.0
 * @since   2019.03-31
 */

/**
 * Az {@link model.Game} osztály reprezentálja a játékmenetet.
 * Egy {@link model.Game} példány egy új játékmenetet hoz létre.
 */

public class Game {
    public static Food food;
    public static Snake snake;

    /**
     * Megadja a játéktér szélességét.
     */
    private static double WIDTH;

    /**
     * Megadja a játéktér magasságát.
     */
    private static double HEIGHT;

    /**
     * A szerzett pontokat tárolja.
     */
    private static int score;

    /**
     * Az oztály konstruktora. Inicializál egy játékot.
     * Megadja a kezdeti pontszámot. Létrehozza a kígyót és egy kaját.
     *
     * @param width A játéktér szélessége.
     * @param height A játéktér magassága.
     * @see Game
     */
    public Game(double width, double height) {
        WIDTH = width;
        HEIGHT = height;
        score = 0;
        snake = new Snake();
        food = new Food();
        Main.log.info("Új játék indítása!");
    }

    /**
     * Megadja, hogy a játék véget ért-e.
     *
     * @return {@code true}: a játék véget ért, {@code false}: a játék nem ért véget.
     */
    public boolean isGameOver() {
        try {
            if (snake.update(food)){
                if (food.isEated()) {
                    score++;
                    food = new Food();
                }
                return false;
            }
            return true;
        } catch (Exception e){
            Main.log.error("Error in Game.isGameOver(): " + e);
            return true;
        }
    }

    /**
     *  @return Visszatér a játéktér szélességével.
     *  @see Game
     */
    public static double getWIDTH() {
        return WIDTH;
    }

    /**
     *  @return Visszatér a játéktér magasságával.
     *  @see Game
     */
    public static double getHEIGHT() {
        return HEIGHT;
    }

    /**
     * Beállítja a játéktér szélességét.
     * @param WIDTH a játéktér szélessége.
     */
    public static void setWIDTH(double WIDTH) {
        Game.WIDTH = WIDTH;
    }

    /**
     * Beállítja a játéktér magasságát.
     * @param HEIGHT a játéktér magassága.
     */
    public static void setHEIGHT(double HEIGHT) {
        Game.HEIGHT = HEIGHT;
    }

    /**
     *  @return Visszaadja a szerzett pontok számát.
     *  @see Game
     */
    public int getScore() {
        return score;
    }
}
