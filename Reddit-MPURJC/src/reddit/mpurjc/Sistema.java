package reddit.mpurjc;

import java.util.HashMap;
import java.util.Scanner;
import reddit.mpurjc.Entradas.Entrada;
public class Sistema {
    
    private HashMap <String, SubForo> listaSubforos;
    private HashMap <String, Usuario> listaUsuarios;

    
    public void iniciarForo(){
        SubForo subForoActual;
        Entrada entradaActual;
        Usuario usuarioActual;

        subForoActual = nuevoSubForo();
        
        //nuevoUsuario(); //Esto es para registrar un usuario
        
        usuarioActual = new Usuario();
        entradaActual = new Entrada(usuarioActual);
        entradaActual.construirEntrada();
        entradaActual.mostrar();
    }
   
    private SubForo nuevoSubForo(){
        System.out.print("Nombre del nuevo SubForo: ");
        Scanner scan = new Scanner(System.in);
        String nombre = scan.nextLine();
        SubForo subForoActual = new SubForo(nombre);
        return subForoActual;
    }

    private boolean esUnicoUsuario(String nick){
        return !listaUsuarios.containsKey(nick);
    }
   
    private void nuevoUsuario(){
        boolean unico = true;
        boolean evaluador = true;
        String email = "";
        while(unico || evaluador){
            System.out.print("Email del nuevo usuario: ");
            Scanner scanEmail = new Scanner(System.in);
            email = scanEmail.nextLine();
            unico = esUnicoUsuario(email);
            evaluador = evaluadorEmail(email);
        }
        
        System.out.print("Nombre del nuevo usuario: ");
        Scanner scanNombre = new Scanner(System.in);
        String nombre = scanNombre.nextLine();
        System.out.print("Apellidos del nuevo usuario: ");
        Scanner scanApellidos = new Scanner(System.in);
        String apellidos = scanApellidos.nextLine();
        System.out.print("Contraseña del nuevo usuario: ");
        Scanner scanContraseña = new Scanner(System.in);
        String contraseña = scanContraseña.nextLine();

        //setusuarioactual
        Usuario usuario = new Usuario (nombre,apellidos,email,contraseña);

    }
        private boolean evaluadorEmail(String email){
        int longitud = email.length();
        int index = email.indexOf("@");
        String subEmail = email.substring(index+1,longitud);
        switch (subEmail.toLowerCase()){
            case "alumnos.urjc.es": {
                return true;
            }                       
            case "urjc.es": {
                return true;
            }
            default: {
                System.out.println("Debes introducir un correo de la urjc");
                return false;
            }                
        }
    }

}
