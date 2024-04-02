package org.example.compulsory;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class PositionalGameGUI {

    private final BorderPane root;
    private int numLines = 5;
    private int numColumns = 5;
    private final Canvas canvas;

    public PositionalGameGUI() {
        root = new BorderPane();
        root.setPadding(new Insets(10));

        HBox configPanel = new HBox(10);
        configPanel.setPadding(new Insets(5));


        Label numLinesLabel = new Label("Num Lines:");
        TextField numLinesField = new TextField(Integer.toString(numLines));

        Button decrementLinesButton = new Button("-");
        decrementLinesButton.setOnAction(e -> {
            numLines = Math.max(1, numLines - 1);
            numLinesField.setText(Integer.toString(numLines));
            drawBoard();
        });
        Button incrementLinesButton = new Button("+");
        incrementLinesButton.setOnAction(e -> {
            numLines++;
            numLinesField.setText(Integer.toString(numLines));
            drawBoard();
        });

        HBox numLinesBox = new HBox(5);
        numLinesBox.getChildren().addAll(numLinesLabel, numLinesField, decrementLinesButton, incrementLinesButton);

        Label numColumnsLabel = new Label("Num Columns:");
        TextField numColumnsField = new TextField(Integer.toString(numColumns));

        Button decrementColumnsButton = new Button("-");
        decrementColumnsButton.setOnAction(e -> {
            numColumns = Math.max(1, numColumns - 1);
            numColumnsField.setText(Integer.toString(numColumns));
            drawBoard();
        });
        Button incrementColumnsButton = new Button("+");
        incrementColumnsButton.setOnAction(e -> {
            numColumns++;
            numColumnsField.setText(Integer.toString(numColumns));
            drawBoard();
        });

        HBox numColumnsBox = new HBox(5);
        numColumnsBox.getChildren().addAll(numColumnsLabel, numColumnsField,decrementColumnsButton, incrementColumnsButton);

        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> {
            numLines = Integer.parseInt(numLinesField.getText());
            numColumns = Integer.parseInt(numColumnsField.getText());
            drawBoard();
        });
        configPanel.getChildren().addAll(numLinesBox, numColumnsBox, newGameButton);
        root.setTop(configPanel);


        canvas = new Canvas(400, 400);
        root.setCenter(canvas);


        HBox controlPanel = new HBox(10);
        controlPanel.setPadding(new Insets(5));
        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");
        controlPanel.getChildren().addAll(loadButton, saveButton, exitButton);
        root.setBottom(controlPanel);


        drawBoard();
    }

    public BorderPane getRoot() {
        return root;
    }

    private void drawBoard() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double cellWidth = canvas.getWidth() / numColumns;
        double cellHeight = canvas.getHeight() / numLines;


        gc.setStroke(Color.BLACK);
        for (int i = 0; i <= numColumns; i++) {
            double x = i * cellWidth;
            gc.strokeLine(x, 0, x, canvas.getHeight());
        }
        for (int j = 0; j <= numLines; j++) {
            double y = j * cellHeight;
            gc.strokeLine(0, y, canvas.getWidth(), y);
        }
    }
}
