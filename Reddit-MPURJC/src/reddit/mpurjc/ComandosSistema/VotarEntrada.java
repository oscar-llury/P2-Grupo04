package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class VotarEntrada extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private SubForo subForoActual;
        
    public VotarEntrada(Foro foro){
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.subForoActual = foro.getSubForoActual();
    }

    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        int ini = s.indexOf("(");
        int fin = s.indexOf(")");
        int orden = Integer.parseInt(s.substring(ini+1,fin));
        boolean voto = Boolean.valueOf(s.substring(fin+1));
        Entrada entradaVotar = this.subForoActual.getEntradaPorOrden(orden);  
        boolean error = entradaVotar.votarEntrada(usuarioActual, voto);
        entradaVotar.contarVotos();
        return error;
        
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuarioActual = this.foro.getUsuarioActual();
        this.subForoActual = this.foro.getSubForoActual();
    }
    
}
