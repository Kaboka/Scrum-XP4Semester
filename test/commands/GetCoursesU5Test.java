/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicklas Hemmingsen
 */
public class GetCoursesU5Test {
    
    public GetCoursesU5Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ArrayList<String> poolA = new ArrayList<>();
        ArrayList<String> poolB = new ArrayList<>();
        ArrayList<ArrayList<String>> bothPools = new ArrayList<ArrayList<String>>();
        poolA.add("#C");
        poolA.add("C++");
        poolB.add("ApllePis");
        poolB.add("HTC");
        bothPools.add(poolA);
        bothPools.add(poolB);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class GetCoursesU5.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        HttpServletRequest request = null;
        GetCoursesU5 instance = new GetCoursesU5();
        String expResult = "";
        String result = instance.execute(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
