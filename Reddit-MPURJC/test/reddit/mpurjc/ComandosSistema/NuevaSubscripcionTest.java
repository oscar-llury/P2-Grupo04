package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

public class NuevaSubscripcionTest {

    private static final Foro reddit = new Foro();

    public NuevaSubscripcionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);

        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of ejecutar method, of class NuevaSubscripcion.
     */
    @Test
    public void testNuevaSubscripcion_Repetido() {
        System.out.println("*********Test NuevaSubscricion Repetida***********");

        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");

        NuevaSubscripcion instance = new NuevaSubscripcion(reddit);
        instance.ejecutar("NuevaSubscripcion(SubForo 1)");

        boolean result = instance.ejecutar("NuevaSubscripcion(SubForo 1)");
        boolean expResult = false;

        assertEquals(expResult, result);
    }

    @Test
    public void testNuevaSubscripcion_SinUsuarioLogeado() {
        System.out.println("****Test NuevaSusbcripcion Sin Usuario Logeado****");

        Logout comandoLogout = new Logout(reddit);
        comandoLogout.ejecutar("Logout()");

        NuevaSubscripcion instance = new NuevaSubscripcion(reddit);

        boolean result = instance.ejecutar("NuevaSubscripcion(SubForo 1)");

        boolean expResult = false;

        assertEquals(expResult, result);
    }

    @Test
    public void testNuevaSubscripcion_SubforoNoExiste() {
        System.out.println("*****Test NuevaSubscripcion Subforo NO existe*****");

        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");

        NuevaSubscripcion instance = new NuevaSubscripcion(reddit);

        boolean result = instance.ejecutar("NuevaSubscripcion(SubForo 2)");

        boolean expResult = false;

        assertEquals(expResult, result);
    }

    @Test
    public void testNuevaSubscripcion_Correcto() {
        System.out.println("*******Test NuevaSubscripcion CORRECTAMENTE*******");

        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");

        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 2)");

        NuevaSubscripcion instance = new NuevaSubscripcion(reddit);

        boolean result = instance.ejecutar("NuevaSubscripcion(SubForo 2)");

        boolean expResult = true;

        assertEquals(expResult, result);
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
