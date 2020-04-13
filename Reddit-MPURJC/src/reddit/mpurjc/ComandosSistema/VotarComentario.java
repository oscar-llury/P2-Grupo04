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
        
        int ini = s.indexOf("(");
        int fin = s.indexOf(")");
        int profundidad = contarPuntosDeProfundidad(s.substring(ini+1,fin));
        int punto1 = s.indexOf("."); 
        int orden = Integer.parseInt(s.substring(ini+1,punto1));
        Comentario comentario1 = this.entradaActual.getComentarioPorOrden(orden);
        
        for(int i=2; i<profundidad; i++){
            
        }
        boolean voto = Boolean.valueOf(s.substring(fin+1));
        return comentario1.votarComentario(usuarioActual, voto);
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
    }
    
    private int contarPuntosDeProfundidad(String str){
        String[] words = str.split(".");
        return 1;
    }
}
