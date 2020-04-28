package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Administrador;
import reddit.mpurjc.Foro;

public class ValidarEntrada extends ComandosSistema {

    private Foro foro;
    private Administrador admin;
    private String parametros;

    public ValidarEntrada(Foro foro) {
        this.foro = foro;
        this.admin = foro.getAdministrador();
    }
    
    /**
     * Este método se utilizará para que el administrador pueda validar las entradas 
     * introducidas
     * @param s
     * @return true si se han validado con éxito
     */
    @Override
    public boolean ejecutar(String s) {
        if(comprobar(s)){
            if(admin.hayPendientes()){
                admin.validarTodasEntradas();
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean comprobar(String s) {
       
        setForo(foro);
        int ini = s.indexOf('(');
        int fin = s.lastIndexOf(")");
        String comando = s.substring(0,ini).toLowerCase();

        if(comando.equals("validarentrada")){
            this.parametros = s.substring(ini+1,fin);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.admin = foro.getAdministrador();
    }
    
}
