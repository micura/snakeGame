package model;

/**
 * @author  Adam Micura.
 * @version 1.0
 * @since   2019.03-31
 *
 * Az {@link model.Cell} osztály reprezentálja a kígyó sejtjeit(részeit).
 * Egy {@link model.Cell} példány a kígyó egy sejtje.
 */

public class Cell {
    /**
     *  A kígyó sejt pozíciója az x-tengely mentén.
     */
    private int x;

    /**
     *  A kígyó sejt pozíciója az y-tengely mentén.
     */
    private int y;

    /**
     *  Megadja a kígyó sejt szélességét.
     */
    private static final int WIDTH = 20;

    /**
     *  Megadja a kígyó sejt magasságát.
     */
    private static final int HEIGHT = 20;

    /**
     * Az oztály konstruktora.
     * Inicializálja a kígyó sejtet.
     *
     * @param x Az új kígyó sejt pozíciója az x-tengely mentén.
     * @param y Az új kígyó sejt pozíciója az y-tengely mentén.
     * @see Cell
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *  @return Visszatér egy kígyó sejt x pozíciójával
     *  @see Cell
     */
    public int getX() {
        return x;
    }

    /**
     *  @return Visszatér egy kígyó sejt y pozíciójával
     *  @see Cell
     */
    public int getY() {
        return y;
    }

    /**
     *  Beállítja egy adott kígyó sejt x pozícióját.
     *  @param x Egy adott kígyó sejt x pozíciója
     *  @see Cell
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *  Beállítja egy adott kígyó sejt y pozícióját.
     *  @param y Egy adott kígyó sejt y pozíciója
     *  @see Cell
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *  @return Visszatér egy kígyó sejt szélességével
     *  @see Cell
     */
    public static int getWidth() {
        return WIDTH;
    }

    /**
     *  @return Visszatér egy kígyó sejt magasságával
     *  @see Cell
     */
    public static int getHeight() {
        return HEIGHT;
    }
}
