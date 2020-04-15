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
        NuevaSubscripcion comandoNuevaSubscripcion = new NuevaSubscripcion(reddit);
        EliminarSubscripcion comandoEliminarSubscripcion = new EliminarSubscripcion(reddit);
        Logout comandoLogout = new Logout(reddit);
        Login comandoLogin = new Login(reddit);
        //Iniciar demostrador
        
        comandoNuevoUsuario.ejecutar("Admin,Admin,Admin@admin.urjc.es,AdminPass");

        comandoNuevoSubForo.ejecutar("SubForo 1");
        comandoNuevoUsuario.ejecutar("NombreUsuario,ApellidosUsuario,EmailUsuario@urjc.es,ContraseñaUsuario");


        comandoNuevaEntrada.ejecutar("TituloEntrada,Texto Plano, esto es el texto del Texto Plano.");

        comandoValidarEntrada.ejecutar("all");
        
        comandoNuevoComentarioEntrada.ejecutar("Esto es un comentario");
        
        comandoVotarComentario.ejecutar("(1) like");
        
        comandoVotarEntrada.ejecutar("(1)  dislike");
        
        comandoNuevaSubscripcion.ejecutar("SubForo 1");
        
        comandoEliminarSubscripcion.ejecutar("SubForo 1");

        comandoLogout.ejecutar("Salir");

        comandoLogin.ejecutar("EmailUsuario ContraseñaUsuario"); //Donde pone EmailUsuario es el nick, tendriamos que poner que ponga el correo y recortarlo


        /*entradaActual = new Entrada(usuarioActual);
        entradaActual.construirEntrada();
        entradaActual.mostrar();*/
    }

}
