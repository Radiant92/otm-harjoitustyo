/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleshipsUI;

import Battleships.*;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author strohm
 */
public class BattleshipsUI extends Application {

    private static GridPane board;
    private static Game newGame;
    private static BorderPane game;
    private static boolean loser;
    private static boolean winner;

    @Override
    public void start(Stage window) {

        BorderPane setup = new BorderPane();
        game = new BorderPane();
        board = new GridPane();
        board.setPrefSize(500, 500);

        HBox buttons = new HBox();
        buttons.setSpacing(20);

        Button easy = new Button("EASY");
        Button normal = new Button("NORMAL");
        Button hard = new Button("HARD");

        buttons.getChildren().add(easy);
        buttons.getChildren().add(normal);
        buttons.getChildren().add(hard);
        setup.setCenter(buttons);

        Scene menu = new Scene(setup);
        Scene gameScreen = new Scene(game);

        easy.setOnAction((event) -> {
            newGame = new Game(6);

            makeBoard(6);
            board.setPadding(new Insets(10, 10, 10, 10));
            game.setCenter(board);
            window.setScene(gameScreen);
        });

        /* normal.setOnAction((event) -> {
            newGame = new Game(8);
            makeBoard(8);
            board.setPadding(new Insets(10, 10, 10, 10));
            game.setCenter(board);
            window.setScene(gameScreen);

        });
        hard.setOnAction((event) -> {
            newGame = new Game(10);
            makeBoard(10);
            board.setPadding(new Insets(10, 10, 10, 10));
            game.setCenter(board);
            window.setScene(gameScreen);
        });
         */
        window.setScene(menu);
        window.show();

    }

    public void makeBoard(int size) {
        loser = false;
        winner = false;
        Label turns = new Label("" + newGame.getTurns());
        game.setTop(turns);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Button b = new Button(x + " - " + y);
                b.setPrefSize(50, 50);
                b.setOnMouseClicked(event -> {
                    if (loser == true) {
                        b.setText("LOSER");
                    } else if (winner == true) {

                        b.setText("WIN");
                    } else {
                        String location = b.getText();
                        if (!location.equals("O") && !location.equals("X")) {
                            String[] split = location.split("-");

                            int buttonX = Integer.parseInt(split[0].trim());

                            int buttonY = Integer.parseInt(split[1].trim());
                            String result = newGame.hit(buttonX, buttonY);

                            if (result.equals("miss")) {
                                b.setText("O");
                                turns.setText("" + newGame.getTurns());
                                if (newGame.didYouLose() == true) {
                                    loser = true;
                                }
                            } else if (result.equals("strike")) {
                                b.setText("X");
                                if (newGame.didYouWin() == true) {
                                    winner = true;
                                }
                            }
                        }
                    }
                });
                board.add(b, x, y);

            }
        }

    }

    public static void main(String[] args) {
        launch(BattleshipsUI.class);
    }
}
