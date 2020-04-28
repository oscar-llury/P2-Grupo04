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
            String tituloEntrada = this.parametros.substring(0, index);
            this.parametros = this.parametros.substring(index + 1, this.parametros.length());
            int id;
            if (subForoActual.contarEntradas() == 0) {
                id = 1;
            } else {
                id = subForoActual.contarEntradas();
            }
            Entrada entrada = new Entrada(id, tituloEntrada, usuarioActual);

            int pipe = this.parametros.indexOf("|");
            while (pipe != -1) {

                String obj1 = this.parametros.substring(0,pipe);
                this.parametros = this.parametros.substring(pipe+1,this.parametros.length());
                pipe = this.parametros.indexOf("|");
                
                contruirPorTipo(entrada,obj1);
                
            }  
            
            contruirPorTipo(entrada,this.parametros);
                
                
            this.subForoActual.insertarEntrada(entrada);
            foro.setEntradaActual(entrada);
            foro.getAdministrador().addPendientes(entrada);
            return true;
        } else {
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

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
        switch (tipoEntrada) {    //Podremos crear las distintas entradas disponibles
            case "texto plano": {
                entrada.addTextoPlano(s);
                break;
            }
            case "encuesta": {
                if (this.usuarioActual.isProfesor())
                    entrada.addEncuesta(s);
                else 
                    System.out.println("No permitido");
                break;
            }
            case "ejercicio": {
                if (this.usuarioActual.isProfesor())
                    entrada.addEjercicio(s);
                else
                    System.out.println("No permitido");
                break;
            }
            default: {
                System.out.println("No se ha podido generar la entrada.");
            }
        }  
    }


}