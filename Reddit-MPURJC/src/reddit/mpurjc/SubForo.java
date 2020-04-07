
package reddit.mpurjc;

import java.util.HashMap;
import reddit.mpurjc.Entradas.Entrada;


public class SubForo {

    private String nombre;
    private HashMap<Integer, Entrada> entradas;

    public SubForo(){}
    
    public SubForo(String nombre) {
        this.nombre = nombre;
    }
    
    
    /*------------------------GETTERS------------------------*/

    
    public String getNombre() {
        return nombre;
    }

    public HashMap<Integer, Entrada> getEntradas() {
        return entradas;
    }
    
    public boolean contieneEntrada(Entrada entrada){
        return this.entradas.containsValue(entrada);
    }
    /*------------------------SETTERS------------------------*/
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEntradas(HashMap<Integer, Entrada> entradas) {
        this.entradas = entradas;
    }
    
    public void insertarEntrada(Entrada entrada){
        this.entradas.put(entrada.getId(), entrada);
    }
}
