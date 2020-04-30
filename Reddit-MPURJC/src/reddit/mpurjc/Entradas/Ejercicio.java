package reddit.mpurjc.Entradas;

import java.io.Serializable;

public class Ejercicio implements TipoEntrada , Serializable {
    
    String enunciado;
    String subenunciado;

    public Ejercicio(String s) {
        int separador = s.indexOf(",");
        if(separador != -1){
            enunciado = s.substring(1, separador);
            subenunciado = s.substring(separador,s.length());
        }else
            enunciado = s;
    }

    @Override
    public void verificar() {
        mostrar();
    }  
    
    // Se mostrará el enunciado y subenunciado del ejercicio, respectivamente
    @Override
    public void mostrar(){
        System.out.println("Enunciado del ejercicio: " + this.enunciado);
        System.out.println();
        if(this.subenunciado != null){
            System.out.println("Subenunciado del ejercicio: " + this.subenunciado);
        }
    }
    
}
