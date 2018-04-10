/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleships;

import java.util.*;

/**
 *
 * @author strohm
 */
public class Board {

    private int[][] board;
    private Random r;
    private Map<String, Integer> ships;
    private int shipId;

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

    public Map<String, Integer> getShips() {
        return ships;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setLine(Shipyard shipyard) {

        while (true) {

            int startX = r.nextInt(board.length);
            int startY = r.nextInt(board.length - 2);
            if (board[startX][startY] == 0 && board[startX][startY + 1] == 0 && board[startX][startY + 2] == 0) {
                shipId++;
                for (int i = 0; i < 3; i++) {
                    board[startX][startY + i] = 1;
                    ships.putIfAbsent(startX + " " + (startY + i), shipId);
                }
                shipyard.buildShip(shipId, startX, startY, "line");

                break;
            }
        }

    }

    public void setlShip(Shipyard shipyard) {

    }

    public void setuShip(Shipyard shipyard) {

    }

    public void gotHit(int x, int y) {
        board[x][y] = 2;

    }
}
