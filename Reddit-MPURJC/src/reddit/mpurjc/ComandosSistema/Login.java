package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Foro;
import reddit.mpurjc.Usuario;

public class Login extends ComandosSistema {

    private Foro foro;

    public Login(Foro foro) {
        this.foro = foro;
    }

    /**
     * Utilizaremos este método para logear a los usuarios 
     * @param s
     * @return true si el usuario se ha logeado con éxito
     */
    @Override
    public boolean ejecutar(String s) {
        setForo(this.foro);
        String nick_contra [] = s.split(" ");
        String nick = nick_contra[0].toLowerCase();
        String contraseña = nick_contra[1];
        Usuario valor;
        for (String key : foro.getListaUsuarios().keySet()){
            valor = foro.getListaUsuarios().get(key);
            if((nick.equals(key))&&(valor.getContraseña().equals(contraseña))){
                // El usuario tendrá deshabilitado la opción de login mientras esté penalizado
                if(valor.getPenalizacion().isPenalizado()){
                    System.out.println("No puedes logearte, estas penalizado");
                }else {
                    if(valor.getPenalizacion()!= null){
                        valor.setPenalizacion(null);
                    }
                    foro.setUsuarioActual(valor);
                    System.out.println("Usuario logeado con exito");
                }
            }
        }
        return true;
    }

    @Override
    public boolean comprobar(String s) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
    }
}
