/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

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
public class UsersTest {

    private User novice;
    private User veteran;

    public UsersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        veteran = new User("veteran", 2, 4, 5);
        novice = new User("novice", 0, 0, 0);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void usersAreCreatedWithTheirWinsCorrectly() {
        assertTrue(veteran.getWinsEasy() == 2);
        assertTrue(veteran.getWinsNormal() == 4);
        assertTrue(veteran.getWinsHard() == 5);
    }

    @Test
    public void addingAEasyWinWorks() {
        novice.winEasy();
        assertTrue(novice.getWinsEasy() == 1);
    }

    @Test
    public void addingANormalWinWorks() {
        novice.winNormal();
        assertTrue(novice.getWinsNormal() == 1);
    }

    @Test
    public void addingAHardWinWorks() {
        novice.winHard();
        assertTrue(novice.getWinsHard() == 1);
    }

    @Test
    public void getName() {
        assertEquals("novice", this.novice.getName());
    }

}
