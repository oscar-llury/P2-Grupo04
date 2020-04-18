
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
    
    // Este método se utilizará para verificar las entradas que se han introducido
    public void validarTodasEntradas(){
        for (Entrada validar : pendientes) {
            validar.verificar();
            this.pendientes.remove(validar);
        }
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
