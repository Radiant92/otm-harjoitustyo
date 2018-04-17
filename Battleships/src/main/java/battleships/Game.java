/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

/**
 *
 * @author strohm
 */
public class Game {

    private Board board;
    private Shipyard shipyard;
    private int turns;

    public Game(int difficulty) {
        this.board = new Board(difficulty);
        this.shipyard = new Shipyard();

        if (difficulty == 6) {
            for (int i = 0; i < 3; i++) {
                board.setLine(shipyard);
            }
            this.turns = 15;

        } else if (difficulty == 8) {
            for (int i = 0; i < 3; i++) {
                board.setlShip(shipyard);
                board.setLine(shipyard);
            }
            this.turns = 20;

        } else {
            for (int i = 0; i < 3; i++) {
                board.setuShip(shipyard);
                board.setlShip(shipyard);
                board.setLine(shipyard);
            }
            this.turns = 25;
        }
    }

    public boolean didYouWin() {
        return shipyard.areAllSunken();
    }

    public boolean didYouLose() {
        if (turns <= 0) {
            return true;
        }
        return false;
    }

    public String hit(int x, int y) {
        if (this.board.getBoard()[x][y] == 1) {
            this.board.gotHit(x, y);
            int shipId = this.board.getShips().get(x + " " + y);
            shipyard.getShip(shipId).getSection(x, y).hit();
            return "strike";
        } else if (this.board.getBoard()[x][y] == 0) {
            this.board.getBoard()[x][y] = 3;
            this.turns--;
            return "miss";
        }
        return "nothing";
    }

    public int getTurns() {
        return turns;
    }

    public int getLineShips() {
        return shipyard.getLine();
    }

    public int getLShips() {
        return shipyard.getlShape();
    }

    public int getUShips() {
        return shipyard.getuShape();
    }

    public Board getBoard() {
        return this.board;
    }

}
