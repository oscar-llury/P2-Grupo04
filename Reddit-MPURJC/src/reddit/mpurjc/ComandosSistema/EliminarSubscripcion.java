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

    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        
        if(foro.contieneSubForo(s)){
            if(usuarioActual.contieneSubscripcion(s)){ 
                usuarioActual.eliminarSubcripcion(subforoActual);
                return true;
            }else{
                System.out.println("No estás subscrito a este SubForo.");
                return false;
            }
        }else{
            System.out.println("Este SubForo no exixte.");
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
       this.foro = foro;
       this.subforoActual = foro.getSubForoActual();  
       this.usuarioActual = foro.getUsuarioActual();
    }

}
