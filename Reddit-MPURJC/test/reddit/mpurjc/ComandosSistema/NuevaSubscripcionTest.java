/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

/**
 *
 * @author javie
 */
public class NuevaSubscripcionTest {
    
    public NuevaSubscripcionTest() {
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

    /**
     * Test of ejecutar method, of class NuevaSubscripcion.
     */
    @Test
    public void testEjecutar() {
        System.out.println("ejecutar");
        String s = "";
        NuevaSubscripcion instance = null;
        boolean expResult = false;
        boolean result = instance.ejecutar(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comprobar method, of class NuevaSubscripcion.
     */
    @Test
    public void testComprobar() {
        System.out.println("comprobar");
        String s = "";
        NuevaSubscripcion instance = null;
        boolean expResult = false;
        boolean result = instance.comprobar(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setForo method, of class NuevaSubscripcion.
     */
    @Test
    public void testSetForo() {
        System.out.println("setForo");
        Foro foro = null;
        NuevaSubscripcion instance = null;
        instance.setForo(foro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
