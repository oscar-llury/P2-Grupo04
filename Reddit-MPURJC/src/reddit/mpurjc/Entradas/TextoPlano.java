
package reddit.mpurjc.Entradas;


public class TextoPlano implements TipoEntrada {

       protected String titulo;
       protected String texto;

    public TextoPlano(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    @Override
    public boolean validar() {
        return texto.equals("entrada");
    }

    @Override
    public void mostrar() {
        System.out.println("Título: "+this.titulo);
        System.out.println("Contenido: "+this.texto);
    }
    
}
