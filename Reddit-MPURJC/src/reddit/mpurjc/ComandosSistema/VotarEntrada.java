package reddit.mpurjc.ComandosSistema;

import java.util.ArrayList;
import java.util.List;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class VotarEntrada extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private SubForo subForoActual;
    private String parametros;
        
    public VotarEntrada(Foro foro){
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.subForoActual = foro.getSubForoActual();
    }

    /**
     * Este método se utilizará para votar las entradas correspondientes y se podrá valorar
     * de manera positiva con un like o por el contrario con un dislike
     * @param s
     * @return boolean tipo de voto like o dislike
     */
    @Override
    public boolean ejecutar(String s) {
        if(comprobar(s)){
            if(this.usuarioActual != null){
                this.parametros = this.parametros.replace(" ","").toLowerCase();
                int ini = this.parametros.indexOf("(");
                int fin = this.parametros.indexOf(")");
                int orden = Integer.parseInt(s.substring(ini+1,fin));
                boolean voto;
                switch(this.parametros.substring(fin+1)){
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
                System.out.println("Es necesario tener iniciada sesión.");
                return false;
            }
        
        }else {
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
       // throw new UnsupportedOperationException("Not supported yet."); 
        
       setForo(foro);
        int ini = s.indexOf('(');
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0,ini).toLowerCase();

        if(comando.equals("votarentrada")){
            this.parametros = s.substring(ini+1,fin);
            return true;
        }else{
            return false;
        }
       
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuarioActual = this.foro.getUsuarioActual();
        this.subForoActual = this.foro.getSubForoActual();
    }
    
}
