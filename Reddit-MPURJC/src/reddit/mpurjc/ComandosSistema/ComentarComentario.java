package reddit.mpurjc.ComandosSistema;

import reddit.mpurjc.Comentario;
import reddit.mpurjc.Entradas.Entrada;
import reddit.mpurjc.Foro;
import reddit.mpurjc.SubForo;
import reddit.mpurjc.Usuario;

public class ComentarComentario extends ComandosSistema {

    private Foro foro;
    private Usuario usuarioActual;
    private Comentario comentarioActual;
    private Entrada entradaActual;
    private String parametros;

    public ComentarComentario(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
        //this.comentarioActual = foro.getComentarioActual();
    }
    
    /**
     * Este método se utilzará para comentar los comentarios ya expuestos 
     * @param s
     * @return boolean true en el caso de que se haya podido comentar con éxito y que dicho 
     * comentario sea válido, en caso contrario, no podrá ser aceptado 
     */
    @Override
    public boolean ejecutar(String s) {
        if(comprobar(s)){
            // Se podrá comentar dicho comentario siempre y cuando la entrada esté verificada 
            // y el comentario al que se hace referencia está validado
            buscarComentarioActual(this.parametros);
            if(this.entradaActual.isVerificado() && this.comentarioActual.isValidado()){
                Comentario nuevoComentario = new Comentario(usuarioActual,this.parametros);
                nuevoComentario.validar();
                if(nuevoComentario.isValidado()){
                    this.comentarioActual.addComentario(nuevoComentario);
                    return true;
                }else{
                    System.out.println("El comentario no es aceptado");
                    //add penalizacion
                    return false;
                }
            }else{
                System.out.println("No se ha podido comentar la entrada.");
                return false;
            }
        }else{
            System.out.println("Es necesario tener iniciada sesión.");
            return false;
        }
    }

    //Comando para la clase ComentarComentario en el Foro
    @Override
    public boolean comprobar(String s) {
        setForo(this.foro);
        if(this.usuarioActual == null){
            return false;
        } else {
            int ini = s.indexOf("(");
            int fin = s.lastIndexOf(")");
            String comando = s.substring(0,ini).toLowerCase();
            if(comando.equals("comentarcomentario")){
                this.parametros = s.substring(ini+1,fin);
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public void setForo(Foro foro) {
        this.foro = foro;
        this.usuarioActual = foro.getUsuarioActual();
        this.entradaActual = foro.getEntradaActual();
        //this.comentarioActual = foro.getComentarioActual();
    }
    //SubForo 1.1.1-
    private void buscarComentarioActual(String s){
        
        int fin = s.indexOf(".");
        String subforo = s.substring(0,fin);
        s = s.substring(fin+1);
        SubForo subForoActual = this.foro.getSubForo(subforo);
        fin = s.indexOf(".");
        int orden = Integer.parseInt(s.substring(0,fin));
        s = s.substring(fin+1);
        this.entradaActual = subForoActual.getEntradaPorOrden(orden);
        fin = s.indexOf("-");
        int profundidad = contarPuntosDeProfundidad(s.substring(0,fin));
        int punto1 = this.parametros.indexOf("."); 
        this.parametros = s.substring(fin+1);
        
        if (punto1 != -1){//2
            //int orden = Integer.parseInt(s.substring(ini+1,punto1));
            Comentario coment = this.entradaActual.getComentarioPorOrden(profundidad);
            for(int i = 1; i<profundidad; i++){
                coment = coment.getComentarioPorOrden(i);
            }
            this.comentarioActual = coment;
        }else
            this.comentarioActual = this.entradaActual.getComentarioPorOrden(profundidad);

    }
    
    private int contarPuntosDeProfundidad(String str){
        int punto1 = str.indexOf(".");
        if (punto1 != -1){
            String[] words = str.split("\\.");
            return words.length;
        }else
            return 1;
    }
}
