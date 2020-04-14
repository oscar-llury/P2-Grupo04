package reddit.mpurjc;

import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import java.util.List;
import static reddit.mpurjc.Usuario.Rol.*;

public class Usuario {
    
    private String nick;
    private String nombre;
    private String apellidos;
    private String contraseña;
    private String email;
    private Rol rol;
    private List<SubForo> subscripciones;
    private Penalizacion penalizacion;
    private boolean esAdministrador;

    enum Rol
    {
        ALUMNO, PROFESOR, ADMINISTRADOR;
    }
    public Usuario(){}
    
    public Usuario (String nombre, String apellidos, String email, String contraseña){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email.toLowerCase();
        this.nick = sacarNick(email);
        this.contraseña = contraseña;
        this.rol = sacarRol(email);
        this.subscripciones = new ArrayList<>();
        this.esAdministrador = FALSE;
    }

    public boolean inicioPermitido(){
        return false;
    }
    
    public boolean comprobarCredenciales(Usuario usuario){
        return false;
    }
       

    
    private Rol sacarRol(String email){
        int index = email.indexOf("@");
        switch (email.substring(index,email.length()).toLowerCase()){
            case "alumnos.urjc.es": {
                return ALUMNO;
            }                    
            default: {
                return PROFESOR;
            }               
        }
    }
    private String sacarNick(String email){
        int index = email.indexOf("@");
        return email.substring(0,index-1).toLowerCase();
    }
    
     public boolean contieneSubscripcion(SubForo subforo){
    
        return subscripciones.contains(subforo);
        
    }
     
    public void eliminarSubcripcion(SubForo subforo){
        
        subscripciones.remove(subforo);
    }
    /*------------------------GETTERS------------------------*/
    public String getNick() {
        return nick;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getContraseña() {
        return contraseña;
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setSubscripciones(List<SubForo> subscripciones) {
        this.subscripciones = subscripciones;
    }
    
    public void addSubscripcion(SubForo subforo){
        this.subscripciones.add(subforo);
    }
    
    public void removeSubscripcion(SubForo subforo){
        this.subscripciones.remove(subforo);
    }

    public void setPenalizacion(Penalizacion penalizacion) {
        this.penalizacion = penalizacion;
    }

    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
    

    
}
