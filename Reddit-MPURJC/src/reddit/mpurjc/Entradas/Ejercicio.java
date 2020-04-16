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

    /**
     * Este método es para validar la entrada de Ejercicio con el
     * fin de que no contenga determinadas palabras en su enunciado
     * y subenunciado
     * @return true si es válido
     */
    @Override
    public void verificar() {
        mostrar();
    }  
    
    //Mostramos el enunciado y subenunciado del ejercicio
    @Override
    public void mostrar(){
        System.out.println("Enunciado del ejercicio: \n" + this.enunciado);
        System.out.println();
        System.out.println("Subenunciado del ejercicio: \n" + this.subenunciado);
    }
    
}
