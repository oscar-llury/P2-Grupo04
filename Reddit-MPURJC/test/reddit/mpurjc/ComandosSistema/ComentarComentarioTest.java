package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;


public class ComentarComentarioTest {
        
    private static Foro reddit = new Foro();
    
    public ComentarComentarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);
        ComentarEntrada comandoNuevoComentarioEntrada = new ComentarEntrada(reddit);
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)");
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Titulo Entrada,Texto Plano, esto es el texto de la entrada 1 subforo 1)");
        comandoValidarEntrada.ejecutar("ValidarEntrada(all)");
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");
        System.out.println("");
    }
    
    @Before
    public void setUp() {
    }
    
    /**
     * Test of ejecutar method, of class ComentarComentario.
     */
    
    @Test
    public void testComentarComentario_NoEncuentraComentario() {
        System.out.println("*Test ComentarioComentario No Encuentra Comentario*");

        ComentarComentario instance = new ComentarComentario(reddit);
        
        boolean result = instance.ejecutar("ComentarComentario(SubForo 1.1.5-Esto es un comentario a un comentario)");
        
        boolean expResult = false;

        assertEquals(expResult, result);
    }
    
    @Test
    public void testComentarComentario_Penalizacion() {
        System.out.println("***Test ComentarioComentario Penalizar Usuario***");

        ComentarComentario instance = new ComentarComentario(reddit);

        instance.ejecutar("ComentarComentario(SubForo 1.1.1-Esto es el comentario 2 idiota)");
        
        boolean result = reddit.getUsuarioActual().isPenalizado();
        
        if(result){
            System.out.println("El usuario ha sido penalizado.");
        }
        
        boolean expResult = true;
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testComentarComentario_Correcto() {
        System.out.println("******Test ComentarioComentario CORRECTAMENTE*****");

        ComentarComentario instance = new ComentarComentario(reddit);
        
        boolean result = instance.ejecutar("ComentarComentario(SubForo 1.1.1-Esto es un comentario a un comentario)");
        
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
