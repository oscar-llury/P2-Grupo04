
package reddit.mpurjc;

import java.util.ArrayList;
import java.util.List;
import reddit.mpurjc.Entradas.Entrada;

public class Administrador extends reddit.mpurjc.Usuario {
    
    private List<Entrada> pendientes;

    public Administrador (String nombre, String apellidos, String email, String contraseña,boolean esAdministrador){
        super(nombre, apellidos, email, contraseña,esAdministrador);
        this.pendientes = new ArrayList();
    }
    
    /**
     * Este método es para validar las entradas que se han introducido
     * @return boolean true si es válido
     */
    public boolean validarTodasEntradas(){
        boolean valido = true;
        for (Entrada validar : pendientes) {
            if(!validar.verificar()){
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

    public Administrador getEsAdministrador() {
        return this;
    }

    public void addPendientes(Entrada pendiente) {
        this.pendientes.add(pendiente);
    }
     
    public void limpiarPendientes(){
        this.pendientes.clear();
    }
}
