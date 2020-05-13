package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

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

    @Before
    public void setUp() {
    }

    /**
     * Test of ejecutar method, of class EliminarSubscripcion.
     */
    @Test
    public void testEliminarSubscripcion_SinUsuarioLogeado() {
        System.out.println("**Test Eliminar Subscripcion Sin Usuario Logeado**");

        Logout comandoLogout = new Logout(reddit);
        comandoLogout.ejecutar("Logout()");

        EliminarSubscripcion instance = new EliminarSubscripcion(reddit);

        boolean result = instance.ejecutar("EliminarSubscripcion(SubForo 1");

        boolean expResult = false;

        assertEquals(expResult, result);

    }

    @Test
    public void testEliminarSubscripcion_NoEstasSubscrito() {

        System.out.println("***Test EliminarSubscripcion Sin EstarSubscrito***");

        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");

        EliminarSubscripcion instance = new EliminarSubscripcion(reddit);

        boolean result = instance.ejecutar("EliminarSubscripcion(SubForo 1)");

        boolean expResult = false;

        assertEquals(expResult, result);

    }

    @Test
    public void testEliminarSubscripcion_SubforoNoExiste() {

        System.out.println("***Test EliminarSubscripcion Subforo NO existe****");

        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");

        EliminarSubscripcion instance = new EliminarSubscripcion(reddit);

        boolean result = instance.ejecutar("EliminarSubscripcion(SubForo 2)");

        boolean expResult = false;

        assertEquals(expResult, result);
    }

    @Test
    public void testEliminarSubscripcion_Correcto() {
        System.out.println("*****Test EliminarSubscripcion CORRECTAMENTE******");

        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");

        NuevaSubscripcion instance1 = new NuevaSubscripcion(reddit);

        instance1.ejecutar("NuevaSubscripcion(SubForo 1)");

        EliminarSubscripcion instance = new EliminarSubscripcion(reddit);

        boolean result = instance.ejecutar("EliminarSubscripcion(SubForo 1)");

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
