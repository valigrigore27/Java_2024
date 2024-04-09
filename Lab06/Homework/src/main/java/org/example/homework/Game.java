package org.example.homework;

import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Random;

public class Game {
    private final BorderPane root;
    private final Board board;
    private boolean player1Turn;
    private final Canvas canvas;
    private int squareSize = 3;

    public Game() {
        root = new BorderPane();
        root.setPadding(new Insets(10));

        board = new Board(5, 5);
        player1Turn = true;

        HBox configPanel = new HBox(10);
        configPanel.setPadding(new Insets(5));

        Label numLinesLabel = new Label("Num Lines:");
        TextField numLinesField = new TextField(Integer.toString(board.getNumLines()));

        Button decrementLinesButton = new Button("-");
        decrementLinesButton.setOnAction(e -> {
            board.setNumLines(Math.max(1, board.getNumLines()) - 1);
            numLinesField.setText(Integer.toString(board.getNumLines()));
            //redrawBoardWidth();
            //redrawBoardNormal();
        });
        Button incrementLinesButton = new Button("+");
        incrementLinesButton.setOnAction(e -> {
            board.setNumLines(board.getNumLines() + 1);
            numLinesField.setText(Integer.toString(board.getNumLines()));
            //redrawBoardWidth();
            //redrawBoardNormal();
        });

        HBox numLinesBox = new HBox(5);
        numLinesBox.getChildren().addAll(numLinesLabel, numLinesField, decrementLinesButton, incrementLinesButton);

        Label numColumnsLabel = new Label("Num Columns:");
        TextField numColumnsField = new TextField(Integer.toString(board.getNumColumns()));

        Button decrementColumnsButton = new Button("-");
        decrementColumnsButton.setOnAction(e -> {
            board.setNumColumns(Math.max(1, board.getNumColumns()) - 1);
            numColumnsField.setText(Integer.toString(board.getNumColumns()));
            //redrawBoardWidth();
            //redrawBoardNormal();
        });
        Button incrementColumnsButton = new Button("+");
        incrementColumnsButton.setOnAction(e -> {
            board.setNumColumns(board.getNumColumns() + 1);
            numColumnsField.setText(Integer.toString(board.getNumColumns()));
            //redrawBoardWidth();
            //redrawBoardNormal();
        });

        HBox numColumnsBox = new HBox(5);
        numColumnsBox.getChildren().addAll(numColumnsLabel, numColumnsField, decrementColumnsButton, incrementColumnsButton);

        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> {
            board.setNumLines(Integer.parseInt(numLinesField.getText()));
            board.setNumColumns(Integer.parseInt(numColumnsField.getText()));
            board.resetBoard(board.getNumLines(), board.getNumColumns());
            //redrawBoardWidth();
            //redrawBoardNormal();
        });
        configPanel.getChildren().addAll(numLinesBox, numColumnsBox, newGameButton);
        root.setTop(configPanel);

        canvas = new Canvas(400, 400);
        root.setCenter(canvas);

        HBox controlPanel = new HBox(10);
        controlPanel.setPadding(new Insets(5));
        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");
        Button exportButton = new Button("Export to PNG");

        saveButton.setOnAction(e -> {

            System.out.println("Save button pressed");
            saveGame("saved_game.txt");
        });
        exitButton.setOnAction(e -> {
            System.out.println("Exit button pressed");
            System.exit(0);
        });
        exportButton.setOnAction(e -> exportCanvasToPNG("game_board"));

        controlPanel.getChildren().addAll(saveButton, exitButton, exportButton);
        root.setBottom(controlPanel);

        redrawBoardNormal();
        //redrawBoardWidth();
        canvas.setOnMouseClicked(this::handleMouseClick);
    }

    public BorderPane getRoot() {
        return root;
    }

    private void redrawBoardNormal() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double cellWidth = canvas.getWidth() / board.getNumColumns();
        double cellHeight = canvas.getHeight() / board.getNumLines();

        gc.setStroke(Color.BLACK);
        for (int i = 0; i <= board.getNumColumns(); i++) {
            double x = i * cellWidth;
            gc.strokeLine(x, 0, x, canvas.getHeight());
        }
        for (int j = 0; j <= board.getNumLines(); j++) {
            double y = j * cellHeight;
            gc.strokeLine(0, y, canvas.getWidth(), y);
        }


        gc.setStroke(Color.BLACK);
        gc.setLineWidth(6);
        int startX = (board.getNumColumns() - squareSize) / 2;
        int startY = (board.getNumLines() - squareSize) / 2;
        double x = startX * cellWidth;
        double y = startY * cellHeight;
        double width = squareSize * cellWidth;
        double height = squareSize * cellHeight;

        gc.strokeRect(x, y, width, height);

        for (int i = 1; i < squareSize; i++) {
            gc.strokeLine(x + i * cellWidth, y, x + i * cellWidth, y + height);
            gc.strokeLine(x, y + i * cellHeight, x + width, y + i * cellHeight);
        }

        if (isSquareOccupied(startX, startY, squareSize)) {
            String winner = player1Turn ? "Player 1" : "Player 2";
            showAlert(Alert.AlertType.INFORMATION, "Winner", winner + " wins!");
            System.exit(0);
        }
    }

    private void handleMouseClick(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();

        double cellWidth = canvas.getWidth() / board.getNumColumns();
        double cellHeight = canvas.getHeight() / board.getNumLines();

        int column = (int) (mouseX / cellWidth);
        int row = (int) (mouseY / cellHeight);

        if (isValidMove(row, column)) {
            drawStone(row, column);


            int startX = Math.max(0, column - (squareSize - 1) / 2);
            int startY = Math.max(0, row - (squareSize - 1) / 2);
            if (isSquareOccupied(startX, startY, squareSize)) {
                String winner = player1Turn ? "Player 1" : "Player 2";
                showAlert(Alert.AlertType.INFORMATION, "Winner", winner + " wins!");
                System.exit(0);
                return;
            }

            player1Turn = !player1Turn;
        }
    }

    private boolean isSquareOccupied(int startX, int startY, int squareSize) {
        for (int i = startX; i < startX + squareSize; i++) {
            for (int j = startY; j < startY + squareSize; j++) {
                if (!board.isStoneAt(j, i)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValidMove(int row, int column) {
        return row >= 0 && row < board.getNumLines() &&
                column >= 0 && column < board.getNumColumns() &&
                !board.isStoneAt(row, column);
    }
    private void drawStone(int row, int column) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        double cellWidth = canvas.getWidth() / board.getNumColumns();
        double cellHeight = canvas.getHeight() / board.getNumLines();

        double x = column * cellWidth + cellWidth / 2;
        double y = row * cellHeight + cellHeight / 2;

        gc.setFill(player1Turn ? Color.RED : Color.BLUE);
        gc.fillOval(x+ cellWidth * Math.sqrt(2) / 4, y + cellWidth * Math.sqrt(2) / 4, 30, 30);
        board.getIntersection(row, column).placeStone();
    }
    public void exportCanvasToPNG(String fileName) {
        WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
        canvas.snapshot(new SnapshotParameters(), writableImage);

        File file = new File(fileName + ".png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            showAlert(Alert.AlertType.INFORMATION, "Export successful", "The image was exported successfully to " + fileName + ".png");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Export failed", "An error occurred while exporting the image: " + e.getMessage());
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public void saveGame(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(board);

            showAlert(Alert.AlertType.INFORMATION, "Game Saved", "The game has been saved successfully.");
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to save the game: " + e.getMessage());
        }
    }

}