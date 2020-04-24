package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class Logout extends ComandosSistema {
    private Foro foro;


    public Logout(Foro foro) {
        this.foro = foro;
    }


    /**
     * Este método nos servirá simplemente para cerrar la sesión del usuario
     * @param s
     * @return true si el cierre de sesión ha sido correcta
     */
    @Override
    public boolean ejecutar(String s) {
        if(s.toLowerCase().equals("salir")){
            setForo(foro);
           foro.setUsuarioActual(null);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
}
