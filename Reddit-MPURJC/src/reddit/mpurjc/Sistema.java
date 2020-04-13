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
        

        
        //iniciar Comandos del Sistema
        NuevoSubForo comandoNuevoSubForo = new NuevoSubForo(reddit);
        NuevoUsuario comandoNuevoUsuario = new NuevoUsuario(reddit);
        NuevaEntrada comandoNuevaEntrada = new NuevaEntrada(reddit);
        ComentarEntrada comandoNuevoComentarioEntrada = new ComentarEntrada(reddit);
        VotarComentario comandoVotarComentario = new VotarComentario(reddit);
        VotarEntrada comandoVotarEntrada = new VotarEntrada(reddit);
        ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);
        //Iniciar demostrador
        
        comandoNuevoUsuario.ejecutar("Admin,Admin,Admin@admin.urjc.es,AdminPass");

        comandoNuevoSubForo.ejecutar("SubForo 1");
        comandoNuevoUsuario.ejecutar("NombreUsuario,ApellidosUsuario,EmailUsuario@urjc.es,ContraseñaUsuario");
        comandoNuevaEntrada.ejecutar("TituloEntrada,Texto Plano, esto es el texto del Texto Plano.");

        comandoValidarEntrada.ejecutar("all");
        
        comandoNuevoComentarioEntrada.ejecutar("Esto es un comentario");
        
        comandoVotarComentario.ejecutar("(1) true");
        
        comandoVotarEntrada.ejecutar("(1)true");
        
        /*entradaActual = new Entrada(usuarioActual);
        entradaActual.construirEntrada();
        entradaActual.mostrar();*/
    }
    
}
