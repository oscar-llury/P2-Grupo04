package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

public class LogoutTest {

    private static Foro reddit = new Foro();

    public LogoutTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testLogout_Correcto() {
        System.out.println("**************Test Logout CORRECTAMENTE***********");

        Logout logout = new Logout(reddit);
        boolean result = logout.ejecutar("Logout()");

        assertTrue(result);
    }

    @Test
    public void testLogout_EstandoLogout() {
        System.out.println("*************Test Logout Estando Logout***********");

        Logout logout = new Logout(reddit);
        logout.ejecutar("Logout()");

        boolean result = logout.ejecutar("Logout()");

        assertTrue(result);
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
