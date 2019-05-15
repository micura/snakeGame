package model;

import javax.persistence.*;

/**
 * @author  Adam Micura
 * @version 1.0
 * @since   2019.03-31
 *
 * Az {@link model.Player} osztály reprezentál egy játékost.
 * Egy {@link model.Player} példány egy új játékost hoz létre.
 */
@Entity
public class Player  {
    /**
     * A adatbázisban tárolt játékos id-ja.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * A adatbázisban tárolt játékos neve.
     */
    @Column(name = "Name")
    private String playerName;

    /**
     * A adatbázisban tárolt játékos pontja.
     */
    @Column(name = "Score")
    private int score;

    /**
     * A adatbázisban tárolt játékmenet dátuma.
     */
    @Column(name = "Date")
    private String date;

    /**
     * Az osztály alapértelmezett konstruktora
     */
    public Player() {
    }

    /**
     * Az osztály konstruktora
     *
     * @param playerName a játékos neve.
     * @param score a játékos pontszáma.
     * @param date a játékmenet dátuma.
     */
    public Player(String playerName, int score, String date) {
        this.playerName = playerName;
        this.score = score;
        this.date = date;
    }

    /**
     * @return visszaadja a játékos nevét.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return visszaadja a játékos pontszámát.
     */
    public int getScore() {
        return score;
    }

    /**
     * @return visszaadja a játékmenet dátumát.
     */
    public String getDate() {
        return date;
    }

    /**
     * A függvény visszatér a játékos szöveges megfelelőjével.
     *
     * @return egy játékos szöveges alakja.
     */
    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", playerName='" + playerName + '\'' +
                ", score=" + score +
                ", date='" + date + '\'' +
                '}';
    }
}
