package reddit.mpurjc.Entradas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import reddit.mpurjc.Comentario;
import reddit.mpurjc.Penalizacion;
import reddit.mpurjc.Usuario;
import reddit.mpurjc.Votacion;

public class Entrada implements TipoEntrada , Serializable{

    private int id;
    private String titulo;
    private List<TipoEntrada> contenido;
    private boolean verificado;
    private Usuario autor;
    private List<Comentario> comentarios;
    private HashMap <Usuario, Votacion> puntuaciones;
    private int positivo, negativo;
    
    public Entrada(){}
    
    public Entrada(int id, String titulo, Usuario usuario){  
        this.titulo = titulo;
        contenido = new ArrayList<>();
        this.autor = usuario;
        this.verificado = false;
        this.puntuaciones = new HashMap<>();
        this.comentarios = new ArrayList<>();
        this.negativo = 0;
        this.positivo = 0;
        this.id = id;
    }
    

    /**
     * Este método se utilizará para en el caso de que esté verificado nos mostrará el 
     * título, autor y puntuación de las votaciones contadas en la clase 
     * VotarEntrada. También nos mostrará los comentarios de dichas entradas.
     */
    @Override
    public void mostrar() {
        if(this.verificado){
            System.out.println("Título: " + this.titulo);
            System.out.println("Autor: " + this.autor.getNick());
            System.out.println("Puntuación: " + contarVotos());
            this.contenido.forEach((iter) -> {
                iter.mostrar();
            });
            System.out.println("Comentarios: ");
            this.comentarios.forEach((iter) -> {
                iter.mostrar();
            });
        }else{
            System.out.println("Esta entrada aún no ha sido verificada por un usuario Administrador.");
        }
    }
    
    
    /**
     * Se procederá a verificar la entrada y en el caso de que no se haya verificado
     * se impondrá la correspondiente penalización
     */
    @Override
    public void verificar() {
        for (TipoEntrada iter : this.contenido) {
            iter.verificar();
        }
        System.out.println("¿Deseas verificar la entrada?");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        s = s.toLowerCase();
        this.verificado = s.equals("si");
        
        if(!this.verificado){
            if(this.autor.getPenalizacion().isPenalizado()){
                Penalizacion penalizacion = this.autor.getPenalizacion();
                penalizacion.actualizarPenalizacion();
            }else{
                Penalizacion penalizacion = new Penalizacion();
                this.autor.setPenalizacion(penalizacion);
            }
        }
        
    } 
    
    /**
     * Este método se utilizará para contar los votos de las entradas positiva o 
     * negativamente
     * @return Listado con los votos positivos y los votos negativos, respectivamente.
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
     * Este método se utilizará para la votación de las entradas y su correspondiente 
     * almacenamiento
     * @param votante
     * @param voto
     * @return true en caso de que la votación se haya realizado con éxito
     */
    public boolean votarEntrada(Usuario votante, boolean voto){
        boolean valido = verificado;
        this.puntuaciones.forEach((Usuario k, Votacion v) -> {
            if (k.getNick().equals(votante.getNick())){
                verificado = false;
            }
        });
        boolean devolver = false;
        if(verificado){
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
        this.verificado = valido;
        return devolver;
    }
    
    
    /*------------------------GETTERS------------------------*/
    public boolean isVerificado() {
        return this.verificado;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<TipoEntrada> getContenido() {
        return contenido;
    }

    public Usuario getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }
    
    public Comentario getComentarioPorOrden(int i){
        return this.comentarios.get(i-1);
    }
    
    /*------------------------SETTERS------------------------*/

    public void setContenido(List<TipoEntrada> contenido) {
        this.contenido = contenido;
    }
    
    public void addTextoPlano(String s){
        TextoPlano textoPlano = new TextoPlano(s);
        this.contenido.add(textoPlano);
    }
    
    public void addEncuesta(String s){
        Encuesta encuesta = new Encuesta(s);
        this.contenido.add(encuesta);

    }
    public void addEjercicio(String s){
        Ejercicio ejercicio = new Ejercicio(s);
        this.contenido.add(ejercicio);    
    }  

    public void addComentario(Comentario comentarios) {
        this.comentarios.add(comentarios);
    }
    
}
