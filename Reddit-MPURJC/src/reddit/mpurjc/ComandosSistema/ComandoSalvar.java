package reddit.mpurjc.ComandosSistema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import reddit.mpurjc.Foro;

public class ComandoSalvar extends ComandosSistema implements Serializable {

    private Foro foro;
    private String ruta;
    private String nombre;
    private String parametros;

    public ComandoSalvar(Foro foro) {
        this.foro = foro;
    }

    @Override
    public boolean ejecutar(String s) {
        if (comprobar(s)) {
            if (extraerRuta(parametros)) {
                foro.setEntradaActual(null);
                foro.setSubForoActual(null);
                foro.setUsuarioActual(null);

                new File(ruta).mkdirs();        //Se crea el directorio si no existe
                String fileName = ruta + "\\" + nombre + ".txt";     //Se combinan la ruta y el nombre
                try {
                    FileOutputStream streamToFile = new FileOutputStream(fileName);
                    ObjectOutputStream objectToStream = new ObjectOutputStream(streamToFile);
                    objectToStream.writeObject(foro);       //Se escribe el libro en el fichero
                    objectToStream.close();
                    streamToFile.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Proyecto guardado correctamente.");
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //Salvar(ruta, nombre)
    @Override
    public boolean comprobar(String s) {
        setForo(foro);
        int ini = s.indexOf('(');
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0, ini).toLowerCase();

        if (comando.equals("salvar")) {
            this.parametros = s.substring(ini + 1, fin);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }

    private boolean extraerRuta(String s) {
        int finRuta = s.lastIndexOf(',');
        if (finRuta == -1) {
            return false;
        }
        ruta = s.substring(0, finRuta);
        nombre = s.substring(finRuta + 1, s.length()).replaceAll(" ", "");
        return true;
    }

}
