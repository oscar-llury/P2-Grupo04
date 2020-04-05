package reddit.mpurjc.Entradas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import reddit.mpurjc.Usuario;

public class Entrada implements TipoEntrada{

    private String titulo;
    private List<TipoEntrada> contenido;
    private boolean verificado;
    private Usuario autor;
    
    public Entrada(){}
    
    public Entrada(Usuario usuario){
        contenido = new ArrayList<>();
        this.autor = usuario;
        this.verificado = false;
    }
    
    public void construirEntrada(){
        System.out.print("Time el título: ");
        Scanner scanTitulo = new Scanner(System.in);
        this.titulo = scanTitulo.nextLine();
        
        System.out.print("De que tipo quieres la entrada:\nTexto Plano [1]\n Encuenstas [2]\n Ejercicios [3]");
        Scanner scanTipo = new Scanner(System.in);
        int tipo = scanTipo.nextInt();
        switch(tipo){
            case 1: {
                TextoPlano entrada = new TextoPlano();
                this.contenido.add(entrada);
            }
            case 2: {
                Encuesta entrada = new Encuesta();
                this.contenido.add(entrada);
            }
            case 3: {
                Ejercicios entrada = new Ejercicios();
                this.contenido.add(entrada);
            }
            default: {
                System.out.println("Por defecto la entrada es de Texto Plano");
                TextoPlano entrada = new TextoPlano();
                this.contenido.add(entrada);
            }
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

    @Override
    public void mostrar() {
        this.contenido.forEach((iter) -> {
            iter.mostrar();
        });
    }

    public boolean isVerificado() {
        return verificado;
    }
    
}
