package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

public class LoginTest {
    private static Foro reddit = new Foro();
    
    public LoginTest() {
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
    public void testLogin_Correcto() {
        System.out.println("**************Test Login CORRECTAMENTE************");
        Logout logout = new Logout(reddit);
        Login login = new Login(reddit);
        
        logout.ejecutar("Logout()");
        
        boolean result = login.ejecutar("Login(emailProfesor pass)");
        assertTrue(result);
    }
    
    @Test
    public void testLogin_MalasCredenciales(){
        System.out.println("***********Test Login Malas Credenciales**********");
        Logout logout = new Logout(reddit);
        Login login = new Login(reddit);
        
        logout.ejecutar("Logout()");
        
        boolean result = login.ejecutar("Login(emailProfesor passMal)");
        assertFalse(result);
    }
    
    @Test
    public void testLogin_EstandoLogeado(){
        System.out.println("*************Test Login Estando Login*************");
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor2,ApellidosUsuario2,emailProfesor2@urjc.es,pass)");
        
        Login login = new Login(reddit);
        login.ejecutar("Login(emailProfesor pass)");
        
        assertEquals("emailprofesor",reddit.getUsuarioActual().getNick());
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
