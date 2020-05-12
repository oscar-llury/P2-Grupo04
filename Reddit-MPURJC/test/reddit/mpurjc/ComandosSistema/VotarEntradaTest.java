package reddit.mpurjc.ComandosSistema;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.Foro;

public class VotarEntradaTest {
    
    private static Foro reddit = new Foro();
    
    public VotarEntradaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);
        
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
    public void testVotarEntrada_NoEncuentraEntrada(){
        System.out.println("******Test VotarEntrada No Encuentra Entrada******");
        
        VotarEntrada comandoVotarEntrada = new VotarEntrada(reddit);
        boolean result = comandoVotarEntrada.ejecutar("VotarEntrada(SubForo 1.5-dislike)");
        
        assertFalse(result);
    }
    
    @Test
    public void testVotarEntrada_NiLikeNiDislike(){
        System.out.println("*******Test VotarEntrada Ni like ni dislike*******");

        VotarEntrada comandoVotarEntrada = new VotarEntrada(reddit);
        boolean result = comandoVotarEntrada.ejecutar("VotarEntrada(SubForo 1.1-algo)");
        
        assertFalse(result);
    }
    
    @Test
    public void testVotarEntrada_Correcto() {
        System.out.println("*************Test VotarEntrada Correcto***********");
        
        VotarEntrada comandoVotarEntrada = new VotarEntrada(reddit);
        comandoVotarEntrada.ejecutar("VotarEntrada(SubForo 1.1-dislike)");
        
        int tamaño = reddit.getEntradaActual().getPuntuacionesSize();
        assertEquals(1,tamaño);
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
