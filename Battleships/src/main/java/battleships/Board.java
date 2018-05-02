/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import java.util.*;

/**
 *
 * Class witch manages the ship placement and current game situation on the game
 * board.
 *
 * @author strohm
 */
public class Board {

    private int[][] board;
    private Random r;
    private Map<String, Integer> ships;
    private int shipId;

    /**
     * Constructor that constructs an empty game board where each int[x][y]
     * coordinate of the board is 0.
     *
     * @param size determines the size of the XY board (size * size).
     */
    public Board(int size) {
        shipId = 0;
        ships = new HashMap();
        this.r = new Random();
        this.board = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                this.board[y][x] = 0;

            }
        }
    }

    /**
     *
     * @return a map of ships and their locations, where the keys are XY
     * coordinates and the values are shipId's witch inhabit said coordinates.
     * One ship may take the space of several neighbouring coordinates.
     */
    public Map<String, Integer> getShips() {
        return ships;
    }

    public int[][] getBoard() {
        return this.board;
    }

    /**
     * Attempts to fit a 3 space line ship onto the board, if successful method
     * calls drawLineShip(int x, int y, Shipyard shipyard). After 100 failed
     * attempts the method will end and the game will be absent one line ship.
     *
     * @param shipyard the shipyard where the line ship will be drawn.
     */
    public void setLine(Shipyard shipyard) {
        int attemt = 0;
        while (attemt < 100) {
            attemt++;
            int startX = r.nextInt(board.length);
            int startY = r.nextInt(board.length - 2);
            if (board[startX][startY] == 0 && board[startX][startY + 1] == 0
                    && board[startX][startY + 2] == 0) {
                drawLineShip(startX, startY, shipyard);
                break;
            }
        }

    }

    /**
     * Attempts to fit a 5 space L-shaped ship onto the board, if successful
     * method calls drawlShip(int x, int y, Shipyard shipyard). After 100 failed
     * attempts the method will end and the game will be absent one L-shaped
     * ship.
     *
     * @param shipyard the shipyard where the L-shape ship will be drawn.
     */
    public void setlShip(Shipyard shipyard) {
        int attemt = 0;
        while (attemt < 100) {
            attemt++;
            int startX = r.nextInt(board.length - 2);
            int startY = r.nextInt(board.length - 2);
            if (board[startX][startY] == 0 && board[startX][startY + 1] == 0
                    && board[startX][startY + 2] == 0
                    && board[startX + 1][startY + 2] == 0
                    && board[startX + 2][startY + 2] == 0) {
                drawlShip(startX, startY, shipyard);
                break;
            }
        }

    }

    /**
     * Attempts to fit a 7 space U-shape ship onto the board, if successful
     * method calls drawuShip(int x, int y, Shipyard shipyard). After 100 failed
     * attempts the method will end and the game will be absent one U-shaped
     * ship.
     *
     * @param shipyard the shipyard where the U-shape ship will be drawn.
     */
    public void setuShip(Shipyard shipyard) {
        int attemt = 0;
        while (attemt < 100) {
            attemt++;
            int startX = r.nextInt(board.length - 2);
            int startY = r.nextInt(board.length - 2);
            if (board[startX][startY] == 0
                    && board[startX][startY + 1] == 0
                    && board[startX][startY + 2] == 0
                    && board[startX + 1][startY + 2] == 0
                    && board[startX + 2][startY + 2] == 0
                    && board[startX + 2][startY + 1] == 0
                    && board[startX + 2][startY] == 0) {
                drawUShip(startX, startY, shipyard);
                break;
            }
        }
    }

    /**
     * Marks all the coordinates of the ship on the board as 1 meaning occupied.
     * Puts all occupied coordinates into the ships map where key is coordinates
     * and value is the ships individual shipId. afterwards method calls the
     * given shipyards method buildShip(int shipId, int x, int y, String form)
     * where form is "line".
     *
     * @param x coordinate x of ships head.
     * @param y coordinate y of ships head
     * @param shipyard shipyard where ship gets built.
     */
    public void drawLineShip(int x, int y, Shipyard shipyard) {
        shipId++;
        for (int i = 0; i < 3; i++) {
            board[x][y + i] = 1;
            ships.putIfAbsent(x + " " + (y + i), shipId);
        }
        shipyard.buildShip(shipId, x, y, "line");

    }

    /**
     * Marks all the coordinates of the ship on the board as 1 meaning occupied.
     * Puts all occupied coordinates into the ships map where key is coordinates
     * and value is the ships individual shipId. afterwards method calls the
     * given shipyards method buildShip(int shipId, int x, int y, String form)
     * where form is "lship".
     *
     * @param x coordinate x of ships head.
     * @param y coordinate y of ships head
     * @param shipyard shipyard where ship gets built.
     */
    public void drawlShip(int x, int y, Shipyard shipyard) {
        shipId++;
        for (int i = 0; i < 3; i++) {
            board[x][y + i] = 1;
            ships.putIfAbsent(x + " " + (y + i), shipId);
        }
        for (int i = 1; i < 3; i++) {
            board[x + i][y + 2] = 1;
            ships.putIfAbsent((x + i) + " " + (y + 2), shipId);
        }
        shipyard.buildShip(shipId, x, y, "lShip");
    }

    /**
     * Marks all the coordinates of the ship on the board as 1 meaning occupied.
     * Puts all occupied coordinates into the ships map where key is coordinates
     * and value is the ships individual shipId. afterwards method calls the
     * given shipyards method buildShip(int shipId, int x, int y, String form)
     * where form is "uship".
     *
     * @param x coordinate x of ships head.
     * @param y coordinate y of ships head
     * @param shipyard shipyard where ship gets built.
     */
    public void drawUShip(int x, int y, Shipyard shipyard) {
        shipId++;
        for (int i = 0; i < 3; i++) {
            board[x][y + i] = 1;
            board[x + 2][y + i] = 1;
            ships.putIfAbsent(x + " " + (y + i), shipId);
            ships.putIfAbsent((x + 2) + " " + (y + i), shipId);
        }
        board[x + 1][y + 2] = 1;
        ships.putIfAbsent((x + 1) + " " + (y + 2), shipId);

        shipyard.buildShip(shipId, x, y, "uShip");

    }
}
