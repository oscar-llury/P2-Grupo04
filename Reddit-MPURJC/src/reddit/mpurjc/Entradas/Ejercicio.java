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
    public boolean verificar() {
        String str = this.enunciado.toLowerCase();
        String[] words = str.split(" ");
        String censurado[] = {"idiota","joder","cabron"};

        for (String word : words){
            for (String censura : censurado) {
                if (word.equals(censura)) {
                    //words[i]=words[i].replaceAll("\\B\\w\\B","*");
                    return false;
                }
            }
        }        
        String str2 = this.subenunciado.toLowerCase();
        String[] words2 = str2.split(" ");
        for (String word : words2){
            for (String censura : censurado) {
                if (word.equals(censura)) {
                    //words[i]=words[i].replaceAll("\\B\\w\\B","*");
                    return false;
                }
            }
        }
        return true;
    }  
    
    //Mostramos el enunciado y subenunciado del ejercicio
    @Override
    public void mostrar(){
        System.out.println("Enunciado del ejercicio: \n" + this.enunciado);
        System.out.println();
        System.out.println("Subenunciado del ejercicio: \n" + this.subenunciado);
    }
    
}
