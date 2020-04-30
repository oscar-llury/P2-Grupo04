package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class EliminarSubscripcion extends ComandosSistema {

    private Foro foro;
    private SubForo subforoActual;
    private Usuario usuarioActual;
    private String parametros;

    public EliminarSubscripcion(Foro foro) {
        this.foro = foro;
        this.subforoActual = foro.getSubForoActual();
        this.usuarioActual = foro.getUsuarioActual();
    }

    /**
     * Este método se utilizará para eliminar una subscripción al SubForo
     *
     * @param s
     * @return true si la subscripción se ha eliminado con éxito o false en
     * casos excepcionales
     */
    @Override
    public boolean ejecutar(String s) {
        if (comprobar(s)) {
            this.subforoActual = this.foro.getSubForo(this.parametros);
            if (this.subforoActual != null) {
                if (usuarioActual.contieneSubscripcion(this.parametros)) {
                    usuarioActual.eliminarEntradasVistas(subforoActual);
                    usuarioActual.eliminarSubcripcion(subforoActual);
                    System.out.println("Subscripción eliminada correctamente.");
                    return true;
                } else {
                    System.out.println("No estás subscrito a este SubForo.");
                    return false;
                }
            } else {
                System.out.println("Este SubForo no existe.");
                return false;
            }
        } else {
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

    //Comando para la clase EliminarSubscripcion en el Foro
    @Override
    public boolean comprobar(String s) {
        setForo(this.foro);
        if (this.usuarioActual == null) {
            return false;
        } else {
            int ini = s.indexOf("(");
            int fin = s.lastIndexOf(")");
            String comando = s.substring(0, ini).toLowerCase();
            if (comando.equals("eliminarsubscripcion")) {
                this.parametros = s.substring(ini + 1, fin);
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.subforoActual = foro.getSubForoActual();
        this.usuarioActual = foro.getUsuarioActual();
    }

}
