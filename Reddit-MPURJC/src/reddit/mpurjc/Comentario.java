package reddit.mpurjc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import reddit.mpurjc.Entradas.Entrada;

public class Comentario implements Serializable {

    private String texto;
    private HashMap<Usuario, Votacion> puntuaciones;
    private List<Comentario> comentarios;
    private Usuario autor;
    private int positivo, negativo;
    private boolean validado;

    public Comentario(Usuario autor, String texto) {
        this.texto = texto;
        this.autor = autor;
        this.puntuaciones = new HashMap<>();
        this.comentarios = new ArrayList<>();
        this.negativo = 0;
        this.positivo = 0;
        this.validado = false;
    }

    /**
     * Este método se utilizará para mostrar el autor del comentario propuesto
     * junto al comentario y la puntuación que se le ha otorgado
     */
    public void mostrar() {
        System.out.println("Autor: " + this.autor.getNick());
        System.out.println(this.texto);
        System.out.println("Puntuación: " + contarVotos());
        // Se mostrarán los comentarios anidados 
        Iterator<Comentario> it = comentarios.iterator();

        while (it.hasNext()) {
            System.out.println("······Comentarios: ······");
            it.next().mostrar();
            System.out.println("·························");
        }
    }

    /**
     * Este método se utilizará para ir pidiendo los votos de los comentarios
     * que han realizado los usuarios y contarlos
     *
     * @return recuento de los votos positivos y negativos, respectivamente
     */
    public String contarVotos() {
        this.negativo = 0;
        this.positivo = 0;
        this.puntuaciones.forEach((Usuario k, Votacion v) -> {
            if (v.getVotacion()) {
                this.positivo++;
            } else {
                this.negativo++;
            }
        });
        return ("Positivos: " + this.positivo + ", Negativos: " + this.negativo);
    }

    /**
     * Este método posibilitará al usuario votar el comentario
     *
     * @param votante
     * @param voto
     * @return boolean para ver si se ha votado el comentario
     */
    public boolean votarComentario(Usuario votante, boolean voto) {
        boolean valido = validado;
        this.validado = true;
        this.puntuaciones.forEach((Usuario k, Votacion v) -> {
            if (k.getNick().equals(votante.getNick())) {
                validado = false;
            }
        });
        boolean devolver = false;
        if (validado) {
            Votacion votacion = new Votacion(voto);
            this.puntuaciones.put(votante, votacion);
            devolver = true;
        } else {
            Votacion votoAnterior = this.puntuaciones.get(votante);
            if (!votoAnterior.equals(voto)) {
                votoAnterior.votar(voto);
                devolver = true;
            }
        }
        this.validado = valido;
        contarVotos();
        if (devolver) {
            System.out.println("Comentario guardado correctamente.");
        }
        return devolver;
    }

    /**
     * Este método se utilizará para validar los comentarios comprobando que no
     * se reciben comentarios que contengan palabras inadecuadas
     */
    public void validar() {
        String str = this.texto.toLowerCase();
        String[] words = str.split(" ");
        String censurado[] = {"idiota", "joder", "cabron"};
        str="";
        String word;
        boolean sancionar = false;
        for (int i=0;i<words.length;i++) {
            word= words[i];
            for (String censura : censurado) {
                if (word.equals(censura)) {
                    /**
                     * Si algún comentario tuviera alguna palabra inadecuada se
                     * sustituirán por asteriscos y se sancionará al autor.
                     */
                    sancionar = true;
                    word = word.replaceAll("\\B\\w\\B", "*");
                    words[i]=word;
                }
            }
            str=str+words[i]+" ";
        }
        if (sancionar){
            this.autor.addPenalizacion();
            this.texto = str;
        }
        Iterator<Comentario> it = comentarios.iterator();
        // Mientras tengamos comentarios, se irán validando
        while (it.hasNext()) {
            it.next().validar();
        }
        this.validado = true;
    }

    /*------------------------GETTERS------------------------*/
    public boolean isValidado() {
        return this.validado;
    }

    public Comentario getComentarioPorOrden(int i) {
        if(i<=this.comentarios.size()){
            return this.comentarios.get(i - 1);
        }else
            return null;
    }

    public String getTexto() {
        return texto;
    }
    
    public int getPuntuacionesSize() {
        return puntuaciones.size();
    }

    /*------------------------SETTERS------------------------*/
    public void addComentario(Comentario comentarios) {
        this.comentarios.add(comentarios);
    }
}
