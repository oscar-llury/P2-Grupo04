package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class NuevaEntrada extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private SubForo subForoActual;
    private String parametros;

    public NuevaEntrada(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.subForoActual = foro.getSubForoActual();
    }

    /**
     * Este método se utilizará para crear una entrada
     *
     * @param s
     * @return true si la entrada ha sido creada satisfactoriamente
     */
    @Override
    public boolean ejecutar(String s) {
        if (comprobar(s)) {
            int index = this.parametros.indexOf(",");
            String subForo = this.parametros.substring(0, index);
            this.subForoActual = this.foro.getSubForo(subForo);
            this.parametros = this.parametros.substring(index + 1);
            index = this.parametros.indexOf(",");
            String tituloEntrada = this.parametros.substring(0, index);
            this.parametros = this.parametros.substring(index + 1);
            int id;
            if (subForoActual.contarEntradas() == 0) {
                id = 1;
            } else {
                id = subForoActual.contarEntradas() + 1;
            }
            Entrada entrada = new Entrada(id, tituloEntrada, usuarioActual);

            int pipe = this.parametros.indexOf("|");
            while (pipe != -1) {

                String obj1 = this.parametros.substring(0, pipe);
                this.parametros = this.parametros.substring(pipe + 1);
                pipe = this.parametros.indexOf("|");

                contruirPorTipo(entrada, obj1);

            }

            contruirPorTipo(entrada, this.parametros);

            this.subForoActual.insertarEntrada(entrada);
            foro.setEntradaActual(entrada);
            foro.getAdministrador().addPendientes(entrada);
            System.out.println("Entrada creada correctamente.");
            return true;
        } else {
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

    //Comando para la clase NuevaEntrada en el Foro
    @Override
    public boolean comprobar(String s) {
        setForo(this.foro);
        if (this.usuarioActual == null) {
            return false;
        } else {
            int ini = s.indexOf("(");
            int fin = s.lastIndexOf(")");
            String comando = s.substring(0, ini).toLowerCase();
            if (comando.equals("nuevaentrada")) {
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
        this.usuarioActual = foro.getUsuarioActual();
        this.subForoActual = foro.getSubForoActual();
    }

    private void contruirPorTipo(Entrada entrada, String s) {
        int index = s.indexOf(",");
        String tipoEntrada = s.substring(0, index).toLowerCase();
        s = s.substring(index + 1, s.length());
        switch (tipoEntrada) { //Podremos crear las distintas entradas disponibles
            case "texto plano": { //El texto plano podrá ser creado por cualquier usuario
                entrada.addTextoPlano(s);
                break;
            }
            case "encuesta": { //La encuesta será creada solamente por un profesor
                if (this.usuarioActual.isProfesor()) {
                    entrada.addEncuesta(s);
                } else {
                    System.out.println("Es necesario ser porfesor.");
                }
                break;
            }
            case "ejercicio": { //El ejercicio será creado solamente por un profesor
                if (this.usuarioActual.isProfesor()) {
                    entrada.addEjercicio(s);
                } else {
                    System.out.println("Es necesario ser porfesor.");
                }
                break;
            }
            default: {
                System.out.println("No se ha podido generar la entrada.");
            }
        }
    }

}
