package reddit.mpurjc;

/**
 * Autores Práctica MP: Javier Espín Prieto Jorge Utrero Sevillano Miguel
 * Cendrero Ortega Óscar Rivas Melar
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import reddit.mpurjc.ComandosSistema.*;

@RunWith(Suite.class)
@SuiteClasses({ ComentarComentarioTest.class,
        ComentarEntradaTest.class,
        EliminarSubscripcionTest.class,
        LoginTest.class,
        LogoutTest.class,
        NuevaEntradaTest.class,
        NuevaSubscripcionTest.class,
        NuevoSubForoTest.class,
        NuevoUsuarioTest.class,
        ValidarEntradaTest.class,
        VotarComentarioTest.class,
        VotarEntradaTest.class
})        
        
public class AllTest {
    
}
