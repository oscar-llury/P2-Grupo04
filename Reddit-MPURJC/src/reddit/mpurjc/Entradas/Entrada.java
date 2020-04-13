package reddit.mpurjc.Entradas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import reddit.mpurjc.Comentario;
import reddit.mpurjc.Usuario;
import reddit.mpurjc.Votacion;

public class Entrada implements TipoEntrada{

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
        this.negativo=0;
        this.positivo=0;
        this.id = id;
    }
    

    @Override
    public void mostrar() {
        if(this.verificado){
            System.out.println("Título: "+this.titulo);
            System.out.println("Autor: "+this.autor.getNick());
            System.out.println("Puntuación: "+ contarVotos());
            this.contenido.forEach((iter) -> {
                iter.mostrar();
            });
            System.out.println("Comentarios: ");
            this.comentarios.forEach((iter) -> {
                iter.mostrar();
            });
        }else{
            System.out.println("Esta entrada aun no ha sido verificada por un usuario Administrador.");
        }
    }
    //devuelve true si es valido su contenido (tipo de entrada)
    @Override
    public boolean verificar() {
        boolean validar = true;
        for (TipoEntrada iter : this.contenido) {
            if(!iter.verificar()){
                validar = false;
            }
        }
        this.verificado = validar;
        return validar;
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
    
    public boolean votarEntrada(Usuario votante, boolean voto){
        boolean valido = verificado;
        this.puntuaciones.forEach((Usuario k, Votacion v) -> {
            if (k.getNick().equals(votante.getNick())){
                verificado=false;
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
        this.verificado=valido;
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
        Encuesta encuesta=new Encuesta(s);
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
