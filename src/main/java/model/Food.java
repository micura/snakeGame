package model;

import java.util.Random;

/**
 * @author  Adam Micura
 * @version 1.0
 * @since   2019.03-31
 */

/**
 * Az {@link model.Food} osztály reprezentálja a kaját.
 * Egy {@link model.Food} példány a kígyó kajáját reprezentálja.
 */
public class Food {
    /**
     *  A kaja pozíciója az x-tengely mentén.
     */
    private int x;

    /**
     *  A kaja pozíciója az y-tengely mentén.
     */
    private int y;

    /**
     *  A kaja állapota, {@code true}: a kaja és a kígyó-fej pozíciója megegyezik.
     *  {@code false}: a kaja és a kígyó-fej pozíciója nem egyezik meg.
     */
    private boolean eated;

    /**
     * Az osztály konstruktora. Inicializálja a kaját.
     * Beállítja az állapotát, és megadja a pozícióját.
     * @see Food
     */
    public Food() {
        this.eated = false;
        Random rand = new Random();
        int x = rand.nextInt((int) Game.getWIDTH()) / 20;
        int y = rand.nextInt((int) Game.getHEIGHT()) / 20;
        while(!(isValidArea(x*Cell.getWidth(),y*Cell.getHeight()))) {
            x = rand.nextInt((int) Game.getWIDTH()) / 20;
            y = rand.nextInt((int) Game.getHEIGHT()) / 20;
        }
        this.setX(x*Cell.getWidth());
        this.setY(y*Cell.getHeight());
    }

    /**
     * Megadja, hogy a kaja pozíciója érvényes pozíción van-e, vagy olyan pozícióra került ahol egy kígyó sejt található.
     *
     * @param x A ellenőrizendő pozíciója az x-tengely mentén.
     * @param y A ellenőrizendő pozíciója az y-tengely mentén.
     * @return {@code true}: a kaja érvényes pozíción van, {@code false}: a kaja érvénytelen pozícióra került.
     */
    public boolean isValidArea(int x, int y){
        for (int j = 0; j <= Snake.getSnake().size() - 1; j++) {
            if ((Snake.getSnake().get(j).getX() == x) && (Snake.getSnake().get(j).getY() == y)){
                return false;
            }
        }
        return true;
    }

    /**
     * Megadja, hogy a kígyó-fej és a kaja pozíciója megegyezik-e.
     *
     * @return {@code true}: a fej pozíciója megegyezik a kaja pozíciójával.
     * {@code false}: a fej pozíciója nem egyezik meg a kaja pozíciójával.
     * @see Food
     */
    public boolean isEated() {
        return eated;
    }

    /**
     * Módosítja a kaja állapotát.
     *
     * @param value {@code true}: A fej elérte a kaja pozícióját. {@code false}: a fej és a kaja különböző pozíción állnak.
     */
    public void setEated(boolean value) {
        this.eated = value;
    }

    /**
     *  @return Visszatér a kaja x pozíciójával.
     *  @see Food
     */
    public int getX() {
        return x;
    }

    /**
     *  @return Visszatér a kaja y pozíciójával.
     *  @see Food
     */
    public int getY() {
        return y;
    }

    /**
     *  Beállítja egy adott kaja x pozícióját.
     *  @param x Egy adott kaja x pozíciója.
     *  @see Food
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *  Beállítja egy adott kaja y pozícióját.
     *  @param y Egy adott kaja y pozíciója.
     *  @see Food
     */
    public void setY(int y) {
        this.y = y;
    }
}
