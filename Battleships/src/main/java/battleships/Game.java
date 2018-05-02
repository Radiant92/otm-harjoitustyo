/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

/**
 * Sets up and handles the current situation of the game. Provides methods which
 * handle commands from the UI and returns information from current game.
 *
 * @author strohm
 */
public class Game {

    private Board board;
    private Shipyard shipyard;
    private int turns;

    /**
     * Constructor which creates a a new game based on the difficulty parameter.
     *
     * @param difficulty defines board size, ship variation, ship count and
     * turns given to user.
     */
    public Game(int difficulty) {
        this.board = new Board(difficulty);
        this.shipyard = new Shipyard();

        if (difficulty == 6) {
            for (int i = 0; i < 3; i++) {
                board.setLine(shipyard);
            }
            this.turns = 10;

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

    /**
     * Calls Shipyard method areAllSunken() and return said boolean value to
     * determine if game has been won.
     *
     * @return method returns true if shipyard has no functional ships left.
     */
    public boolean didYouWin() {
        return shipyard.areAllSunken();
    }

    /**
     * If the turns of the current game go to 0 or below method will return
     * true.
     *
     * @return method returns true if turns is 0 or below.
     */
    public boolean didYouLose() {
        if (turns <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Method hit checks if coordinates sent by the user through the UI have hit
     * or missed a ship on the board. A hit or a miss will be marked on the
     * board and return a message to the UI of either "strike" for a hit on a
     * ship or a "miss" for a miss. in case of a hit on a area that has already
     * been hit the method will just return "nothing".
     *
     * Striking or doing nothing does not take a turn.
     *
     * Hitting a ship will retrieve shipId from the board by calling the Board
     * method getShips(). The method then calls
     * shipyard.getShip(shipId).getSection(x, y).hit() witch retrieves the ship
     * corresponding to the shipId and marks it's shipSection as hit witch
     * matches with the parameters x and y coordinates.
     *
     * Missing a ship will lower the amount of turns left by 1.
     *
     * @param x coordinate x where board is hit.
     * @param y coordinate y where board is hit.
     * @return a String representation of the user either hitting, missing or
     * doing nothing on the board.
     */
    public String hit(int x, int y) {
        if (this.board.getBoard()[x][y] == 1) {
            this.board.getBoard()[x][y] = 2;
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
