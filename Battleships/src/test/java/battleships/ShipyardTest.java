/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import battleships.Shipyard;
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
public class ShipyardTest {

    Shipyard shipyard;

    public ShipyardTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.shipyard = new Shipyard();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void AllAreSunkenInBeginning() {
        assertTrue(this.shipyard.areAllSunken());
    }

    @Test
    public void ifLineShipExistsAllAreNotSunken() {
        this.shipyard.buildShip(1, 1, 1, "line");
        assertTrue(this.shipyard.areAllSunken() == false);
    }

    @Test
    public void ifLShipExistsAllAreNotSunken() {
        this.shipyard.buildShip(1, 1, 1, "lShip");
        assertTrue(this.shipyard.areAllSunken() == false);
    }

    @Test
    public void ifUShipExistsAllAreNotSunken() {
        this.shipyard.buildShip(1, 1, 1, "uShip");
        assertTrue(this.shipyard.areAllSunken() == false);
    }

    @Test
    public void getShipsAreZeroInBeginning() {
        assertTrue(this.shipyard.getLine() == 0);
        assertTrue(this.shipyard.getuShape() == 0);
        assertTrue(this.shipyard.getlShape() == 0);
    }

    @Test
    public void buildingShipsWork() {
        this.shipyard.buildShip(1, 0, 0, "line");
        this.shipyard.buildShip(2, 4, 4, "lShip");
        this.shipyard.buildShip(3, 9, 9, "uShip");

        assertTrue(this.shipyard.getLine() == 1);
        assertTrue(this.shipyard.getlShape() == 1);
        assertTrue(this.shipyard.getuShape() == 1);
    }

    @Test
    public void getShipWorks() {
        this.shipyard.buildShip(0, 0, 0, "line");
        assertTrue(this.shipyard.getShip(0) != null);
    }

    @Test
    public void getShipWithWrongIdReturnsNull() {
        this.shipyard.buildShip(0, 0, 0, "line");
        assertTrue(this.shipyard.getShip(1) == null);
    }

}
