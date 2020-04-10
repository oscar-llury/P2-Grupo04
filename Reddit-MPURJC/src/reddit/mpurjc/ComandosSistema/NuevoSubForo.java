
package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;

public class NuevoSubForo extends ComandosSistema {

    private Foro foro;
    
    public NuevoSubForo(Foro foro){
        this.foro = foro;
    }
    
    @Override
    public boolean ejecutar(String s) {
        
        if (!foro.contieneSubForo(s)){
            SubForo nuevoSubForo = new SubForo(s);
            foro.insertarSubForo(nuevoSubForo);
            foro.setSubForoActual(nuevoSubForo);
            return true;
        } else {
            System.out.println("Ese subforo ya existe.");
            return false;
        }    
    }

    @Override
    public boolean comprobar(String s) {
        return s.equals("Nuevo´SubForo");
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
    
}
