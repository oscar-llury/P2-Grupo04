
package reddit.mpurjc;

import static java.lang.Boolean.FALSE;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import reddit.mpurjc.Entradas.Entrada;
public class Sistema {
    
    private HashMap <String, SubForo> listaSubforos;
    private HashMap <String, Usuario> listaUsuarios;

    
    public void iniciarForo(){
       
        Usuario usuarioActual = new Usuario();
        SubForo subForoActual;
        Entrada entradaActual;
        
        subForoActual = nuevoSubForo();
        nuevoUsuario(); //Esto es para registrar un usuario
        
        entradaActual = new Entrada(usuarioActual);
        entradaActual.construirEntrada();
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
        Usuario usuario;
        while(unico){
            System.out.print("Email del nuevo usuario: ");
            Scanner scanEmail = new Scanner(System.in);
            String email = scanEmail.nextLine();
            unico = esUnicoUsuario(email);
            if (unico){
                System.out.print("Nombre del nuevo usuario: ");
                Scanner scanNombre = new Scanner(System.in);
                String nombre = scanNombre.nextLine();
                System.out.print("Contraseña del nuevo usuario: ");
                Scanner scanContraseña = new Scanner(System.in);
                String contraseña = scanContraseña.nextLine();

                usuario = new Usuario (nombre,contraseña,email);
            }
        }
    }

}
