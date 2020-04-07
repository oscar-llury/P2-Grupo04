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

        
        System.out.print("Nombre del nuevo SubForo: ");
        Scanner scan = new Scanner(System.in);
        String nombreSubForo = scan.nextLine();
        subForoActual = nuevoSubForo(nombreSubForo);
        listaSubforos.put(subForoActual.getNombre(),subForoActual);
        
        System.out.print("Nombre del nuevo usuario: ");
        Scanner scanNombre = new Scanner(System.in);
        String nombreUsuario = scanNombre.nextLine();
        System.out.print("Apellidos del nuevo usuario: ");
        Scanner scanApellidos = new Scanner(System.in);
        String apellidosUsuario = scanApellidos.nextLine();
        System.out.print("Email del nuevo usuario: ");
        Scanner scanEmail = new Scanner(System.in);
        String emailUsuario = scanEmail.nextLine();
        System.out.print("Contraseña del nuevo usuario: ");
        Scanner scanContraseña = new Scanner(System.in);
        String contraseñaUsuario = scanContraseña.nextLine();
        
        nuevoUsuario(nombreUsuario, apellidosUsuario, emailUsuario, contraseñaUsuario);
        listaUsuarios.put(usuarioActual.getNick(),usuarioActual);
        entradaActual = new Entrada(usuarioActual);
        entradaActual.construirEntrada();
        entradaActual.mostrar();
    }
   
    private boolean esUnicoUsuario(String nick){
        return !listaUsuarios.containsKey(nick);
    }

    public boolean contieneSubForo (String nombre){
        return listaSubforos.containsKey(nombre);
    }
   
    private void nuevoUsuario(String nombre, String apellidos, String email, String contraseña){
        boolean unico = true;
        boolean evaluador = true;
        while(unico || evaluador){
            unico = esUnicoUsuario(email);
            evaluador = evaluadorEmail(email);
        }
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
