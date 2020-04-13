package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class VotarEntrada extends ComandosSistema {

        private Foro foro;
        private Usuario usuario;
        private Entrada entradaActual;
        
        
        
        public VotarEntrada(Foro foro){
        this.foro = foro;
    }
        
    @Override
    public boolean ejecutar(String s) {
        boolean voto = Boolean.valueOf(s);
        return entradaActual.votarEntrada(usuario, voto);
        
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuario = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
    }
    
}
