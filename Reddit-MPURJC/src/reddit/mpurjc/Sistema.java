package reddit.mpurjc;

import reddit.mpurjc.ComandosSistema.*;
/** Autores:
 * Javier Espín Prieto
 * Jorge Utrero Sevillano
 * Miguel Cendrero Ortega
 * Óscar Rivas Melar
 */
public class Sistema {

    public static void main(String[] args) {
        System.out.println("Bienvenido a Reddit URJC 2020");      
        
        Foro reddit = new Foro();
        /*
        SubForo subForoActual = new SubForo();
        Entrada entradaActual = new Entrada();
        Usuario usuarioActual = new Usuario();
        */
        //iniciar Comandos del Sistema
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        //Iniciar demostrador
        comandoNuevoSubForo.ejecutar("SubForo 1");
        comandoNuevoUsuario.ejecutar("NombreUsuario,ApellidosUsuario,EmailUsuario,ContraseñaUsuario");
        
        /*entradaActual = new Entrada(usuarioActual);
        entradaActual.construirEntrada();
        entradaActual.mostrar();*/
    }
    
}
