/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import RenameLaterInterfaces.Istudent;
import java.util.ArrayList;
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

public class SortingThingTest {

    public SortingThingTest() {
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
    public void testSomeMethod() {

        //set up
        Mockery context = new JUnit4Mockery();
        final Istudent mockIstudent1 = context.mock(Istudent.class);
        final Istudent mockIstudent2 = context.mock(Istudent.class, "mockIstundent2");
        final Istudent mockIstudent3 = context.mock(Istudent.class, "mockIstundent3");
        final Istudent mockIstudent4 = context.mock(Istudent.class, "mockIstundent4");
        final Istudent mockIstudent5 = context.mock(Istudent.class, "mockIstundent5");
        final Istudent mockIstudent6 = context.mock(Istudent.class, "mockIstundent6");
        final Istudent mockIstudent7 = context.mock(Istudent.class, "mockIstundent7");
        final Istudent mockIstudent8 = context.mock(Istudent.class, "mockIstundent8");
        final Istudent mockIstudent9 = context.mock(Istudent.class, "mockIstundent9");
        final Istudent mockIstudent10 = context.mock(Istudent.class, "mockIstundent10");

        ArrayList<Istudent> students = new ArrayList<Istudent>();

        students.add(mockIstudent1);
        students.add(mockIstudent2);
        students.add(mockIstudent3);
        students.add(mockIstudent4);
        students.add(mockIstudent5);
        students.add(mockIstudent6);
        students.add(mockIstudent7);
        students.add(mockIstudent8);
        students.add(mockIstudent9);
        students.add(mockIstudent10);

        // set up expectations
        context.checking(new Expectations() {{
                oneOf(mockIstudent1).getRank();
                will(returnValue(4));
                oneOf(mockIstudent2).getRank();
                will(returnValue(3));
                oneOf(mockIstudent3).getRank();
                will(returnValue(4));
                oneOf(mockIstudent4).getRank();
                will(returnValue(3));
                oneOf(mockIstudent5).getRank();
                will(returnValue(1));
                oneOf(mockIstudent6).getRank();
                will(returnValue(4));
                oneOf(mockIstudent7).getRank();
                will(returnValue(2));
                oneOf(mockIstudent8).getRank();
                will(returnValue(1));
                oneOf(mockIstudent9).getRank();
                will(returnValue(2));
                oneOf(mockIstudent10).getRank();
                will(returnValue(1));}
        });
        
        //execute
        students = SortingThing.sort(students);
        
        //verify
        assertEquals(mockIstudent5, students.get(0));

    }
}