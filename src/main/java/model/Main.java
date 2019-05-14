package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author  Adam Micura
 * @version 1.0
 * @since   2019.03-31
 */

/**
 * Az {@link model.Main} osztály reprezentálja a teljes programot.
 */
public class Main extends Application {
    public static final Logger log = LoggerFactory.getLogger(String.valueOf(Main.class.getResource("/log4j2.xml")));

    @Override
    public void start(Stage primaryStage) throws IOException {
        log.info("Start Snake-Game JavaFX program");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/View.fxml"));
        Scene scene = new Scene(root, 1020, 760);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("/styles/style.css")));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Ez a statikus eljárás a program belépési pontjának felel meg.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
