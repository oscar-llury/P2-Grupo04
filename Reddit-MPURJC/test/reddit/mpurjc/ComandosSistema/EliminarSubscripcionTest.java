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
public class EliminarSubscripcionTest {
    
    private static final Foro reddit = new Foro();
    
    public EliminarSubscripcionTest() {
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
     * Test of ejecutar method, of class EliminarSubscripcion.
     */
  

     @Test
    public void testEjecutar_SinUsuarioLogeado() {
        System.out.println("****Test Eliminar Subscripcion Sin Usuario Logeado****");
        
        Logout comandoLogout = new Logout(reddit);
        comandoLogout.ejecutar("Logout()");
        
        EliminarSubscripcion instance = new EliminarSubscripcion(reddit);
        
        boolean result = instance.ejecutar("EliminarSubscripcion(SubForo 1");
        
        boolean expResult = false;

        assertEquals(expResult, result);

    }
    
     @Test
    public void testEjecutar_NoEstasSubscrito() {
    
        System.out.println("*******Test EliminarSubscripcion Sin EstarSubscrito*******");
        
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");        
        
        EliminarSubscripcion instance = new EliminarSubscripcion(reddit);
        
        boolean result = instance.ejecutar("EliminarSubscripcion(SubForo 1)");
        
        boolean expResult = false;

        assertEquals(expResult, result);
        
    }
    @Test
    public void testEjecutar_SubforoNoExiste() {
        
        System.out.println("*******Test EliminarSubscripcion Subforo NO existe*******");
        
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        
        EliminarSubscripcion instance = new EliminarSubscripcion(reddit);
        
        boolean result = instance.ejecutar("EliminarSubscripcion(SubForo 2)");
        
        boolean expResult = false;

        assertEquals(expResult, result);
        
        
    
    }
    @Test
    public void testEjecutar_Correcto() {
        System.out.println("*******Test EliminarSubscripcion CORRECTAMENTE*******");
        
        
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        
  
         NuevaSubscripcion instance1 = new NuevaSubscripcion(reddit);
         
         instance1.ejecutar("NuevaSubscripcion(SubForo 1)");
         
        EliminarSubscripcion instance = new EliminarSubscripcion(reddit);
        
        boolean result = instance.ejecutar("EliminarSubscripcion(SubForo 1)");
        
        boolean expResult = true;

        assertEquals(expResult, result);

    }
}
