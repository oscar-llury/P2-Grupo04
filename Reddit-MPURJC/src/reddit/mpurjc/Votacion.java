
package reddit.mpurjc;

import java.io.Serializable;

public class Votacion implements Serializable{
    
    private boolean votacion;

    public Votacion(boolean votacion) {
        this.votacion = votacion;
    }
    
    public void votar(boolean voto){
        this.votacion = voto;
    }
    
    public boolean getVotacion(){
        return this.votacion;
    }
    
    public boolean equals(boolean comparar){
        return this.votacion == comparar;
    }
}
