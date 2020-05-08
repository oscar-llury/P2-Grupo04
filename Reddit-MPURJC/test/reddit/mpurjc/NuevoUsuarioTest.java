/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit.mpurjc;

import org.junit.Test;
import static org.junit.Assert.*;
import reddit.mpurjc.ComandosSistema.NuevoUsuario;
import static reddit.mpurjc.Usuario.Rol.*;

/**
 *
 * @author micen
 */
public class NuevoUsuarioTest {
    
    public NuevoUsuarioTest() {
    }

    @Test
    public void testEjecutar() {
        Foro foroPrueba = new Foro();
        String parametros = "NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)";
        NuevoUsuario comando = new NuevoUsuario(foroPrueba);
        comando.ejecutar(parametros);
        //Vemos si se ha creado e insertado en el foro
        assertEquals(1,foroPrueba.getListaUsuarios().size());
        //Vemos si los parámetros insertados están bien escritos
        Usuario usuarioPrueba = foroPrueba.getListaUsuarios().get("admin");
        assertEquals("Admin",usuarioPrueba.getNombre());
        assertEquals("AdminPass",usuarioPrueba.getContraseña());
        assertEquals("admin@admin.urjc.es",usuarioPrueba.getEmail());
        assertEquals("Admin",usuarioPrueba.getApellidos());
        assertEquals(ADMINISTRADOR,usuarioPrueba.getRol());
    }

    

    
    
}
