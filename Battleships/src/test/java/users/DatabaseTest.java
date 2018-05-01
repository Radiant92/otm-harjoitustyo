/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.FileWriter;
import java.io.PrintWriter;
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
public class DatabaseTest {

    private Database database;
    private Database fullData;

    public DatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {

        this.database = new Database("test.txt");
        this.fullData = new Database("fulltest.txt");
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
    public void addingUserWorks() throws Exception {
        this.database.addUser("test");
        assertTrue(this.database.getUsers().size() == 1);
        PrintWriter writer = new PrintWriter("test.txt");
        writer.print("");
        writer.close();
    }

    @Test
    public void savingWorks() throws Exception {
        this.database.addUser("test");
        this.database.addUser("tester");

        Database base = new Database("test.txt");
        assertEquals("test", base.getUsers().get(0).getName());
        assertEquals("tester", base.getUsers().get(1).getName());

        PrintWriter writer = new PrintWriter("test.txt");
        writer.print("");
        writer.close();

    }

    @Test
    public void top5Easy() {

        assertEquals("milla", fullData.getTopEasy().get(0).getName());
        assertEquals("vilma", fullData.getTopEasy().get(1).getName());
        assertEquals("markus", fullData.getTopEasy().get(2).getName());
        assertEquals("radiant", fullData.getTopEasy().get(3).getName());
        assertEquals("silakka", fullData.getTopEasy().get(4).getName());
    }

    @Test
    public void top5Normal() {
        assertEquals("vilma", fullData.getTopNormal().get(0).getName());
        assertEquals("silakka", fullData.getTopNormal().get(1).getName());
        assertEquals("marty", fullData.getTopNormal().get(2).getName());
        assertEquals("kalle", fullData.getTopNormal().get(3).getName());
        assertEquals("markus", fullData.getTopNormal().get(4).getName());
    }

    @Test
    public void top5Hard() {
        assertEquals("radiant", fullData.getTopHard().get(0).getName());
        assertEquals("marty", fullData.getTopHard().get(1).getName());
        assertEquals("vilma", fullData.getTopHard().get(2).getName());
        assertEquals("markus", fullData.getTopHard().get(3).getName());
        assertEquals("silakka", fullData.getTopHard().get(4).getName());
    }

}
