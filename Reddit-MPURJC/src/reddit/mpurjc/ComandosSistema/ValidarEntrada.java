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
    
    /**
     * Este método se utilizará para que el administrador pueda validar las entradas 
     * introducidas
     * @param s
     * @return true si se han validado con éxito
     */
    @Override
    public boolean ejecutar(String s) {
        setForo(foro);
        if(admin.hayPendientes()){
            admin.validarTodasEntradas();
        }
        return true;
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.admin = foro.getAdministrador();
    }
    
}
