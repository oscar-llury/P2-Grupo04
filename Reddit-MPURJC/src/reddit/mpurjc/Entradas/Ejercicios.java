package reddit.mpurjc.Entradas;

import java.util.Scanner;

public class Ejercicios implements TipoEntrada {
    
   private String tituloEj;
   private String textoExplic;

    public Ejercicios() {
           
        System.out.print("Listado de Ejercicios");
        
        Scanner scanTituloEj = new Scanner(System.in);
        this.tituloEj = scanTituloEj.nextLine();
        
        Scanner scanTextoExplic = new Scanner(System.in);
        this.textoExplic = scanTextoExplic.nextLine();
        
        
        
        
        
    }

    @Override
    public boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        System.out.println("Título del Ejercicio: " + this.tituloEj);
        System.out.println("Descripción del Ejercicio: " + this.textoExplic);
    }
    
}
