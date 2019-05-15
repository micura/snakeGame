package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeTest {
    private ArrayList<Cell> actualSnake;
    private Snake snake;
    private Food food;

    @BeforeEach
    void setUp() {
        Game.setWIDTH(400.0);
        Game.setHEIGHT(400.0);
        food = new Food();
        actualSnake = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        actualSnake = null;
        snake = null;
        food = null;
    }

    @Test
    void getSnake() {
        actualSnake = Snake.getSnake();
        assertTrue(actualSnake.get(0) != null,"Az úgy kígyó példány 0. eleme nem lehet null ");
    }

    @Test
    void update() {
        snake = new Snake();
        Cell previous = Snake.getSnake().get(0);
        snake.update(food);
        assertTrue((previous.getX() != 10 || previous.getY() != 10), "A kígyó egy frissítése után egy adott sejt nem kerülhet ugyan arra a koordinátára" );
    }
}