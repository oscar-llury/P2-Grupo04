package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

public class ValidarEntradaTest {
    
    private static Foro reddit = new Foro();
    private static NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
    
    public ValidarEntradaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
       
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testValidarEntrada_SinAdmin(){
        System.out.println("*******Test ValidarEntrada Sin Administrador******");
        
        ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);
        boolean valida = comandoValidarEntrada.ejecutar("ValidarEntrada(all)");
        assertFalse(valida);
    }
    
     @Test
    public void testValidarEntrada_SinEntradas(){
        System.out.println("*********Test ValidarEntrada Sin Entradas*********");
        
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)");
        ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);
        boolean valida = comandoValidarEntrada.ejecutar("ValidarEntrada(all)");
        assertFalse(valida);
    }
   
    @Test
    public void testValidarEntrada_Correcto() {
        System.out.println("***********Test ValidarEntrada Correcto***********");
        
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)");
        
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);
        
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Entrada 1,Encuesta, esto es el enunciado de la encuesta de la entrada 1 subforo 1, opcion 1, opcion 2)");
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Entrada 2,Encuesta, esto es el enunciado de la encuesta de la entrada 2 subforo 1, opcion 1, opcion 2)");
        comandoValidarEntrada.ejecutar("ValidarEntrada(all)"); 
        
        boolean valido = reddit.getEntradaActual().isVerificado();

        assertTrue(valido);
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
