package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class NuevaEntrada extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private SubForo subForoActual;

    public NuevaEntrada(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.subForoActual = foro.getSubForoActual();
    }

    
     /**
     * Este método servirá para crear una entrada  
     * @param s
     * @return true si la entrada ha sido creada satisfactoriamente
     */
    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        if(this.usuarioActual != null){
            int index = s.indexOf(",");
            String tituloEntrada = s.substring(0,index);
            s = s.substring(index+1, s.length());
            int id;
            if(subForoActual.contarEntradas() == 0){
                id = 1;
            }else{
                id = subForoActual.contarEntradas();
            }
            Entrada entrada = new Entrada(id, tituloEntrada, usuarioActual);

            index = s.indexOf(",");
            String tipoEntrada = s.substring(0,index).toLowerCase();
            s = s.substring(index+1, s.length());
            switch(tipoEntrada){    //Podremos crear las distintas entradas disponibles
                case "texto plano": {
                    entrada.addTextoPlano(s);
                    break;
                }
                case "encuesta": {
                    //entrada.addEncuesta();
                }
                case "ejercicio": {
                    //entrada.addEjercicio();
                }
                default: {
                    System.out.println("No se ha podido generar la entrada.");
                    return false;

                }
            }
            this.subForoActual.insertarEntrada(entrada);
            foro.setEntradaActual(entrada);
            foro.getAdministrador().addPendientes(entrada);
            return true;
        }else{
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    // Se devolverá el Foro con la nueva entrada ya creada
    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.subForoActual = foro.getSubForoActual();
    }
    
}
