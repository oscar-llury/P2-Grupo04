package reddit.mpurjc;

import java.io.Serializable;
import static java.lang.Boolean.FALSE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static reddit.mpurjc.Usuario.Rol.*;

public class Usuario implements Serializable {

    private String nick;
    private String nombre;
    private String apellidos;
    private String contraseña;
    private String email;
    private Rol rol;
    private List<SubForo> subscripciones;
    private Penalizacion penalizacion;
    private boolean esAdministrador;
    private HashMap<String, Integer> entradasVistas;

    enum Rol {
        ALUMNO, PROFESOR, ADMINISTRADOR;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String email, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email.toLowerCase();
        this.nick = sacarNick(email);
        this.contraseña = contraseña;
        this.rol = sacarRol(email);
        this.subscripciones = new ArrayList<>();
        this.esAdministrador = FALSE;
        this.entradasVistas = new HashMap<>();
    }

    public Usuario(String nombre, String apellidos, String email, String contraseña, boolean esAdministrador) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email.toLowerCase();
        this.nick = sacarNick(email);
        this.contraseña = contraseña;
        this.rol = ADMINISTRADOR;
        this.subscripciones = new ArrayList<>();
        this.esAdministrador = esAdministrador;
        this.entradasVistas = new HashMap<>();
    }

    /**
     * Este método se utilizará para identificar el rol del usuario
     *
     * @param email
     * @return enumerado con el correspondiente rol de usuario
     */
    private Rol sacarRol(String email) {
        // Se tendrá que verificar que el email introducido tenga la arroba en el email
        int index = email.indexOf("@");
        String opcion  = email.substring(index+1, email.length()).toLowerCase();
        switch (opcion) {
            case "alumnos.urjc.es": {
                return ALUMNO;
            }
            case "admin.urjc.es": {
                return ADMINISTRADOR;
            }
            default: {
                return PROFESOR;
            }
        }
    }

    private String sacarNick(String email) {
        int index = email.indexOf("@");
        // Utilizaremos el nick como resultado de la 1ª posición del correo hasta la posición anterior a la arroba
        return email.substring(0, index).toLowerCase();
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

    public HashMap<String, Integer> getEntradasVistas() {
        return entradasVistas;
    }

    public Penalizacion getPenalizacion() {
        return penalizacion;
    }

    public boolean isPenalizado() {

        if ((this.penalizacion != null) && (this.penalizacion.isPenalizado())) {
            return true;
        }
        return false;
    }

    public boolean isEsAdministrador() {
        return esAdministrador;
    }

    public boolean contieneSubscripcion(String s) {
        boolean contenido = this.esAdministrador;
        this.subscripciones.forEach((iter) -> {
            if (iter.getNombre().equals(s)) {
                this.esAdministrador = true;
            }
        });
        boolean devolver = esAdministrador;
        this.esAdministrador = contenido;
        return devolver;
    }

    public boolean inicioPermitido() {
        return false;
    }

    public boolean comprobarCredenciales(Usuario usuario) {
        return false;
    }

    public boolean isProfesor() {
        return this.rol == PROFESOR;
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

    public void addSubscripcion(SubForo subforo) {
        this.subscripciones.add(subforo);
    }

    public void addEntradasVistas(SubForo subforo) {
        String nombreSubforo = subforo.getNombre();
        int tamaño = subforo.getEntradas().size();
        this.entradasVistas.put(nombreSubforo, tamaño);
    }

    public void removeSubscripcion(SubForo subforo) {
        this.subscripciones.remove(subforo);
    }

    public void addPenalizacion() {
        this.penalizacion = new Penalizacion();
    }

    public void setPenalizacion(Penalizacion penalizacion) {
        this.penalizacion = penalizacion;
    }

    public void setEsAdmin(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
        Administrador admin = new Administrador(this.nombre, this.apellidos, this.email, this.contraseña, true);
    }

    public void eliminarSubcripcion(SubForo subforo) {
        subscripciones.remove(subforo);
        eliminarEntradasVistas(subforo);
    }

    public void eliminarEntradasVistas(SubForo subforo) {
        String nombreSubforo = subforo.getNombre();
        this.entradasVistas.remove(nombreSubforo);
    }

    public void setEntradasVistas(SubForo subforo) {
        this.entradasVistas.put(subforo.getNombre(), subforo.getEntradas().size());
    }
}
