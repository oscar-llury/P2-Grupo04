package reddit.mpurjc.ComandosSistema;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import reddit.mpurjc.Foro;

public class ComandoCargar extends ComandosSistema implements Serializable {

    private Foro foro, foroAux;
    private String ruta;

    private NuevoSubForo comandoNuevoSubForo;
    private NuevoUsuario comandoNuevoUsuario;
    private NuevaEntrada comandoNuevaEntrada;
    private ComentarEntrada comandoNuevoComentarioEntrada;
    private ComentarComentario comandoComentarComentario;
    private VotarComentario comandoVotarComentario;
    private VotarEntrada comandoVotarEntrada;
    private ValidarEntrada comandoValidarEntrada;
    private NuevaSubscripcion comandoNuevaSubscripcion;
    private EliminarSubscripcion comandoEliminarSubscripcion;
    private Logout comandoLogout;
    private Login comandoLogin;
    private ComandoSalvar comandoSalvar;
    private ComandoMostrarForo comandoMostrarForo;

    public ComandoCargar(Foro foro, NuevoSubForo comandoNuevoSubForo, NuevoUsuario comandoNuevoUsuario,
            NuevaEntrada comandoNuevaEntrada, ComentarEntrada comandoNuevoComentarioEntrada,
            ComentarComentario comandoComentarComentario, VotarComentario comandoVotarComentario,
            VotarEntrada comandoVotarEntrada, ValidarEntrada comandoValidarEntrada,
            NuevaSubscripcion comandoNuevaSubscripcion, EliminarSubscripcion comandoEliminarSubscripcion,
            Logout comandoLogout, Login comandoLogin, ComandoSalvar comandoSalvar, ComandoMostrarForo comandoMostrarForo) {

        this.foro = foro;
        this.comandoNuevoSubForo = comandoNuevoSubForo;
        this.comandoNuevoUsuario = comandoNuevoUsuario;
        this.comandoNuevaEntrada = comandoNuevaEntrada;
        this.comandoNuevoComentarioEntrada = comandoNuevoComentarioEntrada;
        this.comandoComentarComentario = comandoComentarComentario;
        this.comandoVotarComentario = comandoVotarComentario;
        this.comandoVotarEntrada = comandoVotarEntrada;
        this.comandoValidarEntrada = comandoValidarEntrada;
        this.comandoNuevaSubscripcion = comandoNuevaSubscripcion;
        this.comandoEliminarSubscripcion = comandoEliminarSubscripcion;
        this.comandoLogout = comandoLogout;
        this.comandoLogin = comandoLogin;
        this.comandoSalvar = comandoSalvar;
        this.comandoMostrarForo = comandoMostrarForo;
    }

    @Override
    public boolean ejecutar(String s) {
        if (comprobar(s)) {
            try {
                FileInputStream fileToStream = new FileInputStream(ruta);
                ObjectInputStream streamToObject = new ObjectInputStream(fileToStream);
                foroAux = (Foro) streamToObject.readObject();
                System.out.println("Proyecto cargado correctamente.");
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println("Ruta no encontrada.");
                Logger.getLogger(ComandoCargar.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            setForo(foroAux);
            this.comandoNuevoSubForo.setForo(foro);
            this.comandoNuevoUsuario.setForo(foro);
            this.comandoNuevaEntrada.setForo(foro);
            this.comandoNuevoComentarioEntrada.setForo(foro);
            this.comandoComentarComentario.setForo(foro);
            this.comandoVotarComentario.setForo(foro);
            this.comandoVotarEntrada.setForo(foro);
            this.comandoValidarEntrada.setForo(foro);
            this.comandoNuevaSubscripcion.setForo(foro);
            this.comandoEliminarSubscripcion.setForo(foro);
            this.comandoLogout.setForo(foro);
            this.comandoLogin.setForo(foro);
            this.comandoSalvar.setForo(foro);
            this.comandoMostrarForo.setForo(foro);

            return true;
        } else {
            return false;
        }
    }

    //Cargar(ruta)
    @Override
    public boolean comprobar(String s) {
        setForo(foro);
        int ini = s.indexOf('(');
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0, ini).toLowerCase();

        if (comando.equals("cargar")) {
            this.ruta = s.substring(ini + 1, fin);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }

}
