package reddit.mpurjc.Entradas;

import reddit.mpurjc.Usuario;

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
    public boolean validar() {
        String str = this.enunciado.toLowerCase();
        String[] words = str.split(" ");
        String censurado[] = {"idiota","joder","cabron"};
       
        String str2 = this.subenunciado.toLowerCase();
        
        for (String word : words){
            for (String censura : censurado) {
                if (word.equals(censura)) {
                    //words[i]=words[i].replaceAll("\\B\\w\\B","*");
                    return false;
                }
            }
        }
        return false;
    }  
    
    @Override
    public void mostrar(){
        System.out.println("El enunciado del ejercicio es el siguiente: \n" + this.enunciado);
        System.out.println();
        System.out.println("El subenunciado del ejercicio es " + this.subenunciado);
    }
    
}
