package reddit.mpurjc;

import java.util.Calendar;
import java.util.Date;

public class Penalizacion {

    private Date fechaFin;

    public Penalizacion() {
        // Se asocia la fecha final de la penalización
        this.fechaFin = fechaPenalizacion(); 
    }

    /**
     * Este método sirve para saber si el usuario está penalizado o no
     * @return boolean si está penalizado devolverá true y en caso contario, mientras no se
     * hayan acabado los dias de penalización, nos devolverá que el usuario sigue estando 
     * penalizado
     */
    public boolean isPenalizado(){
        Date fechaActual = new Date();
        int dias = (int) ((fechaFin.getTime()-fechaActual.getTime())/86400000);
        boolean penalizado = true;
        if(dias<=0){
            penalizado = false;
        }
        return penalizado;
    }

    public void actualizarPenalizacion(){
        Calendar cal = Calendar.getInstance(); // Creamos calendario para sumar dias
        cal.setTime(fechaFin);
        cal.add(Calendar.DATE,2); // Sumamos dos dias
        fechaFin = cal.getTime();
    }
    
    /**
     * Este método es para establecer la fecha final donde se acaba la penalización, 
     * es decir, dos dias después de que se haya cometido. 
     * @return Nueva fecha actualizada
     */
    private Date fechaPenalizacion(){
        Date fechaFin = new Date(); // Cogemos la fecha actual
        Calendar cal = Calendar.getInstance(); // Creamos calendario para sumar dias
        cal.setTime(fechaFin);
        cal.add(Calendar.DATE,2); // Sumamos dos dias
        return cal.getTime();
    }
}
