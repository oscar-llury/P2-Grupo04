
package reddit.mpurjc;

import static java.lang.Boolean.FALSE;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import reddit.mpurjc.Entradas.Entrada;
import static reddit.mpurjc.Rol.ALUMNO;
public class Sistema {
    
    private HashMap <String, SubForo> listaSubforos;
    private HashMap <String, Usuario> listaUsuarios;

    
    public void iniciarForo(){
       
        Usuario usuarioActual;
        SubForo subForoActual;
        Entrada entradaActual;
        
        usuarioActual = new Usuario();
        
        subForoActual = nuevoSubForo();
        usuarioActual = nuevoUsuario(); //Esto es para registrar un usuario
        
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

 
   
   private Usuario nuevoUsuario(){
       System.out.print("Nick del nuevo usuario: ");
       Scanner scanNick = new Scanner(System.in);
       String nick = scanNick.nextLine();
       System.out.print("Nombre del nuevo usuario: ");
       Scanner scanNombre = new Scanner(System.in);
       String nombre = scanNombre.nextLine();
       System.out.print("Contraseña del nuevo usuario: ");
       Scanner scanContraseña = new Scanner(System.in);
       String contraseña = scanContraseña.nextLine();
       System.out.print("Email del nuevo usuario: ");
       Scanner scanEmail = new Scanner(System.in);
       String email = scanEmail.nextLine();
       Rol rol = ALUMNO;
       Usuario usuarioActual = new Usuario (nick,nombre,contraseña,email,rol);
       return usuarioActual;
   }
   
}
