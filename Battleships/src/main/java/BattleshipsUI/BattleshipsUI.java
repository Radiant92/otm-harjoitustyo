/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleshipsUI;

import battleships.Game;
import java.util.List;

import users.Database;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import users.User;

/**
 *
 * @author strohm
 */
public class BattleshipsUI extends Application {

    private static GridPane board;
    private static Game newGame;
    private static Database database;
    private static BorderPane game;
    private static Scene menuScreen;
    private static boolean loser;
    private static boolean winner;
    private static User user;
    private static Stage window;

    @Override
    public void start(Stage window) throws Exception {
        this.window = window;
        this.database = new Database("userfile.txt");

        BorderPane menu = new BorderPane();
        BorderPane setup = new BorderPane();
        game = new BorderPane();
        board = new GridPane();
        board.setPrefSize(500, 500);

        VBox options = new VBox();
        options.setSpacing(20);

        Label name = new Label("New player");
        TextField addField = new TextField();
        Button add = new Button("add");

        Label enter = new Label("Who is playing?");
        TextField chooseField = new TextField();
        Button choose = new Button("choose");

        options.getChildren().addAll(name, addField, add, enter, chooseField, choose);
        menu.setCenter(options);

        HBox buttons = new HBox();
        buttons.setSpacing(20);

        Button easy = new Button("EASY");
        Button normal = new Button("NORMAL");
        Button hard = new Button("HARD");

        buttons.getChildren().addAll(easy, normal, hard);

        HBox info = new HBox();
        info.setSpacing(20);

        Label userName = new Label();
        Label easyWins = new Label();
        Label normalWins = new Label();
        Label hardWins = new Label();

        info.getChildren().addAll(userName, easyWins, normalWins, hardWins);
        setup.setTop(info);
        setup.setCenter(buttons);

        menuScreen = new Scene(menu);
        Scene difficultyScreen = new Scene(setup);
        Scene gameScreen = new Scene(game);

        add.setOnAction((event) -> {
            String text = addField.getText();
            try {
                database.addUser(text);
            } catch (Exception ex) {

            }
            addField.setText("");
        });
        choose.setOnAction((event) -> {
            if (!chooseField.getText().equals("name not found") && !chooseField.getText().isEmpty()) {
                for (User us : database.getUsers()) {
                    if (us.getName().equals(chooseField.getText())) {
                        this.user = us;
                        userName.setText("Name: " + us.getName());
                        easyWins.setText("Easy wins: " + us.getWinsEasy());
                        normalWins.setText("Normal wins: " + us.getWinsNormal());
                        hardWins.setText("Hard wins: " + us.getWinsHard());

                        window.setScene(difficultyScreen);
                        break;
                    }
                }
            }
            chooseField.setText("name not found");
        });

        easy.setOnAction((event) -> {
            newGame = new Game(6);

            playGame(6);
            board.setPadding(new Insets(10, 10, 10, 10));
            game.setCenter(board);
            window.setScene(gameScreen);
        });

        normal.setOnAction((event) -> {
            newGame = new Game(8);
            playGame(8);
            board.setPadding(new Insets(10, 10, 10, 10));
            game.setCenter(board);
            window.setScene(gameScreen);

        });

        hard.setOnAction((event) -> {
            newGame = new Game(10);
            playGame(10);
            board.setPadding(new Insets(10, 10, 10, 10));
            game.setCenter(board);
            window.setScene(gameScreen);
        });

        window.setScene(menuScreen);
        window.show();

    }

    public void playGame(int size) {
        loser = false;
        winner = false;
        Label turns = new Label("" + newGame.getTurns());
        Label line = new Label("Line ships left: " + newGame.getLineShips());
        Label lShips = new Label("L-shaped ships left: " + newGame.getLShips());
        Label uShips = new Label("U-shaped ships left: " + newGame.getUShips());
        HBox labels = new HBox();
        labels.setSpacing(20);
        labels.getChildren().addAll(turns, line, lShips, uShips);
        game.setTop(labels);

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Button b = new Button(x + " - " + y);
                b.setPrefSize(50, 50);
                b.setOnMouseClicked(event -> {
                    if (loser == true) {
                        goToMenu();
                    } else if (winner == true) {

                        if (size == 6) {
                            this.user.WinEasy();
                        } else if (size == 8) {
                            this.user.WinNormal();
                        } else {
                            this.user.WinHard();
                        }
                        try {
                            this.database.save();
                        } catch (Exception ex) {

                        }
                        goToMenu();

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
                            line.setText("Line ships left: " + newGame.getLineShips());
                            lShips.setText("L-shaped ships left: " + newGame.getLShips());
                            uShips.setText("U-shaped ships left: " + newGame.getUShips());
                        }
                    }
                });
                board.add(b, x, y);

            }
        }

    }

    public static void goToMenu() {
        window.setScene(menuScreen);
    }

    public static void main(String[] args) {
        launch(BattleshipsUI.class);
    }
}
