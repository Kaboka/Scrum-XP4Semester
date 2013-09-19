/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algortimer;

import classes.Elev;
import classes.Fag;
import classes.Tilfredshed;
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
        final TilfredshedInterface mockTilfredshed = context.mock(TilfredshedInterface.class);
        final Elev per = new Elev("Per");
        final Elev hans = new Elev("Hans");
        final Elev grethe = new Elev("Grethe");
        final Elev sigurd = new Elev("sig");
        final Fag cPlus = new Fag("C++");
        final Fag android = new Fag("Android");
        final Fag cSharp = new Fag("C#");
        final Fag security = new Fag("Security");
        
        per.setForstePrio1(cPlus);
        per.setForstePrio2(cSharp);
        per.setAndenPrio1(android);
        per.setAndenPrio2(security);
        hans.setForstePrio1(security);
        hans.setForstePrio2(cPlus);
        hans.setAndenPrio1(cSharp);
        hans.setAndenPrio2(android);
        sigurd.setAndenPrio1(android);
        sigurd.setAndenPrio2(cPlus);
        
            ArrayList<Elev> elever = new ArrayList<Elev>();
        ArrayList<Fag> poolA = new ArrayList<Fag>();
        ArrayList<Fag> poolB = new ArrayList<Fag>();
        elever.add(per);
        elever.add(hans);
        elever.add(grethe);
        elever.add(sigurd);
        poolA.add(cPlus);
        poolA.add(security);
        poolB.add(android);
        poolB.add(cSharp);
        Tilfredshed tilfreds = new Tilfredshed();
        tilfreds.udregnTilfredshed(elever, poolA, poolB);
        assertEquals(4, per.getTilfredshed());
        assertEquals(3, hans.getTilfredshed());
        assertEquals(1, grethe.getTilfredshed());
        assertEquals(2, sigurd.getTilfredshed());
    }
}
