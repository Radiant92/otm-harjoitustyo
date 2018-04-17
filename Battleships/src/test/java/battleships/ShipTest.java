/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import battleships.Ship;
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

    Ship lineShip;
    Ship lShip;
    Ship uShip;
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
        this.lineShip = new Ship(10, "line", 1, 1);
        this.lShip = new Ship(10, "lShip", 1, 1);
        this.uShip = new Ship(10, "uShip", 1, 1);
        list = new ArrayList();
        list.add("line");
        list.add("uShip");
        list.add("lShip");

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getX() {
        assertTrue(this.lineShip.getHeadX() == 1);
    }

    @Test
    public void getY() {
        assertTrue(this.lineShip.getHeadY() == 1);
    }

    @Test
    public void getID() {
        assertTrue(this.lineShip.getId() == 10);
    }

    @Test
    public void shipIsNotSunkenAtTheBeginning() {
        assertTrue(this.lineShip.isSunken() == false);
    }

    @Test
    public void formIsValid() {
        assertTrue(list.contains(this.lineShip.getForm()));
        assertTrue(list.contains(this.lShip.getForm()));
        assertTrue(list.contains(this.uShip.getForm()));
    }

    @Test
    public void getSectionsReturnsProperNumberOfSections() {
        assertTrue(lineShip.getSections().size() == 3);
        assertTrue(lShip.getSections().size() == 5);
        assertTrue(uShip.getSections().size() == 7);
    }

    @Test
    public void BuildShipWorksForLine() {
        for (int i = 0; i < 3; i++) {
            assertTrue(this.lineShip.getSection(1, 1 + i) != null);
        }
    }

    @Test
    public void buildShipWorksForLShip() {
        for (int i = 0; i < 3; i++) {
            assertTrue(this.lShip.getSection(1, 1 + i) != null);
        }
        for (int i = 1; i < 3; i++) {
            assertTrue(lShip.getSection(1 + i, 3) != null);
        }
    }

    @Test
    public void buildShipWorksForUShip() {
        for (int i = 0; i < 3; i++) {
            assertTrue(this.uShip.getSection(1, 1 + i) != null);
            assertTrue(this.uShip.getSection(3, 1 + i) != null);
        }
        assertTrue(this.uShip.getSection(2, 3) != null);
    }

}
