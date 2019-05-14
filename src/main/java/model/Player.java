package model;

import javax.persistence.*;

/**
 * @author  Adam Micura
 * @version 1.0
 * @since   2019.03-31
 */

/**
 * Az {@link model.Player} osztály reprezentál egy játékost.
 * Egy {@link model.Player} példány egy új játékost hoz létre.
 */
@Entity
public class Player  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String playerName;

    @Column(name = "Score")
    private int score;

    @Column(name = "Date")
    private String date;

    public Player() {
    }

    public Player(String playerName, int score, String date) {
        this.playerName = playerName;
        this.score = score;
        this.date = date;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public String getDate() {
        return date;
    }

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
