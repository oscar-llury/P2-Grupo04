/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reddit.mpurjc.ComandosSistema;

import java.util.Collection;
import java.util.Iterator;
import reddit.mpurjc.Comentario;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Entradas.TipoEntrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;

/**
 *
 * @author micen
 */
public class ComandoMostrarForo extends ComandosSistema {

    private Foro foro;
    
    
     public ComandoMostrarForo(Foro foro) {
        this.foro = foro;
        //this.comentarioActual = foro.getComentarioActual();
    }

    @Override
    public boolean ejecutar(String s) {
       setForo(this.foro);
 
       SubForo sub;
       Collection<SubForo> listaSub =  this.foro.getListaSubForos();
       Iterator <SubForo> iterSub = listaSub.iterator();

        while(iterSub.hasNext()){ //Esto mutra nombre de subforos
            sub=iterSub.next();
            System.out.println("\t"+ sub.getNombre());
            
            Entrada entrada;
            Collection<Entrada> listaEntradas = sub.getEntradas();
            Iterator <Entrada> iterEntr = listaEntradas.iterator();
            
            while(iterEntr.hasNext()){ //Esto itera por todas las entradas
                
              entrada=iterEntr.next();
              
              TipoEntrada contenido;
              Collection<TipoEntrada> listaContenido = entrada.getContenido();
              Iterator<TipoEntrada> iterCont = listaContenido.iterator();
              
              while (iterCont.hasNext()){ //Esto muesyta el contenido de cada entrada
                  contenido = iterCont.next();
                  contenido.mostrar();
              }
              
              Comentario comentario;
              Collection<Comentario> listaComentarios = entrada.getComentarios();
              Iterator<Comentario> iterCom = listaComentarios.iterator();
              
              while(iterCom.hasNext()){
                  comentario = iterCom.next();
                  System.out.println("\t \t"+comentario.getTexto());
              }
              
              
              
            }
            //sub.mostrarSubforo();

        }
        
        return true;
    }

    @Override
    public boolean comprobar(String s) {
        return true;
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
    
}
