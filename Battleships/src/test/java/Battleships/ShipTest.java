/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleships;

import java.util.*;
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
public class ShipTest {

    Ship ship;
    List<String> list;

    public ShipTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.ship = new Ship(10, "line");
        list = new ArrayList();
        list.add("line");
        list.add("uShip");
        list.add("lShip");
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shipSizeIsCorrect() {
        assertTrue(this.ship.getSize() == 10);
    }

    @Test
    public void shipIsNotSunkenAtTheBeginning() {
        assertTrue(this.ship.isSunken() == false);
    }

    @Test
    public void formIsValid() {
        assertTrue(list.contains(this.ship.getForm()));
    }

}
