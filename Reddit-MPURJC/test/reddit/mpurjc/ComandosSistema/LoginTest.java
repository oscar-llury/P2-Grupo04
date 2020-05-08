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
public class LoginTest {
    private static Foro foroPrueba = new Foro();
    
    static Login comando = new Login(foroPrueba);
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(foroPrueba);
         comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
         Logout comandoLogout = new Logout(foroPrueba);
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
        Logout comandoLogout = new Logout(foroPrueba);
        comandoLogout.ejecutar("Logout()");
        assertTrue(comando.ejecutar("Login(emailProfesor pass)"));
    }
    
    @Test
    public void testMalasCredenciales(){
        Logout comandoLogout = new Logout(foroPrueba);
        comandoLogout.ejecutar("Logout()");
        assertFalse(comando.ejecutar("Login(emailProfesor passMal)"));
    }
    
    @Test
    public void testLoginLogeado(){
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(foroPrueba);
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor2,ApellidosUsuario2,emailProfesor2@urjc.es,pass)");
        comando.ejecutar("Login(emailProfesor pass)");
        assertEquals("emailprofesor",foroPrueba.getUsuarioActual().getNick());
    }

    @Test
    public void testComprobar() {
        
    }

    @Test
    public void testSetForo() {
        
    }
    
}
