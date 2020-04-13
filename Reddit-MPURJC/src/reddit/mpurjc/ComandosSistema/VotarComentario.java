package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Comentario;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class VotarComentario extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private Entrada entradaActual;
    private Comentario comentarioActual;

    public VotarComentario(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
    }

    
    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        int ini = s.indexOf("(");
        int fin = s.indexOf(")");
        int profundidad = contarPuntosDeProfundidad(s.substring(ini+1,fin));
        int punto1 = s.indexOf("."); 
        
        
        
        if (punto1!=-1){
            int orden = Integer.parseInt(s.substring(ini+1,punto1));
            for(int i=2; i<profundidad; i++){
                
            }
        }
        Comentario comentario1 = this.entradaActual.getComentarioPorOrden(profundidad);
        boolean voto;
        switch(s.substring(fin+2)){
            case "like": voto = true;
                         break;
            case "dislike": voto = false;
                         break;
            default: voto = false;
                        break;
        }
        return comentario1.votarComentario(usuarioActual, voto);
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
