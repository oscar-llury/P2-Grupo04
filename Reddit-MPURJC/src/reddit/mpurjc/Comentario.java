
package reddit.mpurjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class Comentario {
    
    private String texto;
    private HashMap <Usuario, Votacion> puntuaciones;
    private List<Comentario> comentarios;
    private Usuario autor;
    private int positivo, negativo;
    
    public Comentario(String texto){
        this.texto = texto;
        this.puntuaciones = new HashMap<>();
        this.comentarios = new ArrayList<>();
        this.negativo=0;
        this.positivo=0;
    }
    
    public void mostrar(){
        System.out.println("Autor: " + this.autor.getNick());
        System.out.println(this.texto);
        System.out.println("Puntuación: "+ contarVotos());
        //mostrar los comentarios anidados
        Iterator<Comentario> it = comentarios.iterator();
        while(it.hasNext()){
            it.next().mostrar();
        }
    }
    
    public String contarVotos(){
        this.negativo=0;
        this.positivo=0;
        this.puntuaciones.forEach((Usuario k, Votacion v) -> {
            if (v.getVotacion()){
                this.positivo++;
            }else{
                this.negativo++;
            }
        });
        
        return ("Positivos: "+this.positivo+", Negativos: "+this.negativo);
    }
}
