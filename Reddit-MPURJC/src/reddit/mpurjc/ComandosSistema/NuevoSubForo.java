
package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;

public class NuevoSubForo extends ComandosSistema {

    private Foro foro;
    
    public NuevoSubForo(Foro foro){
        this.foro = foro;
    }
    
    /**
     * Este método se utilizará para crear un nuevo SubForo.
     * @param s
     * @return true si se ha creado el subforo satisfactoriamente o false en casos 
     * excepcionales
     */
    @Override
    public boolean ejecutar(String s) {
        if(this.foro.getUsuarioActual() != null){
        /**
         * // Podremos crear el subforo siempre y cuando el Foro no contenga subforos 
         * o que el Foro no tenga ya ese subforo a crear.
         */
        if (foro.sinSubForos() || !foro.contieneSubForo(s)){ 
            SubForo nuevoSubForo = new SubForo(s);
            foro.insertarSubForo(nuevoSubForo);
            foro.setSubForoActual(nuevoSubForo);
            return true;
        } else {
            System.out.println("Ese subforo ya existe.");
            return false;
        }
        }else{
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
        return s.equals("Nuevo SubForo");
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
    
}
