
package reddit.mpurjc;

import java.util.HashMap;
import java.util.List;

public class Comentario {
    
    private String texto;
    private HashMap <Usuario, Votacion> puntuaciones;
    private List<Comentario> comentarios;
    
    private boolean verificarComentario(){
        return false;
    }
}
