
package reddit.mpurjc;

import java.util.HashMap;
import java.util.Scanner;
import reddit.mpurjc.Entradas.Entrada;
public class Sistema {
    
    private HashMap <String, SubForo> listaSubforos;
    private HashMap <String, Usuario> listaUsuarios;

    
   public void iniciarForo(){
       
        Usuario usuarioActual;
        SubForo subForoActual;
        Entrada entradaActual;
        
        subForoActual = nuevoSubForo();
        
        
   }
   
   private SubForo nuevoSubForo(){
       System.out.print("Nombre del nuevo SubForo:");
       Scanner scan = new Scanner(System.in);
       String nombre = scan.nextLine();
       SubForo subForoActual = new SubForo(nombre);
       return subForoActual;
   }
   
   
}
