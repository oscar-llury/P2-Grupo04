
package reddit.mpurjc;

import java.util.List;

public class Administrador extends reddit.mpurjc.Usuario {
    
    //private List<Entrada> pendientes;
    
    private boolean esAdministrador;
    public Administrador() {
        
        
    }
    /*
    public boolean validarEntrada(Entrada entrada){
        return false;
    }
    */
    @Override
    public void setEsAdministrador(boolean esAdministrador){
        this.esAdministrador = true;
    }
}
