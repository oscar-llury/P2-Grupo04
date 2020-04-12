
package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

/**
 *
 * @author javie
 */
public class NuevaSubscripcion extends ComandosSistema {

    private SubForo subforo;
    private Foro foro;
    private Usuario usuarioActual;
    
    
    public void NuevsSuscripcion(SubForo subforo){
        this.subforo=subforo;
    }
    @Override
    public boolean ejecutar(String s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        if(!foro.contieneSubForo(s)){
           
           subforo=foro.getSubForo(s);
           usuarioActual.addSubscripcion(subforo);
           
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
