package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

public class VotarComentarioTest {
    
    private static final Foro reddit = new Foro();
    
    public VotarComentarioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);

        comandoNuevoUsuario.ejecutar("NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)");
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Entrada 1,Encuesta, esto es el enunciado de la encuesta de la entrada 1 subforo 1, opcion 1, opcion 2)");
        comandoValidarEntrada.ejecutar("ValidarEntrada(all)"); 
       
    }
    
    @Before
    public void setUp() {
    }


    @Test
    public void testEjecutar() {
        
        ComentarEntrada comandoNuevoComentarioEntrada = new ComentarEntrada(reddit);
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");
        
        VotarComentario comandoVotarComentario = new VotarComentario(reddit);
        comandoVotarComentario.ejecutar("VotarComentario(SubForo 1.1.1.-like)");
        int tamaño = reddit.getEntradaActual().getComentarioPorOrden(1).getPuntuacionesSize();
        assertEquals(1,tamaño);
    }
    
    @Test
    public void testVotarSinComentarios(){
        VotarComentario comandoVotarComentario = new VotarComentario(reddit);
        assertFalse(comandoVotarComentario.ejecutar("VotarComentario(SubForo 1.1.1.-like)"));
    }
    
    @Test
    public void testNiLikeNiDislike(){
        ComentarEntrada comandoNuevoComentarioEntrada = new ComentarEntrada(reddit);
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");

        VotarComentario comandoVotarComentario = new VotarComentario(reddit);
        assertFalse(comandoVotarComentario.ejecutar("VotarComentario(SubForo 1.1.1.-algo)"));
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
