/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit.mpurjc;


import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.ComandosSistema.Logout;

/**
 *
 * @author micen
 */
public class LogoutTest {
    
    public LogoutTest() {
    }

    @Test
    public void testEjecutar() {
        Foro foroPrueba = new Foro();
        //Creamos un usuario
        Usuario usuarioPrueba = new Usuario("Profesor1", "ApellidosUsuario", "emailprofesor@urjc.es", "pass");
        foroPrueba.getListaUsuarios().put(usuarioPrueba.getNick(), usuarioPrueba);
        foroPrueba.setUsuarioActual(usuarioPrueba);
        //Comprobamos que estamos logeados
        assertEquals("Profesor1",foroPrueba.getUsuarioActual().getNombre());
        //Hacemos logout y comprobamos que no estamos logeados
        Logout comando = new Logout(foroPrueba);
        comando.ejecutar("Logout()");
        assertEquals(null,foroPrueba.getUsuarioActual());
    }

    
    

    
    
}
