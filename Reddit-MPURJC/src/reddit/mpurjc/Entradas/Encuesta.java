package reddit.mpurjc.Entradas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import reddit.mpurjc.Usuario;

public class Encuesta implements TipoEntrada {    
    
    protected String enunciado, opcion ;
    protected int nOpciones;
   
    
    
    public Encuesta(){
        List<String> opciones=new ArrayList<String>();
        System.out.print("Escribe el enunciado de la encuesta: ");
        Scanner scanTexto = new Scanner(System.in);
        this.enunciado = scanTexto.nextLine();
        
        System.out.print("Escribe el numero de opciones:");
        this.nOpciones = scanTexto.nextInt();
        
        for(int i=1;i<=nOpciones;i++){
            System.out.println("Escribe la opcion numero "+ i);
            this.opcion=scanTexto.nextLine();
            opciones.add(opcion);
        }
        
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
