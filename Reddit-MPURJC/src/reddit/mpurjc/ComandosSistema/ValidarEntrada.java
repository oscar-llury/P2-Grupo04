package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Administrador;
import reddit.mpurjc.Foro;

public class ValidarEntrada extends ComandosSistema {

    private Foro foro;
    private Administrador admin;

    public ValidarEntrada(Foro foro) {
        this.foro = foro;
        this.admin = foro.getAdministrador();
    }
    
    @Override
    public boolean ejecutar(String s) {
        setForo(foro);
        if(admin.hayPendientes()){
            if(admin.validarTodasEntradas()){
                admin.limpiarPendientes();
            }
        }
        return true;
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.admin = foro.getAdministrador();
    }
    
}
