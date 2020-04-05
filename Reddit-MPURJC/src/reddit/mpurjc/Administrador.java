
package reddit.mpurjc;

import java.util.List;
import reddit.mpurjc.Entradas.Entrada;

public class Administrador extends reddit.mpurjc.Usuario {
    
    private List<Entrada> pendientes;
    private boolean esAdministrador;

    public Administrador (String nombre, String apellidos, String email, String contraseña){
        super(nombre, apellidos, email, contraseña);
        this.esAdministrador = true;
    }
    
    public boolean validarTodasEntradas(){
        boolean valido = true;
        for (Entrada validar : pendientes) {
            if(!validar.validar()){
                valido = false;
            }
        }
        return valido;
    }
    
    public boolean hayPendientes(){
        boolean pendiente = false;
        for (Entrada validar : pendientes) {
            if(!validar.isVerificado()){
                pendiente = true;
            }
        }
        return pendiente;
    }
    
    @Override
    public void setEsAdministrador(boolean esAdministrador){
        this.esAdministrador = esAdministrador;
    }

    public boolean getEsAdministrador() {
        return esAdministrador;
    }
    
}
