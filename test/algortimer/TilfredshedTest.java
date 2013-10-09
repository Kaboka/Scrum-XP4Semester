/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algortimer;

import classes.Elev;
import classes.Fag;
import classes.Tilfredshed;
import interfaces.IElev;
import interfaces.IFag;
import interfaces.TilfredshedInterface;
import java.util.ArrayList;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
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
public class TilfredshedTest {
    
    public TilfredshedTest() {
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
        Mockery context = new JUnit4Mockery();
        final Elev per = context.mock(Elev.class);

        context.checking(new Expectations(){{
            oneOf(per).setForstePrio1(new Fag("cPlus"));
            will(returnValue("cPlus"));
        }});
        context.checking(new Expectations(){{
            oneOf(per).getForstePrio1();
            will(returnValue("cPlus"));
        }});
        context.checking(new Expectations(){{
            oneOf(per).setForstePrio2(new Fag("cSharp"));
            will(returnValue("cSharp"));
        }});
        context.checking(new Expectations(){{
            oneOf(per).getForstePrio2();
            will(returnValue("cSharp"));
        }});
        context.checking(new Expectations(){{
            oneOf(per).setAndenPrio1(new Fag("android"));
            will(returnValue("android"));
        }});
        context.checking(new Expectations(){{
            oneOf(per).getAndenPrio1();
            will(returnValue("android"));
        }});
        context.checking(new Expectations(){{
            oneOf(per).setAndenPrio2(new Fag("security"));
            will(returnValue("security"));
        }});
        context.checking(new Expectations(){{
            oneOf(per).getAndenPrio2();
            will(returnValue("security"));
        }});
        context.checking(new Expectations(){{
            oneOf(per).getTilfredshed();
            will(returnValue(4));
        }});
        
         
         
    }
}
