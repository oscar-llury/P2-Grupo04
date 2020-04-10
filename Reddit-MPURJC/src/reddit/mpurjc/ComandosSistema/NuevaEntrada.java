package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class NuevaEntrada extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private SubForo subForoActual;

    public NuevaEntrada(Foro foro, SubForo subForo, Usuario usuario) {
        this.foro = foro;
        this.usuarioActual = usuario;
        this.subForoActual = subForo;
    }
 
    @Override
    public boolean ejecutar(String s) {
        Entrada entrada = new Entrada(s,usuarioActual);

        /*
        bucle hasta que no haya mas comas
        switch(tipo){
            case 1: {
                entrada.addTextoPlano(textoPlano);
            }
            case 2: {
                entrada.addEncuesta();
            }
            case 3: {
                entrada.addEjercicio();
            }
            default: {
                System.out.println("Por defecto la entrada es de Texto Plano");

            }
        }*/
 
        this.subForoActual.insertarEntrada(entrada);
        foro.setEntradaActual(entrada);
        return true;
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
    
}
