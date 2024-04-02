package org.example.compulsory;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.compulsory.PositionalGameGUI;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        PositionalGameGUI gameGUI = new PositionalGameGUI();
        Scene scene = new Scene(gameGUI.getRoot(), 600, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Positional Game");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}