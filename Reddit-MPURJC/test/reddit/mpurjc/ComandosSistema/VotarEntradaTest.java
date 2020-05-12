package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

public class VotarEntradaTest {
    
    public VotarEntradaTest() {
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
    public void testEjecutar() {
        System.out.println("ejecutar");
        String s = "";
        VotarEntrada instance = null;
        boolean expResult = false;
        boolean result = instance.ejecutar(s);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testComprobar() {
        System.out.println("comprobar");
        String s = "";
        VotarEntrada instance = null;
        boolean expResult = false;
        boolean result = instance.comprobar(s);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetForo() {
        System.out.println("setForo");
        Foro foro = null;
        VotarEntrada instance = null;
        instance.setForo(foro);
        fail("The test case is a prototype.");
    }
    
}
