package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Comentario;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class VotarComentario extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private Entrada entradaActual;
    private Comentario comentarioActual;
    private String parametros;

    public VotarComentario(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
    }

    /**
     * Este método se utilizará para la votación de los comentarios y se podrán
     * votar satisfactoriamente con un like o por el contrario con un dislike
     *
     * @param s
     * @return boolean tipo de voto like o dislike que ha realizado el usuario
     * SubForo 1.1.1.1-like
     */
    @Override
    public boolean ejecutar(String s) {
        if (comprobar(s)) {
            buscarComentarioActual(this.parametros);
            if ((this.usuarioActual != null) && (this.entradaActual.isVerificado())) {
                this.parametros = this.parametros.replace(" ", "").toLowerCase();

                boolean voto;
                switch (this.parametros) {
                    case "like":
                        voto = true;
                        break;
                    case "dislike":
                        voto = false;
                        break;
                    default:
                        voto = false;
                        break;
                }
                return this.comentarioActual.votarComentario(usuarioActual, voto);
            } else {
                System.out.println("Es necesario tener iniciada sesión.");
                return false;
            }
        } else {
            return false;
        }
    }

    //Comando para la clase VotarComentario en el Foro
    @Override
    public boolean comprobar(String s) {
        setForo(foro);
        int ini = s.indexOf('(');
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0, ini).toLowerCase();

        if (comando.equals("votarcomentario")) {
            this.parametros = s.substring(ini + 1, fin);
            return !this.entradaActual.getComentarios().isEmpty();
        } else {
            return false;
        }
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuarioActual = this.foro.getUsuarioActual();
        this.entradaActual = this.foro.getEntradaActual();
    }

    private int contarPuntosDeProfundidad(String str) {
        int punto1 = str.indexOf(".");
        if (punto1 != -1) {
            String[] words = str.split("\\.");
            return words.length;
        } else {
            return 1;
        }
    }

    private void buscarComentarioActual(String s) {

        int fin = s.indexOf(".");
        String subforo = s.substring(0, fin);
        s = s.substring(fin + 1);
        SubForo subForoActual = this.foro.getSubForo(subforo);
        fin = s.indexOf(".");
        int orden = Integer.parseInt(s.substring(0, fin));
        s = s.substring(fin + 1);
        fin = s.indexOf("-");
        this.entradaActual = subForoActual.getEntradaPorOrden(orden);
        int profundidad = contarPuntosDeProfundidad(s.substring(0, fin));
        int punto1 = this.parametros.indexOf(".");
        this.parametros = s.substring(fin + 1);

        if (punto1 != -1) {//2
            fin = s.indexOf(".");
            orden = Integer.parseInt(s.substring(0, fin));
            Comentario coment = this.entradaActual.getComentarioPorOrden(orden);
            for (int i = 1; i < profundidad; i++) {
                coment = coment.getComentarioPorOrden(i);
            }
            this.comentarioActual = coment;
        } else {
            this.comentarioActual = this.entradaActual.getComentarioPorOrden(profundidad);
        }

    }
}
