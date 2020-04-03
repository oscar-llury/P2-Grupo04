
package reddit.mpurjc.Entradas;

import java.util.Scanner;


public class TextoPlano implements TipoEntrada {

       protected String texto;

    public TextoPlano() {

        System.out.print("Time el contenido del Texto");
        Scanner scanTexto = new Scanner(System.in);
        this.texto = scanTexto.nextLine();
    }
    @Override
    public boolean validar() {
        return texto.equals("");
    }

    @Override
    public void mostrar() {
        System.out.println("Contenido: "+this.texto);
    }
    
}
