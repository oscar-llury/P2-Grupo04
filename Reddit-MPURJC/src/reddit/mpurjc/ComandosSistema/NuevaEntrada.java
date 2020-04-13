package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class NuevaEntrada extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private SubForo subForoActual;

    public NuevaEntrada(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.subForoActual = foro.getSubForoActual();
    }

    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        int index = s.indexOf(",");
        String tituloEntrada = s.substring(0,index);
        s = s.substring(index+1, s.length());
        Entrada entrada = new Entrada(tituloEntrada,usuarioActual);
        
        index = s.indexOf(",");
        String tipoEntrada = s.substring(0,index).toLowerCase();
        s = s.substring(index+1, s.length());
        switch(tipoEntrada){
            case "texto plano": {
                entrada.addTextoPlano(s);
                break;
            }
            case "encuesta": {
                //entrada.addEncuesta();
            }
            case "ejercicio": {
                //entrada.addEjercicio();
            }
            default: {
                System.out.println("No se ha podido generar la entrada.");
                return false;

            }
        }
        this.subForoActual.insertarEntrada(entrada);
        foro.setEntradaActual(entrada);
        foro.getAdministrador().addPendientes(entrada);
        return true;
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.subForoActual = foro.getSubForoActual();
    }
    
}
