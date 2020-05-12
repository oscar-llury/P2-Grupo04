package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;


public class ComentarEntradaTest {
    
    private static Foro reddit = new Foro();
        
    public ComentarEntradaTest() {

    }
    
    @BeforeClass
    public static void setUpClass() {
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)");
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Titulo Entrada,Texto Plano, esto es el texto de la entrada 1 subforo 1)");
        System.out.println("");
    }
        
    @Before
    public void setUp() {
    }

    /**
     * Test of ejecutar method, of class ComentarEntrada.
     */
   
    @Test
    public void testComentarEntrada_SinValidar() {
        System.out.println("***Test ComentarioEntrada Sin Validar por Admin***");

        ComentarEntrada instance = new ComentarEntrada(reddit);
        
        boolean result = instance.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");
        
        boolean expResult = false;

        assertEquals(expResult, result);

    }
    
    @Test
    public void testComentarEntrada_SinUsuarioLogeado() {
        System.out.println("****Test ComentarioEntrada Sin Usuario Logeado****");
        
        Logout comandoLogout = new Logout(reddit);
        comandoLogout.ejecutar("Logout()");
        
        ComentarEntrada instance = new ComentarEntrada(reddit);
        
        boolean result = instance.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");
        
        boolean expResult = false;

        assertEquals(expResult, result);

    }
    
    @Test
    public void testComentarEntrada_Correcto() {
        System.out.println("*******Test ComentarioEntrada CORRECTAMENTE*******");
        
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);
        comandoValidarEntrada.ejecutar("ValidarEntrada(all)");
        
        ComentarEntrada instance = new ComentarEntrada(reddit);
        
        boolean result = instance.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");
        
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
