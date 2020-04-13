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
    
    @Override
    public void mostrar(){
        System.out.println("El enunciado del ejercicio es el siguiente: \n" + this.enunciado);
        System.out.println();
        System.out.println("El subenunciado del ejercicio es " + this.subenunciado);
    }
    
}
