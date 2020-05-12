package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

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

    @Before
    public void setUp() {
    }

    /**
     * Test of ejecutar method, of class NuevoSubForo.
     */
    @Test
    public void testNuevoSubForo_Repetido() {
        System.out.println("***********Test NuevoSubforo Repetido*************");

        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");

        NuevoSubForo instance = new NuevoSubForo(reddit);
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);

        boolean result = instance.ejecutar("NuevoSubForo(SubForo 1)");
        boolean expResult = comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");

        assertEquals(expResult, result);

    }

    @Test
    public void testNuevoSubForo_SinUsuarioLogeado() {
        System.out.println("******Test NuevoSubForo Sin Usuario Logeado*******");

        Logout comandoLogout = new Logout(reddit);
        comandoLogout.ejecutar("Logout()");

        NuevoSubForo instance = new NuevoSubForo(reddit);

        boolean result = instance.ejecutar("NuevoSubForo(SubForo 1)");

        boolean expResult = false;

        assertEquals(expResult, result);

    }

    @Test
    public void testNuevoSubForo_Correcto() {
        System.out.println("*********Test NuevoSubForo CORRECTAMENTE**********");

        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");

        NuevoSubForo instance = new NuevoSubForo(reddit);

        boolean result = instance.ejecutar("NuevoSubForo(SubForo 2)");

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
