package reddit.mpurjc.ComandosSistema;

import java.util.Collection;
import java.util.Iterator;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;


public class ComandoMostrarForo extends ComandosSistema {

    private Foro foro;

    public ComandoMostrarForo(Foro foro) {
        this.foro = foro;

    }

    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);

        SubForo sub;
        Collection<SubForo> listaSub = this.foro.getListaSubForos();
        Iterator<SubForo> iterSub = listaSub.iterator();
        if (iterSub.hasNext()) {
            while (iterSub.hasNext()) { //itera por todos los subforo
                sub = iterSub.next();
                System.out.println("\t" + sub.getNombre());

                Entrada entrada;
                Collection<Entrada> listaEntradas = sub.getEntradas();
                Iterator<Entrada> iterEntr = listaEntradas.iterator();

                while (iterEntr.hasNext()) { //itera por todas las entradas

                    entrada = iterEntr.next();
                    entrada.mostrar();

                }
            }
        } else {
            System.out.println("El foro está vacío");
            return false;
        }
        return true;
    }

    @Override
    public boolean comprobar(String s) {
        return true;
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }

}
