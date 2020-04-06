package reddit.mpurjc.Entradas;

import java.util.Scanner;
import reddit.mpurjc.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio implements TipoEntrada {
    
   private String tituloEj;
   private String textoExplic;
   private List<Ejercicio> lista = new ArrayList<Ejercicio>();
   
    Ejercicio() {
       
    }

    public Ejercicio(Usuario Usuario) {
           
        System.out.println("Vas a crear un ejercicio");
        
        Scanner scanTituloEj = new Scanner(System.in);
        this.tituloEj = scanTituloEj.nextLine();
       
        Scanner scanTextoExplic = new Scanner(System.in);
        this.textoExplic = scanTextoExplic.nextLine();
            
    }

    public void addEjercicio(Ejercicio ej){
        lista.add(ej);
    }

    @Override
    public boolean validar() {
        for (Ejercicio ej: lista){
            ej.validar();
            System.out.println("El ejercicio ha sido validado");
        }
       return false;
       
    }
    @Override
    public void mostrar() {
        
        System.out.println("El ejercicio ha sido creado satisfactoriamente");
        System.out.println("Título del Ejercicio: " + this.tituloEj);
        System.out.println("Descripción del Ejercicio: " + this.textoExplic);
    }
    
}
