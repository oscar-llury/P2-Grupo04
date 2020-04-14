/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

/**
 *
 * @author Jorge Utrero
 */
public class EliminarSubscripcion  extends ComandosSistema{
    
    
    
    private SubForo subforoActual;
    private Foro foro;
    private Usuario usuarioActual;
    private Entrada entradaActual;
    
    
    
    public void EliminarSubscripcion(){
    
       this.foro = foro;
       this.subforoActual=foro.getSubForoActual();  
       this.usuarioActual = foro.getUsuarioActual();
       this.entradaActual = foro.getEntradaActual();
    
    }

    @Override
    public boolean ejecutar(String s) {
        
        if(foro.contieneSubForo(s)){
            
            subforoActual=foro.getSubForo(s);
            
            if(usuarioActual.contieneSubscripcion(subforoActual)){
                
                usuarioActual.eliminarSubcripcion(subforoActual);
            }
            
            return true;
        }
        
       return false;
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
        this.entradaActual=foro.getEntradaActual();
    }
    
    
    
}
