package org.example.homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.homework.Game;

import java.io.File;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Game gameGUI = new Game();

        File savedGameFile = new File("saved_game.ser");
        if (savedGameFile.exists()) {
        //gameGUI.saveGame("saved_game.ser");
        }

        Scene scene = new Scene(gameGUI.getRoot(), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
