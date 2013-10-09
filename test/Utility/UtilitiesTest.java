/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import classes.Student;
import classes.Course;
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
        final IStudent mockIStudent1 = new Student("Per", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent1.setSatifaction(4);
        final IStudent mockIStudent2 = new Student("Anna", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent2.setSatifaction(1);
        final IStudent mockIStudent3 = new Student("Ole", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent3.setSatifaction(3);
        final IStudent mockIStudent4 = new Student("Lars", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent4.setSatifaction(4);
        final IStudent mockIStudent5 = new Student("Mathias", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent5.setSatifaction(2);
        final IStudent mockIStudent6 = new Student("Nicklas", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent6.setSatifaction(4);
        final IStudent mockIStudent7 = new Student("Ib", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent7.setSatifaction(1);
        final IStudent mockIStudent8 = new Student("Ida", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent8.setSatifaction(3);
        final IStudent mockIStudent9 = new Student("Kasper", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent9.setSatifaction(2);
        final IStudent mockIStudent10 = new Student("Lasse", new Course(" "), new Course(" "), new Course(" "), new Course(" "));
        mockIStudent10.setSatifaction(2);

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
        ArrayList<Course> fag = (ArrayList<Course>) Utilities.convertToCourse(string);

        assertEquals("Test", fag.get(0).getName());
        assertEquals("Globalization", fag.get(1).getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertBad() {
        String string = "";
        Utilities.convertToCourse(string);
    }
    
    @Test
    public void testSatisfactionGood() {
        Collection<Course> poolA;
        Collection<Course> poolB;
        Collection<IStudent> elever;
        Student per;
        Student peter;
        poolA = new ArrayList();
        poolB = new ArrayList();
        elever = new ArrayList();
        poolA.add(new Course("C#"));
        poolA.add(new Course("Test"));
        poolB.add(new Course("HCI"));
        poolB.add(new Course("Globalization"));
        per = new Student("per", new Course("C#"), new Course("Test"), new Course("HCI"), new Course("Globalization"));
        peter = new Student("peter", new Course("C#"), new Course("Project management"), new Course("Apps and innovation"), new Course("C++"));
        elever.add(per);
        elever.add(peter);
        Utilities.calculateSatifaction(elever, poolA, poolB);

        assertEquals(3, per.getSatifaction());
        assertEquals(1, peter.getSatifaction());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSatisfactionBad() {
        Collection<Course> poolA = new ArrayList();
        Collection<Course> poolB = new ArrayList();
        Collection<IStudent> elever = new ArrayList();
        
        Utilities.calculateSatifaction(elever, poolA, poolB);
    }
}