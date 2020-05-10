package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class NuevoUsuarioTest {

    Foro reddit = new Foro();

    public NuevoUsuarioTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testNuevoUsuario_Correcto() {
        System.out.println("*********Test NuevoUsuario CORRECTAMENTE**********");

        NuevoUsuario nuevoUsuario = new NuevoUsuario(reddit);
        nuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");

        assertEquals(1, reddit.getListaUsuarios().size());

        Usuario usuarioPrueba = reddit.getListaUsuarios().get("emailprofesor");

        assertEquals("Profesor1", usuarioPrueba.getNombre());
        assertEquals("pass", usuarioPrueba.getContraseña());
        assertEquals("emailprofesor@urjc.es", usuarioPrueba.getEmail());
        assertEquals("ApellidosUsuario", usuarioPrueba.getApellidos());
    }

    @Test
    public void testNuevoUsuario_UsuarioRepetido() {
        System.out.println("********Test NuevoUsuario Usuario Repetido********");

        NuevoUsuario nuevoUsuario = new NuevoUsuario(reddit);
        String parametros = "NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)";

        nuevoUsuario.ejecutar(parametros);

        boolean result = nuevoUsuario.ejecutar(parametros);

        assertFalse(result);
    }

    @Test
    public void testNuevoUsuario_CorreoMal() {
        System.out.println("********Test NuevoUsuario Correo No URJC**********");

        NuevoUsuario nuevoUsuario = new NuevoUsuario(reddit);
        String parametros = "NuevoUsuario(Alumno,ApellidosUsuario,emailAlumno@google.com,pass)";

        boolean result = nuevoUsuario.ejecutar(parametros);

        assertFalse(result);

        System.out.println("");
    }

    @After
    public void tearDown() {
        System.out.println("********************END TEST**********************");
        System.out.println("");
    }

    @AfterClass
    public static void tearDownClass() {
    }
}
