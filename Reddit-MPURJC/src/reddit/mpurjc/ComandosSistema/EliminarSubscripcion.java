package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class EliminarSubscripcion  extends ComandosSistema{

    private Foro foro;
    private SubForo subforoActual;
    private Usuario usuarioActual;

    public EliminarSubscripcion(Foro foro){
       this.foro = foro;
       this.subforoActual = foro.getSubForoActual();  
       this.usuarioActual = foro.getUsuarioActual();
    }

    /**
     * Este método nos sirve para eliminar la subscripción al SubForo
     * @param s
     * @return true si la subscripción se ha eliminado con éxito o false en 
     * casos excepcionales
     */
    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        if(this.usuarioActual != null){
            if(foro.contieneSubForo(s)){
                if(usuarioActual.contieneSubscripcion(s)){ 
                    usuarioActual.eliminarSubcripcion(subforoActual);
                    return true;
                }else{
                    System.out.println("No estás subscrito a este SubForo.");
                    return false;
                }
            }else{
                System.out.println("Este SubForo no existe.");
                return false;
            }
        }else{
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    // Se devolverá el Foro con la subscripción correspondiente eliminada
    @Override
    public void setForo(Foro foro) {
       this.foro = foro;
       this.subforoActual = foro.getSubForoActual();  
       this.usuarioActual = foro.getUsuarioActual();
    }

}
