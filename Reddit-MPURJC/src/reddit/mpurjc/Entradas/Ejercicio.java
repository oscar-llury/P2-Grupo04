package reddit.mpurjc.Entradas;

public class Ejercicio implements TipoEntrada {
    
    String enunciado;
    String subenunciado;

    public Ejercicio(String s) {
        int separador = s.indexOf(",");
        enunciado = s.substring(1, separador);
        s = s.substring(separador, s.length());
        
        subenunciado = s;
    }

    @Override
    public void verificar() {
        mostrar();
    }  
    
    // Se mostrará el enunciado y subenunciado del ejercicio, respectivamente
    @Override
    public void mostrar(){
        System.out.println("Enunciado del ejercicio: \n" + this.enunciado);
        System.out.println();
        System.out.println("Subenunciado del ejercicio: \n" + this.subenunciado);
    }
    
}
