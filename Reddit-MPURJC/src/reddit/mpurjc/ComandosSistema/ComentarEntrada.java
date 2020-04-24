package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Comentario;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class ComentarEntrada extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private Entrada entradaActual;

    public ComentarEntrada(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
    }
    
    /**
     * Este método se utilizará para comentar las entradas propuestas
     * @param s
     * @return boolean true en caso de que se haya comentado con éxito la entrada o 
     * false en otros casos 
     */
    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        if(this.usuarioActual != null){
            if(this.entradaActual.isVerificado()){
                Comentario nuevoComentario = new Comentario(usuarioActual,s);
                nuevoComentario.validar();
                if(nuevoComentario.isValidado()){
                    this.entradaActual.addComentario(nuevoComentario);
                    return true;
                }else{
                    System.out.println("El comentario no es aceptado.");
                    //add penalizacion
                    return false;
                }
            }else{
                System.out.println("No se ha podido comentar la entrada.");
                return false;
            }
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
    
}
