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
        ComentarComentario comandoComentarComentario = new ComentarComentario(reddit);
        VotarComentario comandoVotarComentario = new VotarComentario(reddit);
        VotarEntrada comandoVotarEntrada = new VotarEntrada(reddit);
        ValidarEntrada comandoValidarEntrada = new ValidarEntrada(reddit);
        NuevaSubscripcion comandoNuevaSubscripcion = new NuevaSubscripcion(reddit);
        EliminarSubscripcion comandoEliminarSubscripcion = new EliminarSubscripcion(reddit);
        Logout comandoLogout = new Logout(reddit);
        Login comandoLogin = new Login(reddit);
        ComandoSalvar comandoSalvar = new ComandoSalvar(reddit);
        ComandoCargar comandoCargar = new ComandoCargar(reddit);
        ComandoMostrarForo comandoMostrarForo = new ComandoMostrarForo(reddit);
        // Iniciar demostrador
        
        
        
        //pintar foro

        
        
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Admin,Admin,Admin@admin.urjc.es,AdminPass)");

        comandoNuevoUsuario.ejecutar("NuevoUsuario(Profesor1,ApellidosUsuario,emailProfesor@urjc.es,pass)");

        //subForo1
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 2)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 3)");
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 4)");
        
        
        
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Entrada 1,Texto Plano, esto es el texto de la entrada 1 subforo 1|"
        +"Ejercicio, esto es ejercico entrada 1 subforo 1.)");
        
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 1,Entrada 2,Encuesta, esto es el enunciado de la encuesta de la entrada 1 subforo 1, opcion 1, opcion 2)");
            
            //un administrador externo valida las entradas
            comandoValidarEntrada.ejecutar("ValidarEntrada(all)");
            //decirSi("Si");
        
        
        
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 2)");
        
        comandoMostrarForo.ejecutar("");
        
        comandoComentarComentario.ejecutar("ComentarComentario(SubForo 1.1.1-Esto es un comentario a un comentario)");
        
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 2)");
        
        //subForo2

        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 2)");

        
        comandoLogout.ejecutar("Logout()");
        
        //nuevo usuario alumno
        
        comandoNuevoUsuario.ejecutar("NuevoUsuario(Alumno1,ApellidosUsuario,emailAlumno@alumnos.urjc.es,pass)");
        
        //comandoLogin.ejecutar("Login(emailAlumno pass)");
        
        comandoVotarEntrada.ejecutar("VotarEntrada(SubForo 1.1-dislike)");
                
        comandoVotarComentario.ejecutar("VotarComentario(SubForo 1.1.1.1-like)");
        
        comandoNuevaSubscripcion.ejecutar("NuevaSubscripcion(SubForo 1)");
        
        comandoNuevaSubscripcion.ejecutar("NuevaSubscripcion(SubForo 2)");
        
        comandoLogout.ejecutar("Logout()");
        
        //vuelve el profesor actualiza el SubForo 2
        
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 2,Entrada 1,Texto Plano, esto es el texto de la entrada 2 subforo 2.)");
        
        comandoLogout.ejecutar("Logout()");
        
        //vuelve el alumno con subscripciones
        
        comandoLogin.ejecutar("Login(emailAlumno pass)");
        
        comandoEliminarSubscripcion.ejecutar("EliminarSubscripcion(SubForo 2)");

        comandoLogout.ejecutar("Logout()");

        //vuelve el profesor para añadir una entrada nueva al SubForo 2
        
        comandoLogin.ejecutar("Login(emailProfesor pass)");
        
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 2,Entrada 3,Texto Plano, esto es el texto de la entrada 3 subforo 2.)");
        
        comandoLogout.ejecutar("Logout()");
        
        //vuelve el alumno sin subscripciones
        
        comandoLogin.ejecutar("Login(emailAlumno pass)");
        
        comandoEliminarSubscripcion.ejecutar("EliminarSubscripcion(SubForo 2)");

        comandoLogout.ejecutar("Logout()");
        
        //guardar Foro
        
        comandoSalvar.ejecutar("Salvar(E:/cole,hola)");
        
        
        //--------Prueba de errores---------
        System.out.println("--------Prueba de errores--------");
        
        comandoNuevoSubForo.ejecutar("NuevoSubForo(SubForo 1)");
        comandoNuevaEntrada.ejecutar("NuevaEntrada(SubForo 2,Entrada 3,Texto Plano, esto es el texto de la entrada 3 subforo 2.)");
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");
        comandoNuevoComentarioEntrada.ejecutar("ComentarEntrada(SubForo 1.1-Esto es el comentario 1)");
        
        comandoVotarEntrada.ejecutar("VotarEntrada(SubForo 1.1-dislike)");
        comandoNuevaSubscripcion.ejecutar("NuevaSubscripcion(SubForo 2)");
        comandoEliminarSubscripcion.ejecutar("EliminarSubscripcion(SubForo 2)");
        
        comandoLogin.ejecutar("Login(emailErroneo pass)");
        
        
        //--------Recuperar el foro guardado---------
        System.out.println("--------Recuperar el foro guardado--------");
        
        comandoCargar.ejecutar("Cargar(E:/cole/hola.txt)");
        
        //mostrar foro
    }

}
