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
import reddit.mpurjc.Usuario;


/**
 *
 * @author micen
 */
public class NuevoUsuarioTest {
    Foro foroPrueba = new Foro();
    
    NuevoUsuario comando = new NuevoUsuario(foroPrueba);
    public NuevoUsuarioTest() {
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
        String parametros = "NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)";
        comando.ejecutar(parametros);
        assertEquals(1,foroPrueba.getListaUsuarios().size());
        Usuario usuarioPrueba = foroPrueba.getListaUsuarios().get("emailprofesor");
        assertEquals("Profesor1",usuarioPrueba.getNombre());
        assertEquals("pass",usuarioPrueba.getContraseña());
        assertEquals("emailprofesor@urjc.es",usuarioPrueba.getEmail());
        assertEquals("ApellidosUsuario",usuarioPrueba.getApellidos());
    }

    @Test
    public void testUsuarioRepetido(){
        String parametros = "NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)";
        comando.ejecutar(parametros);
        assertTrue(comando.ejecutar(parametros));
    }
    
    /**@Test
    public void testCorreoMal(){
        String parametros = "NuevoUsuario(Alumno,ApellidosUsuario,emailAlumno@google.com,pass)";
        boolean prueba = comando.ejecutar(parametros);
        assertEquals(false,prueba);
    }**/
    
    @Test
    public void testComprobar() {
        
    }

    @Test
    public void testSetForo() {
        
    }
    
}
