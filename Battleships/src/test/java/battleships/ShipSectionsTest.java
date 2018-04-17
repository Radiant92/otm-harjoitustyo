/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleships;

import battleships.ShipSection;
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
public class ShipSectionsTest {
    
    ShipSection shipSection;
    
    public ShipSectionsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.shipSection = new ShipSection(1, 3, 3);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getX() {
        assertTrue(shipSection.getX() == 3);
    }

    @Test
    public void getY() {
        assertTrue(shipSection.getY() == 3);
        
    }

    @Test
    public void atStartShipSectionIsIntact() {
        assertTrue(shipSection.isIntact());
    }

    @Test
    public void hitShipIsNotIntact() {
        shipSection.hit();
        assertTrue(shipSection.isIntact() == false);
    }
    
    @Test
    public void getId() {
        assertTrue(shipSection.getShipId() == 1);
    }
    
}
