
package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

/**
 *
 * @author javie
 */
public class NuevaSubscripcion extends ComandosSistema {

    private SubForo subforoActual;
    private Foro foro;
    private Usuario usuarioActual;
    private Entrada entradaActual;
    
    
    public void NuevsSuscripcion(Foro foro){
       this.foro = foro;
       this.subforoActual=foro.getSubForoActual();  
       this.usuarioActual = foro.getUsuarioActual();
       this.entradaActual = foro.getEntradaActual();  
    }
    
    
    @Override
    public boolean ejecutar(String s) {
       
   
        if(!foro.contieneSubForo(s)){
           
            subforoActual=foro.getSubForo(s);
            
            if(!usuarioActual.contieneSubscripcion(subforoActual)){
                
                usuarioActual.addSubscripcion(subforoActual);
            }
             return true;
        }else{
            System.out.println("El foro no contiene ese subforo");
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
    }

    @Override
    public void setForo(Foro foro) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        this.foro=foro;
        this.usuarioActual=foro.getUsuarioActual();
        this.subforoActual=foro.getSubForoActual();
        this.entradaActual=foro.getEntradaActual();
    }
    
    
}
