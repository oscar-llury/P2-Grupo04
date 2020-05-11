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
public class NuevoSubForoTest {
      
    private static final Foro reddit = new Foro();
    
    public NuevoSubForoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
        
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
     * Test of ejecutar method, of class NuevoSubForo.
     */
  

     @Test
    public void testEjecutar_Repetido() {
        System.out.println("***Test NuevoSubforo Repetido***");
        
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        
        NuevoSubForo instance = new NuevoSubForo(reddit);
   
        boolean result = instance.ejecutar("NuevoSubForo(SubForo 1)");
        boolean expResult = false;
      

        assertEquals(expResult, result);

    }
    
     
    @Test
    public void testEjecutar_SinUsuarioLogeado() {
        System.out.println("****Test NuevoSubForo Sin Usuario Logeado****");
        
        Logout comandoLogout = new Logout(reddit);
        comandoLogout.ejecutar("Logout()");
        
        NuevoSubForo instance = new NuevoSubForo(reddit);
        
        boolean result = instance.ejecutar("NuevoSubForo(SubForo 1)");
        
        boolean expResult = false;

        assertEquals(expResult, result);

    }
    
    @Test
    public void testEjecutar_Correcto() {
        System.out.println("*******Test NuevoSubForo CORRECTAMENTE*******");
        
    
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        
        NuevoSubForo instance = new NuevoSubForo(reddit);
        
        boolean result = instance.ejecutar("NuevoSubForo(SubForo 2)");
        
        boolean expResult = true;

        assertEquals(expResult, result);

    }
    
}


