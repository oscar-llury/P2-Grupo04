
package reddit.mpurjc;

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
    
}
