
package reddit.mpurjc.ComandosSistema;

public class NuevoSubForo extends ComandosSistema {

    @Override
    public boolean ejecutar(String s) {
        SubForo subForoActual = new SubForo(s);
        if (contieneSubForo(s)){
            System.out.printl("Ese subforo ya existe.")
            return false;
        } else {
            return true;
        }    
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
