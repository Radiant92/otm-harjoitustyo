/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import battleships.Game;
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
public class GameTest {

    Game easy;
    Game normal;
    Game hard;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.easy = new Game(6);
        this.normal = new Game(8);
        this.hard = new Game(10);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void didYouWinAtBeginningFalse() {
        assertTrue(this.easy.didYouWin() == false);
    }

    @Test
    public void didYouLoseAtBeginningFalse() {
        assertTrue(this.easy.didYouLose() == false);
    }

    @Test
    public void turnsAreCorrectAtBeginning() {
        assertTrue(this.easy.getTurns() == 15);
        assertTrue(this.normal.getTurns() == 20);
        assertTrue(this.hard.getTurns() == 25);
    }

    @Test
    public void getLineShipsMoreThanZero() {
        for (int i = 0; i < 10000; i++) {
            Game newGame = new Game(10);
            assertTrue(newGame.getLineShips() > 0);
        }
    }

    @Test
    public void getLShipsMoreThanZero() {
        for (int i = 0; i < 10000; i++) {
            Game newGame = new Game(10);
            assertTrue(newGame.getLShips() > 0);
        }
    }

    @Test
    public void getUShipsMoreThanZero() {
        for (int i = 0; i < 10000; i++) {
            Game newGame = new Game(10);
            assertTrue(newGame.getUShips() > 0);
        }

    }

    @Test
    public void hitReturnsCorrectResponse() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (hard.getBoard().getBoard()[x][y] == 1) {
                    assertEquals("strike", hard.hit(x, y));
                } else if (hard.getBoard().getBoard()[x][y] == 0) {
                    assertEquals("miss", hard.hit(x, y));
                } else {
                    assertEquals("nothing", hard.hit(x, y));
                }
            }
        }
    }

    @Test
    public void gettingAMissLowersTurns() {
        int turns = 25;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (hard.getBoard().getBoard()[x][y] == 0) {
                    hard.hit(x, y);
                    turns--;
                    assertTrue(hard.getTurns() == turns);

                }
            }

        }
    }
}
