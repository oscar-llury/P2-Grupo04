package reddit.mpurjc.ComandosSistema;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import reddit.mpurjc.Foro;

public class ComandoCargar extends ComandosSistema implements Serializable {

    private Foro foro, foroAux;
    private String ruta;
   
    public ComandoCargar(Foro foro) {
        this.foro = foro;
    }
    
    
    
    @Override
    public boolean ejecutar(String s) {
        if(comprobar(s)){
            try{
                FileInputStream fileToStream= new FileInputStream(ruta);
                ObjectInputStream streamToObject=new ObjectInputStream(fileToStream);
                foroAux = (Foro) streamToObject.readObject();
                System.out.println("Proyecto cargado correctamente.");
            }catch(IOException | ClassNotFoundException ex){
                System.out.println("Ruta no encontrada.");
                Logger.getLogger(ComandoCargar.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            setForo(foroAux);
            
            return true;
        }else
            return false;
    }

    //Cargar(ruta)
    @Override
    public boolean comprobar(String s) {
        setForo(foro);
        int ini = s.indexOf('(');
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0,ini).toLowerCase();
        
        if(comando.equals("cargar")){
            this.ruta = s.substring(ini+1,fin);
            return true;
        }else
            return false;
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
    
}
