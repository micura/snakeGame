package model;

import java.util.ArrayList;
import java.util.Random;

public class Snake {
    /**
     * A kígyó iránya.
     */
    private static String direction;

    /**
     * A kígyó részeit tároló lista.
     * @see Snake
     */
    private static ArrayList<Cell> snake = new ArrayList<>();


    /**
     * Az osztály konstruktora. Inicializál egy kígyót.
     * Megadja a kígyó kezdeti pozícióját, illeve inicializálja a kezdeti irányít.
     *
     * @see Snake
     */
    public Snake() {
        Random rand = new Random();
        int cellX = rand.nextInt((int) Game.getWIDTH()) / 20;
        int cellY = rand.nextInt((int) Game.getHEIGHT()) / 20;
        Cell firstCell = new Cell(cellX*Cell.getWidth(), cellY*Cell.getHeight());
        snake.add(firstCell);
        Main.log.info("Új kígyó létrehozva: " + cellX*Cell.getWidth()+" "+cellY*Cell.getHeight());
        Snake.direction = "RIGHT";
    }

    /**
     * Visszaadja a kígyót.
     *
     * @return A kígyót alkotó kígyósejtek listáját.
     * @see Cell
     */
    public static ArrayList<Cell> getSnake() {
        return snake;
    }

    /**
     * Megvizsgálja hogy a kigyó érvénytelen területre navigált-e.
     * Ellenőrízi, hogy ütközött-e a falakkal vagy magával.
     *
     * @return {@code true}: érvénytelen területre navigált a kígyó, {@code false}: a kígyó érvényes területen tartózkodik.
     */
    private boolean isInvalidArea() {
        for (int i = 1; i <= snake.size() - 1; i++) {
            if (snake.get(0).getX() == snake.get(i).getX() && snake.get(0).getY() == snake.get(i).getY()) {
                return true;
            }
        }

        if (snake.get(0).getX() < 0 || snake.get(0).getX() > Game.getWIDTH() - 20 ||
                snake.get(0).getY() < 0 || snake.get(0).getY() > Game.getHEIGHT() - 20) {
            return true;
        }
        return false;
    }

    /**
     * Visszaadja a következő kígyósejtet a megfelelő pozícióval.
     *
     * @return A kígyósejt egy új példánya.
     * @see Cell
     */
    private Cell getNextCell() {
        switch (direction) {
            case "LEFT":
                return new Cell(snake.get(snake.size() - 1).getX() + 20, snake.get(snake.size() - 1).getY());
            case "RIGHT":
                return new Cell(snake.get(snake.size() - 1).getX() - 20, snake.get(snake.size() - 1).getY());
            case "UP":
                return new Cell(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY() + 20);
            case "DOWN":
                return new Cell(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY() - 20);
        }
        return null;
    }

    /**
     * A kigyó mozgatásáért felel.
     *
     *
     * @param food A pályán lévő kaja objektum.
     * @return  {@code true}: A kigyó frissítése folytatódhat.
     *          {@code false}: A kígyó frissítésének befejezése, ami a játék befejezéséhez vezet.
     */
    public boolean update(Food food) {
        for (int i = snake.size() - 1; i >= 0; --i) {
            if (i == 0) {
                switch (direction) {
                    case "LEFT":
                        snake.get(0).setX(snake.get(0).getX() - 20);
                        break;
                    case "RIGHT":
                        snake.get(0).setX(snake.get(0).getX() + 20);
                        break;
                    case "UP":
                        snake.get(0).setY(snake.get(0).getY() - 20);
                        break;
                    case "DOWN":
                        snake.get(0).setY(snake.get(0).getY() + 20);
                        break;
                }
            } else {
                snake.get(i).setX(snake.get(i - 1).getX());
                snake.get(i).setY(snake.get(i - 1).getY());
            }
        }
        if (snake.get(0).getX() == food.getX() && snake.get(0).getY() == food.getY()) {
            food.setEated(true);
            Cell newCell = getNextCell();
            snake.add(newCell);
        }
        if(isInvalidArea()) {
            return false;
        }
        return true;
    }

    /**
     * Az eljárás beállítja a kígyó irányát.
     * Ha az új irány a jelenlegi irány ellentéte, akkor az eljárás nem csinál semmit.
     *
     * @param direction A kígyó új iránya.
     * @see Snake
     */
    public void setDirection(String direction) {
        switch (Snake.direction){
            case "RIGHT":
                if (direction.equals("LEFT")){
                    break;
                } else {
                    Snake.direction = direction;
                }
            case "LEFT":
                if (direction.equals("RIGHT")){
                    break;
                } else {
                    Snake.direction = direction;
                }
            case "UP":
                if (direction.equals("DOWN")){
                    break;
                } else {
                    Snake.direction = direction;
                }
            case "DOWN":
                if (direction.equals("UP")){
                    break;
                } else {
                    Snake.direction = direction;
                }
        }
    }
}
