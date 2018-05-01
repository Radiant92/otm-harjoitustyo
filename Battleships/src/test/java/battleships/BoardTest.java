/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author strohm
 */
public class BoardTest {

    Board board;
    Shipyard shipyard;

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.board = new Board(20);
        this.shipyard = new Shipyard();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void constructorCreatesNewBoard() {
        assertTrue(this.board.getBoard().length == 20);
    }

    @Test
    public void newBoardIsEmpty() {
        boolean empty = true;
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                if (this.board.getBoard()[y][x] != 0) {
                    empty = false;
                }
            }
        }
        assertTrue(empty == true);
    }

    @Test
    public void settingLinesWorks() {
        this.board.setLine(shipyard);
        assertTrue(shipyard.getLine() == 1);
        assertTrue(this.board.getShips().containsValue(1));
    }

    @Test
    public void settingLShapeWorks() {
        this.board.setlShip(shipyard);
        assertTrue(shipyard.getlShape() == 1);
        assertTrue(this.board.getShips().containsValue(1));
    }

    @Test
    public void settingUShapesWorks() {
        this.board.setuShip(shipyard);
        assertTrue(shipyard.getuShape() == 1);
        assertTrue(this.board.getShips().containsValue(1));
    }

    @Test
    public void gettingHitWorks() {
        this.board.gotHit(0, 0);
        assertTrue(this.board.getBoard()[0][0] == 2);
    }

}
