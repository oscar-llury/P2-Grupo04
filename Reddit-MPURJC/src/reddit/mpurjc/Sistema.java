package reddit.mpurjc;

import java.util.Scanner;
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
        

        
        //iniciar Comandos del Sistema
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        ComentarEntrada comandoNuevoComentarioEntrada = new ComentarEntrada(reddit);
        //Iniciar demostrador
        comandoNuevoSubForo.ejecutar("SubForo 1");
        comandoNuevoUsuario.ejecutar("NombreUsuario,ApellidosUsuario,EmailUsuario,ContraseñaUsuario");
        comandoNuevaEntrada.ejecutar("TituloEntrada,Texto Plano, esto es el texto del Texto Plano.");

        comandoNuevoComentarioEntrada.ejecutar("Esto es un comentario");
        
        /*entradaActual = new Entrada(usuarioActual);
        entradaActual.construirEntrada();
        entradaActual.mostrar();*/
    }
    
}
