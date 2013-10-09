/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import classes.Elev;
import classes.Fag;
import interfaces.IStudent;
import java.util.ArrayList;
import java.util.Collection;
import org.jmock.Expectations;
import static org.jmock.Expectations.returnValue;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilitiesTest {

    public UtilitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSortGood() {
        //set up
        final IStudent mockIStudent1 = new Elev("Per", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent1.setTilfredshed(4);
        final IStudent mockIStudent2 = new Elev("Anna", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent2.setTilfredshed(1);
        final IStudent mockIStudent3 = new Elev("Ole", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent3.setTilfredshed(3);
        final IStudent mockIStudent4 = new Elev("Lars", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent4.setTilfredshed(4);
        final IStudent mockIStudent5 = new Elev("Mathias", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent5.setTilfredshed(2);
        final IStudent mockIStudent6 = new Elev("Nicklas", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent6.setTilfredshed(4);
        final IStudent mockIStudent7 = new Elev("Ib", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent7.setTilfredshed(1);
        final IStudent mockIStudent8 = new Elev("Ida", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent8.setTilfredshed(3);
        final IStudent mockIStudent9 = new Elev("Kasper", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent9.setTilfredshed(2);
        final IStudent mockIStudent10 = new Elev("Lasse", new Fag(" "), new Fag(" "), new Fag(" "), new Fag(" "));
        mockIStudent10.setTilfredshed(2);

        ArrayList<IStudent> students = new ArrayList<IStudent>();

        students.add(mockIStudent1);
        students.add(mockIStudent2);
        students.add(mockIStudent3);
        students.add(mockIStudent4);
        students.add(mockIStudent5);
        students.add(mockIStudent6);
        students.add(mockIStudent7);
        students.add(mockIStudent8);
        students.add(mockIStudent9);
        students.add(mockIStudent10);

        students = Utilities.sort(students);
        assertEquals(mockIStudent2, students.get(0));
        assertEquals(mockIStudent7, students.get(1));
        assertEquals(mockIStudent5, students.get(2));
        assertEquals(mockIStudent9, students.get(3));
        assertEquals(mockIStudent10, students.get(4));
        assertEquals(mockIStudent3, students.get(5));
        assertEquals(mockIStudent8, students.get(6));
        assertEquals(mockIStudent1, students.get(7));
        assertEquals(mockIStudent4, students.get(8));
        assertEquals(mockIStudent6, students.get(9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSortBad() {
        ArrayList<IStudent> students = new ArrayList<>();
        
        students = Utilities.sort(students);
    }

    @Test
    public void testConvertGood() {
        String string = "[\"Test\",\"Globalization\"]";
        ArrayList<Fag> fag = (ArrayList<Fag>) Utilities.convertToFag(string);

        assertEquals("Test", fag.get(0).getName());
        assertEquals("Globalization", fag.get(1).getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertBad() {
        String string = "";
        Utilities.convertToFag(string);
    }
    
    @Test
    public void testSatisfactionGood() {
        Collection<Fag> poolA;
        Collection<Fag> poolB;
        Collection<IStudent> elever;
        Elev per;
        Elev peter;
        poolA = new ArrayList();
        poolB = new ArrayList();
        elever = new ArrayList();
        poolA.add(new Fag("C#"));
        poolA.add(new Fag("Test"));
        poolB.add(new Fag("HCI"));
        poolB.add(new Fag("Globalization"));
        per = new Elev("per", new Fag("C#"), new Fag("Test"), new Fag("HCI"), new Fag("Globalization"));
        peter = new Elev("peter", new Fag("C#"), new Fag("Project management"), new Fag("Apps and innovation"), new Fag("C++"));
        elever.add(per);
        elever.add(peter);
        Utilities.udregnTilfredshed(elever, poolA, poolB);

        assertEquals(3, per.getTilfredshed());
        assertEquals(1, peter.getTilfredshed());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSatisfactionBad() {
        Collection<Fag> poolA = new ArrayList();
        Collection<Fag> poolB = new ArrayList();
        Collection<IStudent> elever = new ArrayList();
        
        Utilities.udregnTilfredshed(elever, poolA, poolB);
    }
}