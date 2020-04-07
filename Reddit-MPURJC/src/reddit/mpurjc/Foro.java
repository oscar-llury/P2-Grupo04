package reddit.mpurjc;

import java.util.HashMap;

public class Foro {
    
    private HashMap <String, SubForo> listaSubforos;
    private HashMap <String, Usuario> listaUsuarios;
    
    
    public Foro(){}
   
    public boolean contieneUsuario(String nick){
        return !listaUsuarios.containsKey(nick);
    }

    public boolean contieneSubForo (String nombre){
        return listaSubforos.containsKey(nombre);
    }
   
    public void insertarSubForo(SubForo subForo){
        this.listaSubforos.put(subForo.getNombre() , subForo);
    }
    
    public void insertarUsuario(Usuario usuario){
        this.listaUsuarios.put(usuario.getNick(),usuario);
    }
}
