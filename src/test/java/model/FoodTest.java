package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class FoodTest {
    private Food eatablefood;
    private Food newFood;

    private Cell snakeHead;

    private Snake snake;
    @BeforeEach
    void setUp() {
        Game.setWIDTH(400.0);
        Game.setHEIGHT(400.0);
        eatablefood = new Food();
        snake = new Snake();

        eatablefood.setX(100);
        eatablefood.setY(100);
        newFood = new Food();
        newFood.setX(300);
        newFood.setY(200);
        snakeHead = new Cell(100,100);
    }

    @AfterEach
    void tearDown() {
        eatablefood = null;
        snakeHead = null;
    }

    @Test
    void isEated() {
        assertTrue((eatablefood.getX() == snakeHead.getX()) && (eatablefood.getY() == snakeHead.getY()),
                "A kaja akkor ehető, ha egy pozíción van a kígyó-fejjel.");
    }

    @Test
    void isValidArea() {
        assertTrue(Game.getWIDTH() > newFood.getX(),
                    "A pálya szélességének(" + Game.getWIDTH() + ") nagyobbnak kell lennie, mint " + newFood.getX() );

        assertTrue(newFood.getX() > 0.0,
                    "A kaja x pozíciójának(" + newFood.getX() + ") nagyobbnak kell lennie, mint" + 0.0);

        assertTrue(Game.getHEIGHT() > newFood.getY(),
                    "A pálya magasságának(" + Game.getWIDTH() + ") nagyobbnak kell lennie, mint " + newFood.getY() );

        assertTrue(newFood.getY() > 0.0,
                    "A kaja y pozíciójának(" + newFood.getY() + ") nagyobbnak kell lennie, mint" + 0.0);


        assertTrue((newFood.getX() != snakeHead.getX()) || (newFood.getY() != snakeHead.getY()),
                "A kaja pozíciója nem lehet a kígyó-fej pozícióján." + newFood.getX()+" "+snakeHead.getX());
    }
}