package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Comentario;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class VotarComentario extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private Entrada entradaActual;
    private String parametros;

    public VotarComentario(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
    }

    /**
     * Este método se utilizará para la votación de los comentarios y se podrán
     * votar satisfactoriamente con un like o por el contrario con un dislike
     * @param s
     * @return boolean tipo de voto like o dislike que ha realizado el usuario
     */
    @Override
    public boolean ejecutar(String s) {
       if(comprobar(s)){
            if(this.usuarioActual != null){
                this.parametros = this.parametros.replace(" ","").toLowerCase();
                // Se representarán mediante paréntesis
                int ini = this.parametros.indexOf("(");
                int fin = this.parametros.indexOf(")");
                int profundidad = contarPuntosDeProfundidad(this.parametros.substring(ini+1, fin));
                int punto1 = this.parametros.indexOf("."); 

                if (punto1 != -1){
                    int orden = Integer.parseInt(s.substring(ini+1,punto1));
                    for(int i = 2; i<profundidad; i++){

                    }
                }
                Comentario comentario1 = this.entradaActual.getComentarioPorOrden(profundidad);
                boolean voto;
                switch(this.parametros.substring(fin+1)){
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
       }else{
           return false;
       }
    }

    //Comando para la clase VotarComentario en el Foro
    @Override
    public boolean comprobar(String s) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        setForo(foro);
        int ini = s.indexOf('(');
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0,ini).toLowerCase();

        if(comando.equals("votarcomentario")){
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
        this.entradaActual = this.foro.getEntradaActual();
    }
    
    private int contarPuntosDeProfundidad(String str){
        String[] words = str.split(".");
        return 1;
    }
}
