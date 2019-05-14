package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.Game;
import model.Cell;
import model.Player;
import model.Toplist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Controller {

    @FXML
    private Canvas canvas;

    @FXML
    private Pane menuPane;
    @FXML
    private Pane gamePane;
    @FXML
    private Pane endGamePane;
    @FXML
    private Pane toplistPane;

    @FXML
    private Label alertText;

    @FXML
    private TextField inputPlayerField;

    @FXML
    private TableView tab;

    private Game game;
    private Toplist toplist = new Toplist();
    private Image food = new Image(String.valueOf(getClass().getResource("/images/food.gif")));
    public Logger log = LoggerFactory.getLogger(String.valueOf(getClass().getResource("/log4j2.xml")));

    @FXML
    public void initialize() {
        TableColumn<Player,String> playerNameColumn = new TableColumn<>("Name");
        playerNameColumn.setCellValueFactory(new PropertyValueFactory<>("playerName"));
        playerNameColumn.setSortable(false);

        TableColumn<Object, Object> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        scoreColumn.setSortable(false);

        TableColumn<Object, Object> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateColumn.setSortable(false);

        tab.getColumns().addAll(playerNameColumn, scoreColumn, dateColumn);

        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void startButton(ActionEvent event) {
        log.info("Megnyomtad a Start gombot.");
        game = new Game(canvas.getWidth(), canvas.getHeight());
        menuPane.setVisible(false);
        gamePane.setVisible(true);
        canvas.setFocusTraversable(true);
        draw();
    }

    @FXML
    private void toplistButton(ActionEvent event) {
        log.info("Megnyomtad a toplista gombot");
        tab.getItems().clear();
        List<Player> players = Toplist.getAll();

        for (int i = 0; i < players.size(); i++) {
            Player player = new Player(
                    players.get(i).getPlayerName(),
                    players.get(i).getScore(),
                    players.get(i).getDate()
            );
            tab.getItems().addAll(player);
        }
        toplistPane.setVisible(true);
        players.clear();
    }
    @FXML
    private void exitGameButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void addToplistButton(ActionEvent event) {
        log.info("Az eredmény felkerült a toplistára");
        String playerName = inputPlayerField.getText();
        String date = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime());
        toplist.newRecord(playerName, game.getScore(), date);
        endGamePane.setVisible(false);
        gamePane.setVisible(false);
        menuPane.setVisible(true);
    }
    @FXML
    private void backMenuButton(ActionEvent event) {
        log.info("Lenyomva - Vissza a menübe");
        endGamePane.setVisible(false);
        gamePane.setVisible(false);
        toplistPane.setVisible(false);
        menuPane.setVisible(true);
    }

    @FXML
    private void keyHandler(KeyEvent keyCode) throws InterruptedException {
        if (keyCode.getCode().equals(KeyCode.D)) {
            Game.snake.setDirection("RIGHT");
            TimeUnit.MILLISECONDS.sleep(100);
        }
        else if(keyCode.getCode().equals(KeyCode.A)) {
            Game.snake.setDirection("LEFT");
            TimeUnit.MILLISECONDS.sleep(100);
        }
        else if(keyCode.getCode().equals(KeyCode.W)) {
            Game.snake.setDirection("UP");
            TimeUnit.MILLISECONDS.sleep(100);
        }
        else if(keyCode.getCode().equals(KeyCode.S)) {
            Game.snake.setDirection("DOWN");
            TimeUnit.MILLISECONDS.sleep(100);
        };
    }

    private void draw(){
        Timeline timeline  = new Timeline(60);
        try {
            int delay = 100;
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(delay), (ActionEvent event) -> {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                if (!game.isGameOver()) {
                    gc.setFill(Color.GRAY);
                    gc.fillRect(0, 0, 1020, 760);
                    gc.setLineWidth(3.0);
                    gc.setFill(Color.BLACK);
                    gc.strokeRect(0, 0, 1020, 760);

                    for (int j = 0; j < Game.snake.getSnake().size(); j++) {
                        gc.setFill(Color.BLUE);
                        gc.fillRect(Game.snake.getSnake().get(j).getX(), Game.snake.getSnake().get(j).getY(), Cell.getWidth(), Cell.getHeight());
                    }
                    gc.setFill(Color.BLUE);
                    gc.drawImage(food, Game.food.getX(), Game.food.getY() );
                } else {
                    log.info("Vége a játéknak");
                    alertText.setText("Vége a játéknak, "+game.getScore()+ " pontot szereztél. Szeretnél felkerülni a toplistára?");
                    log.info("A pontod: " + game.getScore());
                    endGamePane.setVisible(true);

                    int size = Game.snake.getSnake().size();
                    for (int j = 0; j < size; j++) {
                        gc.setFill(Color.RED);
                        gc.fillRect(Game.snake.getSnake().get(j).getX(), Game.snake.getSnake().get(j).getY(), Cell.getWidth(), Cell.getHeight());
                    }
                    timeline.stop();
                    Game.snake.getSnake().clear();
                }
            }
            ));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        } catch  (Exception e) {
            log.debug("Error in Controller.draw(): " + e);
        }
    }
}