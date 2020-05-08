/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit.mpurjc;

import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.ComandosSistema.Login;

/**
 *
 * @author micen
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testEjecutar() {
        Foro foroPrueba = new Foro();
        //Creamos un usuario
        Usuario usuarioPrueba = new Usuario("Profesor1", "ApellidosUsuario", "emailprofesor@urjc.es", "pass");
        foroPrueba.getListaUsuarios().put(usuarioPrueba.getNick(), usuarioPrueba);
        //Comprobamos que se ha creado
        assertEquals(1,foroPrueba.getListaUsuarios().size());
        
        //Hacemos login
        Login comando = new Login(foroPrueba);
        comando.ejecutar("Login(emailProfesor pass)");
        assertEquals("Profesor1",foroPrueba.getUsuarioActual().getNombre());
        assertEquals("ApellidosUsuario",foroPrueba.getUsuarioActual().getApellidos());
        assertEquals("emailprofesor@urjc.es",foroPrueba.getUsuarioActual().getEmail());
        assertEquals("pass",foroPrueba.getUsuarioActual().getContraseña());
        
    }

    

    
    
}
