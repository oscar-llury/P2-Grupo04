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
 * @author micen
 */
public class LogoutTest {
    
    private static Foro foroPrueba = new Foro();
    static Logout comando = new Logout(foroPrueba);
    
    public LogoutTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(foroPrueba);
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
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
        
        assertTrue(comando.ejecutar("Logout()"));
    }

    @Test
    public void testComprobar() {
        
    }

    @Test
    public void testSetForo() {
        
    }
    
}
