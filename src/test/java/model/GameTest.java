package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Cell goodCell = new Cell(350, 200);

    @BeforeEach
    void setUp() {
        game = new Game(400, 400);
    }

    @AfterEach
    void tearDown() {
        game = null;
    }

    @Test
    void isGameOver() {
        assertTrue(Game.getWIDTH() > goodCell.getX(),
                "A pálya szélességének(" + Game.getWIDTH() + ") nagyobbnak kell lennie, mint " + goodCell.getX() );

        assertTrue(goodCell.getX() > 0.0,
                "A kígyó x pozíciójának(" + goodCell.getX() + ") nagyobbnak kell lennie, mint" + 0.0);

        assertTrue(Game.getHEIGHT() > goodCell.getY(),
                "A pálya hosszának(" + Game.getWIDTH() + ") nagyobbnak kell lennie, mint " + goodCell.getY() );

        assertTrue(goodCell.getY() > 0.0,
                "A kígyó y pozíciójának(" + goodCell.getY() + ") nagyobbnak kell lennie, mint" + 0.0);
    }
}