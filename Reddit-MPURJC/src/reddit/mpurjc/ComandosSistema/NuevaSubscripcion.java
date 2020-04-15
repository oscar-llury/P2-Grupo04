package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class NuevaSubscripcion extends ComandosSistema {

    private Foro foro;
    private SubForo subforoActual;
    private Usuario usuarioActual;
    
    public NuevaSubscripcion(Foro foro){
       this.foro = foro;
       this.subforoActual = foro.getSubForoActual();
       this.usuarioActual = foro.getUsuarioActual();
    }

    @Override
    public boolean ejecutar(String s) {
       setForo(this.foro);
       if(this.usuarioActual != null){
            if(!usuarioActual.contieneSubscripcion(s)){
                usuarioActual.addSubscripcion(subforoActual);
                return true;
            }else{
                System.out.println("Ya estás subscrito a este SubForo.");
                return false;
            }
       }else{
           System.out.println("Es necesario tener iniciada sesón.");
            return false;
       }
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    @Override
    public void setForo(Foro foro) {
        this.foro=foro;
        this.usuarioActual=foro.getUsuarioActual();
        this.subforoActual=foro.getSubForoActual();
    }
    
    
}
