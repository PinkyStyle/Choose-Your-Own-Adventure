package ModuloDeCreacionLibroJuego;
import java.awt.Image;
import java.util.ArrayList;


/**
 * 
 */
public class Pagina {
    private int numeroPagina;
    private String descripcion;
    private ArrayList<Image> imagenes;
    private String tipo;
    

    /**
     * Constructor de Pagina.
     * @param numeroPagina El numero que se le asigna a la pagina.
     * @param descripcion La descripcion asociada a la pagina.
     */
    public Pagina(int numeroPagina, String descripcion, String tipo) {
        this.numeroPagina = numeroPagina;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    /**
     * Metodo que retorna el numero de la pagina correspondiente.
     * @return El numero de la pagina.
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }
    
    /**
     * Metodo que retorna la descripcion o contenido de la pagina.
     * @return La descripcion de la pagina correspondiente.
     */
    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Image> getImagenes() {
        return imagenes;
    }

    public void addImagenes(Image imagen) {
       this.imagenes.add(imagen);
    }

    public String getTipo() {
        return tipo;
    }

}