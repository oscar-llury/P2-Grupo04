package reddit.mpurjc;

/** 
 * Autores Práctica MP:
 * Javier Espín Prieto
 * Jorge Utrero Sevillano
 * Miguel Cendrero Ortega
 * Óscar Rivas Melar
 */

import reddit.mpurjc.ComandosSistema.*;

public class Sistema {

    public static void main(String[] args) {
        System.out.println("Bienvenido a Reddit URJC 2020");      
        
        Foro reddit = new Foro();
        

        
        // Iniciar Comandos del Sistema
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
        ComandoSalvar comandoSalvar = new ComandoSalvar(reddit);
        
        // Iniciar demostrador
        
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)");

        comandoNuevoUsuario.ejecutar("NuevoUsuario(NombreUsuario,ApellidosUsuario,EmailUsuario@urjc.es,ContraseñaUsuario)");
        
        
        //subForo1
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");

        comandoNuevaEntrada.ejecutar("NuevaEntrada(Entrada 1,Texto Plano, esto es el texto de la entrada 1 subforo 1.)");
        comandoNuevaEntrada.ejecutar("NuevaEntrada(Entrada 2,Ejercicio, esto es ejercico entrada 1 subforo 1.)");
        comandoNuevaEntrada.ejecutar("NuevaEntrada(Entrada 3,Encuesta, esto es el enunciado de la encuesta de la entrada 1 subforo 1, opcion 1, opcion 2)");
        
        //subForo2
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 2)");
        
        comandoNuevaEntrada.ejecutar("NuevaEntrada(Entrada 2,Texto Plano, esto es el texto de la entrada 2 subforo 2.)");

        
        comandoValidarEntrada.ejecutar("ValidarEntrada(all)");
        
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(Esto es un comentario)");
        
        comandoVotarComentario.ejecutar("VotarComentario((1) like)");
        
        comandoVotarEntrada.ejecutar("VotarEntrada((1) dislike)");
        
        comandoNuevaSubscripcion.ejecutar("NuevaSubscripcion(SubForo 1)");
        
        comandoEliminarSubscripcion.ejecutar("EliminarSubscripcion(SubForo 1)");

        comandoLogout.ejecutar("Logout(Salir)");

        comandoLogin.ejecutar("Login(EmailUsuario ContraseñaUsuario)"); // Donde pone EmailUsuario es el nick, tendriamos que poner que ponga el correo y recortarlo

        comandoSalvar.ejecutar("Salvar(E:/cole,hola)");

    }

}
