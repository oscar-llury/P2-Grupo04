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
        if(this.usuarioActual != null){
            s = s.replace(" ","").toLowerCase();
            int ini = s.indexOf("(");
            int fin = s.indexOf(")");
            int orden = Integer.parseInt(s.substring(ini+1,fin));
            boolean voto;
            switch(s.substring(fin+1)){
                case "like": voto = true;
                             break;
                case "dislike": voto = false;
                             break;
                default: voto = false;
                            break;
            }
            Entrada entradaVotar = this.subForoActual.getEntradaPorOrden(orden);  
            boolean error = entradaVotar.votarEntrada(usuarioActual, voto);
            entradaVotar.contarVotos();
            return error;
        }else{
            System.out.println("Es necesario tener iniciada sesón.");
            return false;
        }
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
