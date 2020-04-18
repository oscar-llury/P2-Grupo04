
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
    private boolean validado;
    
    public Comentario(Usuario autor, String texto){
        this.texto = texto;
        this.autor = autor;
        this.puntuaciones = new HashMap<>();
        this.comentarios = new ArrayList<>();
        this.negativo = 0;
        this.positivo = 0;
        this.validado = false;
    }
    
   
    /**
     * Este método podrá mostrar el autor del comentario propuesto junto al comentario
     * dado y la puntuación que se le ha otorgado
    */
    public void mostrar(){
        System.out.println("Autor: " + this.autor.getNick());
        System.out.println(this.texto);
        System.out.println("Puntuación: " + contarVotos());
        // Se mostrarán los comentarios anidados 
        Iterator<Comentario> it = comentarios.iterator();
        while(it.hasNext()){
            it.next().mostrar();
        }
    }
    
    /**
     * Este método sirve para ir pidiendo los votos de los comentarios que han 
     * realizado los usuarios y a su vez contarlos
     * @return recuento de los votos positivos y negativos
     */
    public String contarVotos(){
        this.negativo = 0;
        this.positivo = 0;
        this.puntuaciones.forEach((Usuario k, Votacion v) -> {
            if (v.getVotacion()){
                this.positivo++;
            }else{
                this.negativo++;
            }
        });
        return ("Positivos: " + this.positivo + ", Negativos: " + this.negativo);
    }
    
    /**
     * Este método posibilitará al usuario votar el comentario 
     * @param votante
     * @param voto
     * @return boolean para ver si se ha votado el comentario
     */
    public boolean votarComentario(Usuario votante, boolean voto){
        boolean valido = validado;
        this.validado = true;
        this.puntuaciones.forEach((Usuario k, Votacion v) -> {
            if (k.getNick().equals(votante.getNick())){
                validado = false;
            }
        });
        boolean devolver = false;
        if(validado){
            Votacion votacion = new Votacion(voto);
            this.puntuaciones.put(votante,votacion);
            devolver = true;
        }else{
            Votacion votoAnterior = this.puntuaciones.get(votante);
            if(!votoAnterior.equals(voto)){
                votoAnterior.votar(voto);
                devolver = true;
            }
        }
        this.validado = valido;
        contarVotos();
        return devolver;
    }
    
    // Utilizaremos este método para ir añadiendo los comentarios
    public void addComentario(Comentario comentarios) {
        this.comentarios.add(comentarios);
    }
    
    /**
     * Este método nos servirá para validar los comentarios para comprobar 
     * no se reciben comentarios mediante palabras inadecuadas 
     */
    public void validar() {
        String str = this.texto.toLowerCase();
        String[] words = str.split(" ");
        String censurado[] = {"idiota","joder","cabron"};        
        for (String word : words) {
            for (String censura : censurado) {
                if (word.equals(censura)) {
                    /**
                     * Si se viesen comentarios con palabras inadecuadas se sustituirán 
                     * por asteriscos.
                     */
                    word = word.replaceAll("\\B\\w\\B","*"); 
                }
            }
        }
        Iterator<Comentario> it = comentarios.iterator();
        // Mientras tengamos comentarios, los seguiremos validando
        while(it.hasNext()){
            it.next().validar();
        }
        this.validado = true;
    }
    
    public boolean isValidado(){
        return this.validado;
    }
}
