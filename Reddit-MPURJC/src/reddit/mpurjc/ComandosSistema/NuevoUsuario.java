package reddit.mpurjc.ComandosSistema;

import java.util.Scanner;
import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class NuevoUsuario extends ComandosSistema {

    private Foro foro;
    
    public NuevoUsuario(Foro foro){
        this.foro = foro;
    }
    
    @Override
    public boolean ejecutar(String s) {
        int separador = s.indexOf(",");
        String nombre = s.substring(1,separador);
        
        s = s.substring(separador,s.length());
        
        separador = s.indexOf(",");
        String apellidos = s.substring(1,separador);
        
        s = s.substring(separador,s.length());
        
        separador = s.indexOf(",");
        String email = s.substring(1,separador);
        
        s = s.substring(separador,s.length());
        
        String pass = s;
        
        boolean unico = true;
        boolean evaluador = true;
        while (!(unico || evaluador)){
            if(!evaluador){
                System.out.print("El email introducido no es ocrrecto o no pertenece a la URJC\n"
                        + "Introduce de nuevo el email: ");
                Scanner scan = new Scanner(System.in);
                email = scan.nextLine();
            }
            unico = !foro.contieneUsuario(sacarNick(email));
            evaluador = evaluadorEmail(email);
        }
        
        Usuario usuario = new Usuario (nombre,apellidos,email,pass);
        foro.insertarUsuario(usuario);
        return true;
    }

    @Override
    public boolean comprobar(String s) {
        return s.equals("BorrarHoja");
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
    private String sacarNick(String email){
        int index = email.indexOf("@");
        return email.substring(0,index-1).toLowerCase();
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
}
