
package reddit.mpurjc.Entradas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import reddit.mpurjc.Usuario;

public class Entrada implements TipoEntrada{

    private List<TipoEntrada> contenido;
    private boolean verificado;
    private Usuario autor;
    
    public void Entrada(){}
    
    public void ConstruirEntrada(){
        System.out.println("De que tipo quieres la entrada:\nTexto Plano [1]\n Encuenstas [2]\n Ejercicios [3]");
        Scanner scanTipo = new Scanner(System.in);
        int tipo = scanTipo.nextInt();
        
        System.out.println("Time el título");
        Scanner scanTitulo = new Scanner(System.in);
        String titulo = scanTitulo.nextLine();
        System.out.println("Time el contenido del Texto");
        Scanner scanTexto = new Scanner(System.in);
        String texto = scanTexto.nextLine();
        TextoPlano entrada = new TextoPlano(titulo, texto);
        
        /*switch(tipo){
            case 1:{
                System.out.println("Time el título");
                Scanner scanTitulo = new Scanner(System.in);
                String titulo = scanTitulo.nextLine();
                System.out.println("Time el contenido del Texto");
                Scanner scanTexto = new Scanner(System.in);
                String texto = scanTexto.nextLine();
                TextoPlano entrada = new TextoPlano(titulo, texto);
            }
        }*/
        entrada.mostrar();
    }
    
    
    @Override
    public boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
