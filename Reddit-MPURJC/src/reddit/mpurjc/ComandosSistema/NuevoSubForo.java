
package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;

public class NuevoSubForo extends ComandosSistema {

    private Foro foro;
    private String parametros;
    
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
        
        if(comprobar(s)){
            if(this.foro.getUsuarioActual() != null){
            /**
             * // Podremos crear el subforo siempre y cuando el Foro no contenga subforos 
             * o que el Foro no tenga ya ese subforo a crear.
             */
            if (foro.sinSubForos() || !foro.contieneSubForo(this.parametros)){ 
                SubForo nuevoSubForo = new SubForo(this.parametros);
                foro.insertarSubForo(nuevoSubForo);
                foro.setSubForoActual(nuevoSubForo);
                System.out.println("SubForo creado correctamente.");
                return true;
            } else {
                System.out.println("Ese subforo ya existe.");
                return false;
            }
            }else{
                System.out.println("Es necesario tener iniciada sesión.");
                return false;
            }
        }else{
            return false;
        }
    }

    //Comando para la clase NuevoSubForo en el Foro
    @Override
    public boolean comprobar(String s) {
         setForo(foro);
        int ini = s.indexOf('(');
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0,ini).toLowerCase();

        if(comando.equals("nuevosubforo")){
            this.parametros = s.substring(ini+1,fin);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
    
}
