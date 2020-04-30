package reddit.mpurjc.Entradas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Encuesta implements TipoEntrada , Serializable{    
    
    protected String  enunciado;
    protected List<String> respuestas;
   
    public Encuesta(String s){
        
        respuestas = new ArrayList<String>();
        int separador = s.indexOf(",");
        enunciado = s.substring(1,separador);
        
        s = s.substring(separador+1,s.length());
        String opcion;
        while(separador != -1){   
            
            separador = s.indexOf(",");
            if(separador == -1)
                opcion = s.substring(1, s.length());
            else
                opcion = s.substring(1, separador);
            respuestas.add(opcion);
            s = s.substring(separador+1,s.length());
        }
    }
 
    @Override
    public void verificar() {
        mostrar();
    }

    // Se mostrará el enunciado y las opciones a las respuestas, respectivamente
    @Override
    public void mostrar() {
        int i=1;
        System.out.println("El enunciado de la encuesta es: " + enunciado);
        Iterator<String> it = respuestas.iterator();
        
        while(it.hasNext()){
            System.out.println("La opción " + i +  " :  " + it.next());
            i++;
        }
    }
}
