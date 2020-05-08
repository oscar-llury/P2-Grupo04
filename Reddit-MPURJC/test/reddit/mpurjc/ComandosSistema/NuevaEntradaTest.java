package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;


public class NuevaEntradaTest {
    
    private static Foro reddit = new Foro();
    
    public NuevaEntradaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)");
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Alumno1,ApellidosUsuario,emailAlumno@alumnos.urjc.es,pass)");
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
        System.out.println("");
    }
    
    @Before
    public void setUp() {
    }
    
    /**
     * Test of ejecutar method, of class NuevaEntrada.
     */
    /*
    @Test
    public void testEjecutar_EjercicioSinedoAlumno() {
        System.out.println("****Test Crear Entrada Ejercicio Siendo Alumno****");
        
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailAlumno pass)");
        
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        
        boolean result = comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Titulo Entrada,Ejercicio, esto es ejercicio entrada 1 subforo 1.)"); 

        boolean expResult = true;

        assertEquals(expResult, result);
    }
    
    @Test
    public void testEjecutar_TipoEntradaIncorrecto() {
        System.out.println("**Test Crear Entrada Con Tipo Entrada Incorrecto**");
        
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        
        boolean result = comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Titulo Entrada,Texto, esto es el texto de la entrada 1 subforo 1)"); 

        boolean expResult = true;

        assertEquals(expResult, result);
    }
    */
    @Test
    public void testEjecutar_SinUsuario() {
        System.out.println("***********Test Crear Entrada Sin Usuario*********");
        
        Logout comandoLogout = new Logout(reddit);
        comandoLogout.ejecutar("Logout()");
        
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        
        boolean result = comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Titulo Entrada,Texto Plano, esto es el texto de la entrada 1 subforo 1)"); 

        boolean expResult = false;

        assertEquals(expResult, result);
    }
    
    @Test
    public void testEjecutar_Correctamente() {
        System.out.println("**********Test Crear Entrada CORRECTAMENTE********");
        
        Login comandoLogin = new Login(reddit);
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        
        boolean result = comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Titulo Entrada,Texto Plano, esto es el texto de la entrada 1 subforo 1)"); 

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
