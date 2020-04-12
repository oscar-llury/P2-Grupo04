
package reddit.mpurjc.Entradas;

import java.util.Scanner;


public class TextoPlano implements TipoEntrada {

    protected String texto;

    public TextoPlano(String texto) {
        this.texto = texto;
    }
    
    //devuelve true si es valida
    @Override
    public boolean verificar() {
        String str = this.texto.toLowerCase();
        String[] words = str.split(" ");
        String censurado[]={"idiota","joder","cabron"};
        
        for (String word : words) {
            for (String censura : censurado) {
                if (word.equals(censura)) {
                    //words[i]=words[i].replaceAll("\\B\\w\\B","*");
                    return false;
                }
            }
        }
        //String.join(" ", words);
        return true;
    }

    @Override
    public void mostrar() {
        System.out.println("Contenido: "+this.texto);
    }
    
}
