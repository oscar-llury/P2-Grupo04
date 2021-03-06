package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class Login extends ComandosSistema {

    private Foro foro;
    private String parametros;

    public Login(Foro foro) {
        this.foro = foro;
    }

    /**
     * Este método se utilizará para logear a los usuarios
     *
     * @param s
     * @return true si el usuario se ha logeado con éxito
     */
    @Override
    public boolean ejecutar(String s) {
        boolean valido = false;
        if (comprobar(s)) {
            String nick_contra[] = this.parametros.split(" ");
            String nick = nick_contra[0].toLowerCase();
            String contraseña = nick_contra[1];
            Usuario valor;

            for (String key : foro.getListaUsuarios().keySet()) {
                valor = foro.getListaUsuarios().get(key);
                if ((nick.equals(key)) && (valor.getContraseña().equals(contraseña))) {
                    // El usuario tendrá deshabilitado la opción de login mientras esté penalizado
                    if (valor.isPenalizado()) {
                        System.out.println("!!!!!! No puedes logearte, estas penalizado !!!!!!");
                        valido = true;
                    } else {
                        if (valor.getPenalizacion() != null) {
                            valor.setPenalizacion(null);
                        }
                        foro.setUsuarioActual(valor);
                        System.out.println("Usuario logeado con éxito");
                        System.out.println("Sesión iniciada como: " + foro.getUsuarioActual().getNick());
                        valido = true;
                        mostrarNotificaciones();
                    }
                }
            }
        }
        if (!valido) {
            System.out.println("Credenciales mal introducidas.");
            return false;
        } else {
            return true;
        }
    }

    //Comando para la clase Login en el Foro
    @Override
    public boolean comprobar(String s) {
        setForo(this.foro);
        int ini = s.indexOf("(");
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0, ini).toLowerCase();
        if (comando.equals("login")) {
            this.parametros = s.substring(ini + 1, fin);
            return true;
        } else {
            return false;
        }
    }

    private void mostrarNotificaciones() {
        if (foro.getUsuarioActual().getEntradasVistas() != null) {
            foro.getUsuarioActual().getEntradasVistas().entrySet().forEach((entry) -> {
                int entradasActuales = foro.getSubForo(entry.getKey()).getEntradas().size();
                if (entradasActuales - entry.getValue() != 0) {
                    System.out.println(">>> Nueva notificación: "+entry.getKey() + " (" + (entradasActuales - entry.getValue()) + "*)");
                }
            });
        }
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
}
