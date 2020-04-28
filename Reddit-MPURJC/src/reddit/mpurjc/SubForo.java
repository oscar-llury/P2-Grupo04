
package reddit.mpurjc;

import java.io.Serializable;
import java.util.HashMap;
import reddit.mpurjc.Entradas.Entrada;


public class SubForo implements Serializable{

    private String nombre;
    private HashMap<Integer, Entrada> entradas;

    public SubForo(){}
    
    public SubForo(String nombre) {
        this.nombre = nombre;
        this.entradas = new HashMap();
    }
    
    
    /*------------------------GETTERS------------------------*/
    public int contarEntradas(){
        return this.entradas.size();
    }
    
    public String getNombre() {
        return nombre;
    }

    public HashMap<Integer, Entrada> getEntradas() {
        return entradas;
    }
    
    public Entrada getEntradaPorOrden(int i){
        Integer inT = new Integer(i);
        return this.entradas.get(inT);
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
