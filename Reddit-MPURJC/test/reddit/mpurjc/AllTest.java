package reddit.mpurjc;

/**
 * Autores Práctica MP: Javier Espín Prieto Jorge Utrero Sevillano Miguel
 * Cendrero Ortega Óscar Rivas Melar
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import reddit.mpurjc.ComandosSistema.ComentarComentarioTest;
import reddit.mpurjc.ComandosSistema.ComentarEntradaTest;
import reddit.mpurjc.ComandosSistema.EliminarSubscripcionTest;
import reddit.mpurjc.ComandosSistema.LoginTest;
import reddit.mpurjc.ComandosSistema.LogoutTest;
import reddit.mpurjc.ComandosSistema.NuevaEntradaTest;
import reddit.mpurjc.ComandosSistema.NuevaSubscripcionTest;
import reddit.mpurjc.ComandosSistema.NuevoSubForoTest;
import reddit.mpurjc.ComandosSistema.NuevoUsuarioTest;

@RunWith(Suite.class)
@SuiteClasses({ ComentarComentarioTest.class,
        ComentarEntradaTest.class,
        EliminarSubscripcionTest.class,
        LoginTest.class,
        LogoutTest.class,
        NuevaEntradaTest.class,
        NuevaSubscripcionTest.class,
        NuevoSubForoTest.class,
        NuevoUsuarioTest.class
})        
        
public class AllTest {
    
}
