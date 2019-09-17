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
     * @param tipo
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
    
    /**
     * Metodo que retorna la lista de imagenes asociadas a la pagina.
     * @return La lista de imagenes asociadas.
     */
    public ArrayList<Image> getImagenes() {
        return imagenes;
    }
    
    /**
     * Metodo que agrega una imagen a la pagina.
     * @param imagen La imagen que se desea agregar a la pagina.
     */
    public void addImagenes(Image imagen) {
       this.imagenes.add(imagen);
    }
    
    /**
     * Metodo que retorna el tipo de la pagina.
     * @return El numero de la pagina.
     */
    public String getTipo() {
        return tipo;
    }

}