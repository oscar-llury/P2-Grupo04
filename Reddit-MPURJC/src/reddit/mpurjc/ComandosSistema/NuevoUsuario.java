package reddit.mpurjc.ComandosSistema;

import java.util.Scanner;
import reddit.mpurjc.Administrador;
import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class NuevoUsuario extends ComandosSistema {

    private Foro foro;
    private boolean contruyendoAdmin;
    
    public NuevoUsuario(Foro foro){
        this.foro = foro;
        this.contruyendoAdmin = false;
    }
    
    @Override
    public boolean ejecutar(String s) {
        int separador = s.indexOf(",");
        String nombre = s.substring(0,separador);
        
        s = s.substring(separador+1,s.length());
        
        separador = s.indexOf(",");
        String apellidos = s.substring(0,separador);
        
        s = s.substring(separador+1,s.length());
        
        separador = s.indexOf(",");
        String email = s.substring(0,separador);
        
        s = s.substring(separador+1,s.length());
        
        boolean unico = false;
        boolean evaluador = true;
        while ((!unico || !evaluador)){
            if(!evaluador){
                System.out.print("El email introducido no es ocrrecto o no pertenece a la URJC\n"
                        + "Introduce de nuevo el email: ");
                Scanner scan = new Scanner(System.in);
                email = scan.nextLine();
            }
            if(!foro.sinUsuarios()){
                unico = !foro.contieneUsuario(sacarNick(email));
            }else{
                unico = true;
            }
            evaluador = evaluadorEmail(email);
        }
        
        if(contruyendoAdmin){
            Administrador admin = new Administrador(nombre,apellidos,email,s,true);
            foro.insertarUsuario(admin);
            foro.setAdministrador(admin);
            this.contruyendoAdmin = false;
        }else{
            Usuario usuario = new Usuario (nombre,apellidos,email,s);
            foro.insertarUsuario(usuario);
            foro.setUsuarioActual(usuario);
        }
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
            case "admin.urjc.es": {
                this.contruyendoAdmin = true;
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
        return email.substring(0,index).toLowerCase();
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
}
