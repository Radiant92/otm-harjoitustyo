/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Battleships;

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
        this.shipyard = new Shipyard(3, 3, 3);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void shipyardHasntSunken(){
        assertTrue(this.shipyard.areAllSunken() == false);
    }
    @Test
    public void allShipsSunkenTrue(){
        Shipyard sunken = new Shipyard(0, 0, 0);
        assertTrue(sunken.areAllSunken());
    }
}
