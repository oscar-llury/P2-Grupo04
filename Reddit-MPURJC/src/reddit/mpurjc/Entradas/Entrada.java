package reddit.mpurjc.Entradas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import reddit.mpurjc.Usuario;

public class Entrada implements TipoEntrada{

    private int id;
    private String titulo;
    private List<TipoEntrada> contenido;
    private boolean verificado;
    private Usuario autor;
    
    public Entrada(){}
    
    public Entrada(String titulo, Usuario usuario){  
        this.titulo = titulo;
        contenido = new ArrayList<>();
        this.autor = usuario;
        this.verificado = false;
    }
    

    @Override
    public void mostrar() {
        if(this.verificado){
            System.out.println("Título: "+this.titulo);
            System.err.println("Autor: "+this.autor.getNick());
            this.contenido.forEach((iter) -> {
                iter.mostrar();
            });
        }else{
            System.out.println("Esta entrada aun no ha sido verificada por un usuario Administrador.");
        }
    }
    //devuelve true si es valida
    @Override
    public boolean validar() {
        boolean validar = true;
        for (TipoEntrada iter : this.contenido) {
            if(!iter.validar()){
                validar = false;
            }
        }
        this.verificado = validar;
        return validar;
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
    public void addEjercicio(){
        
    }   
}
