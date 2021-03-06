package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class VotarEntrada extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private Entrada entradaActual;
    private String parametros;

    public VotarEntrada(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
    }

    /**
     * Este método se utilizará para votar las entradas correspondientes y se
     * podrá valorar de manera positiva con un like o por el contrario con un
     * dislike
     *
     * @param s
     * @return boolean tipo de voto like o dislike
     */
    @Override
    public boolean ejecutar(String s) {
        if (comprobar(s)) {
            buscarEntradaActual(this.parametros);
            if (this.entradaActual != null) {
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
                        System.out.println("Voto mal introducido.");
                        return false;
                }
                boolean error = this.entradaActual.votarEntrada(usuarioActual, voto);
                this.entradaActual.contarVotos();
                System.out.println("Voto realizado correctamente");
                return error;
            } else {
                System.out.println("No se ha encontrado la entrada.");
                return false;
            }

        } else {
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

    //Comando para la clase VotarEntrada en el Foro
    @Override
    public boolean comprobar(String s) {
        setForo(foro);
        if (this.usuarioActual == null) {
            return false;
        } else {
            int ini = s.indexOf('(');
            int fin = s.lastIndexOf(")");
            String comando = s.substring(0, ini).toLowerCase();

            if (comando.equals("votarentrada")) {
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
        this.usuarioActual = this.foro.getUsuarioActual();
        this.entradaActual = this.foro.getEntradaActual();
    }

    private void buscarEntradaActual(String s) {
        int fin = s.indexOf(".");
        String subforo = s.substring(0, fin);
        s = s.substring(fin + 1);
        SubForo subForo = this.foro.getSubForo(subforo);
        fin = s.indexOf("-");
        int orden = Integer.parseInt(s.substring(0, fin));
        this.parametros = s.substring(fin + 1);
        this.entradaActual = subForo.getEntradaPorOrden(orden);
    }
}
