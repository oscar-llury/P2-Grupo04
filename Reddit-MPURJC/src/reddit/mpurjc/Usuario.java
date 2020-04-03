
package reddit.mpurjc;

import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import java.util.List;

enum Rol
{
    ALUMNO, PROFESOR, ADMINISTRADOR;
}

public class Usuario {
    
    private String nick;
    private String nombre;
    private String contraseña;
    private String email;
    private Rol rol;
    private List<SubForo> subscripciones;
    private Penalizacion penalizacion;
    private boolean esAdministrador;

   
    
    public boolean inicioPermitido(){
        return false;
    }
    
    public boolean comprobarCredenciales(Usuario usuario){
        return false;
    }
    
    public Usuario (String nick, String nombre, String contraseña, String email, Rol rol){
        this.nick = nick;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.rol = rol;
        this.subscripciones = new ArrayList<SubForo>();
        this.esAdministrador = FALSE;
    }
    
    
    
    /*------------------------GETTERS------------------------*/
    public String getNick() {
        return nick;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Rol getRol() {
        return rol;
    }

    public List<SubForo> getSubscripciones() {
        return subscripciones;
    }

    public Penalizacion getPenalizacion() {
        return penalizacion;
    }

    public boolean isEsAdministrador() {
        return esAdministrador;
    }
    
    /*------------------------SETTERS------------------------*/
    
    
    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setSubscripciones(List<SubForo> subscripciones) {
        this.subscripciones = subscripciones;
    }

    public void setPenalizacion(Penalizacion penalizacion) {
        this.penalizacion = penalizacion;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
    
    
}
