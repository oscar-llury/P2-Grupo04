
package reddit.mpurjc.Entradas;

import java.io.Serializable;
import java.util.Scanner;


public class TextoPlano implements TipoEntrada , Serializable {

    protected String texto;

    public TextoPlano(String texto) {
        this.texto = texto;
    }

    @Override
    public void verificar() {
        mostrar();
    }

    // Se mostrará el contenido del texto propuesto
    @Override
    public void mostrar() {
        System.out.println("Contenido: " + this.texto);
    }
    
}
