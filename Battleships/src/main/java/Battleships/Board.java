/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleships;


/**
 *
 * @author strohm
 */
public class Board {

    private int[][] board;

    public Board(int size) {
        this.board = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                this.board[y][x] = 0;
          
            }
        }
    }
    public int[][] getBoard(){
        return this.board;
    }
}
