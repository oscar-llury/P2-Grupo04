
package reddit.mpurjc.Entradas;

import java.util.Scanner;


public class TextoPlano implements TipoEntrada {

    protected String texto;

    public TextoPlano(String texto) {
        this.texto = texto;
    }
    
    /**
     * Este método es para validar la entrada de TextoPlano con el
     * fin de que no contenga determinadas palabras en su texto
     * @return true si es válido
     */
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

    //Mostraremos el texto
    @Override
    public void mostrar() {
        System.out.println("Contenido: " + this.texto);
    }
    
}
