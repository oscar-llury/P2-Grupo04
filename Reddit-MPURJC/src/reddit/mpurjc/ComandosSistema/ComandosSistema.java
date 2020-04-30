package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;

public abstract class ComandosSistema {

    public abstract boolean ejecutar(String s);

    public abstract boolean comprobar(String s);

    public abstract void setForo(Foro foro);
}
