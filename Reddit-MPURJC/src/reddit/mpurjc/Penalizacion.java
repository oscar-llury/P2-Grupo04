
package reddit.mpurjc;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class Penalizacion {

    private Date fechaFin;

    public Penalizacion() throws ParseException {

        this.fechaFin = fechaPenalizacion(); //Lo asociamos
    }

    public boolean penalizado(){
        Date fechaActual = new Date();
        int dias = (int) ((fechaFin.getTime()-fechaActual.getTime())/86400000);
        boolean penalizado=true;
        if(dias==0){
            penalizado=false;
        }
        return penalizado;
    }

    private Date fechaPenalizacion(){
        Date fechaFin = new Date(); //Cogemos la fecha actual
        Calendar cal = Calendar.getInstance(); //Creamos calendario para sumar dias
        cal.setTime(fechaFin);
        cal.add(Calendar.DATE,2); //Sumamos dos dias
        return cal.getTime(); //Return de la nueva fecha
    }
}
