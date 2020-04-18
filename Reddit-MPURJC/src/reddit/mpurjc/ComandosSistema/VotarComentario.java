package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Comentario;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class VotarComentario extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private Entrada entradaActual;

    public VotarComentario(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
    }

    /**
     * Con este método se procederá a votar los comentarios y podremos 
     * votarlos satisfactoriamente con un like o por el contrario con un dislike
     * @param s
     * @return boolean like o dislike 
     */
    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        if(this.usuarioActual != null){
            s = s.replace(" ","").toLowerCase();
            // Se representarán mediante paréntesis
            int ini = s.indexOf("(");
            int fin = s.indexOf(")");
            int profundidad = contarPuntosDeProfundidad(s.substring(ini+1, fin));
            int punto1 = s.indexOf("."); 

            if (punto1 != -1){
                int orden = Integer.parseInt(s.substring(ini+1,punto1));
                for(int i = 2; i<profundidad; i++){

                }
            }
            Comentario comentario1 = this.entradaActual.getComentarioPorOrden(profundidad);
            boolean voto;
            switch(s.substring(fin+1)){
                case "like": voto = true;
                             break;
                case "dislike": voto = false;
                             break;
                default: voto = false;
                            break;
            }
            return comentario1.votarComentario(usuarioActual, voto);
        }else{
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuarioActual = this.foro.getUsuarioActual();
        this.entradaActual = this.foro.getEntradaActual();
    }
    
    private int contarPuntosDeProfundidad(String str){
        String[] words = str.split(".");
        return 1;
    }
}
