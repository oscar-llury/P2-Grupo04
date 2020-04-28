package reddit.mpurjc.ComandosSistema;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import reddit.mpurjc.Foro;

public class ComandoSalvar extends ComandosSistema{

    private Foro foro;
    private String ruta;
    private String nombre;
    
    public ComandoSalvar(Foro foro) {
        this.foro = foro;
    }
    
    @Override
    public boolean ejecutar(String s) {
        if(extraerRuta(s)){
            new File(ruta).mkdirs();//Se crea el directorio si no existe
            String fileName =ruta+"\\"+nombre+".txt";//Se combinan la ruta y el nombre
            try{
                FileOutputStream streamToFile= new FileOutputStream(fileName);
                ObjectOutputStream objectToStream = new ObjectOutputStream(streamToFile);
                objectToStream.writeObject(foro);//Se escribe el libro en el fichero
                objectToStream.close();
                streamToFile.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
            System.out.println("Proyecto guardado correctamente.");
            return true; 
        }
        else
            return false;
    
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
    
    private boolean extraerRuta(String s){
        int iniRuta=s.indexOf('(')+1;
        int finRuta=s.lastIndexOf(',');
        if((iniRuta==-1)||finRuta==-1)
            return false;
        ruta=s.substring(iniRuta,finRuta);
        nombre=s.substring(finRuta+1,s.length()-1);
        return true;
    }
    
    
}