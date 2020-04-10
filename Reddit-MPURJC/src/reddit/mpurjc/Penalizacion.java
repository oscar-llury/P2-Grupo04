
package reddit.mpurjc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Penalizacion {
    
    private Date fechaInicio;
    private Date fechaFin;

    public Penalizacion(String fechaInicio, String fechaFin) throws ParseException {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date ini = dateFormat.parse(fechaInicio);
        Date fin = dateFormat.parse(fechaFin);
        
        this.fechaInicio = ini;
        this.fechaFin = fin;
    }

    public boolean penalizado(){
        int dias = (int) ((fechaFin.getTime()-fechaInicio.getTime())/86400000);
        boolean penalizado=true;
        if(dias==0){
            penalizado=true;
        }
        return penalizado;
    }
   
}
