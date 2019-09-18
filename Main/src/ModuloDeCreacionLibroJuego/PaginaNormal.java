package ModuloDeCreacionLibroJuego;

import java.awt.Image;
import java.util.ArrayList;


/**
 * 
 */
public class PaginaNormal extends BuilderPagina {
    private ArrayList<Camino> caminos;

    /**
     * Constructor de Paginas Normales
     * @param numeroPagina
     * @param descripcion
     * @param tipo El tipo de Pagina 
     */
    public PaginaNormal(int numeroPagina, String descripcion,String tipo) {
        super.crearNuevaPagina(numeroPagina, descripcion, tipo);
        this.caminos = new ArrayList();
    }
    
    
    
    /**
     * Metodo que retorna los caminos asociados a la pagina.
     * @return La lista de caminos asociados a la pagina.
     */
    public ArrayList<Camino> getCaminos() {
        return caminos;
    }
    
    /**
     * Metodo que asocia un camino a la pagina correspondiente.
     * @param camino El camino que se desea agregar a la pagina.
     */
    public void setCaminos(Camino camino) {
        this.caminos.add(camino);
    }
    
    /**
     * Metodo que agrega un camino a la pagina.
     * @param camino El camino a agregar a la pagina.
     */
    public void agregarCamino(Camino camino) {
        this.caminos.add(camino);
    }
    
    /**
     * Metodo que retorna el tipo de la pagina a la cual esta asociada.
     * @return El numero de la pagina.
     */
    @Override
    public String getTipo() {
        return this.pagina.getTipo();
    }
    
    /**
     * Metodo que retorna el numero de la pagina a la cual esta asociada.
     * @return El numero de la pagina.
     */
    @Override
    public int getNumeroPagina() {
        return this.pagina.getNumeroPagina();
    }
    
    /**
     * Metodo que retorna la descripcion de la pagina a la cual esta asociada.
     * @return La descripcion de la pagina.
     */
    @Override
    public String getDescripcion() {
        return this.pagina.getDescripcion();
    }
    
    /**
     * Metodo que retorna las imagenes de la pagina a la cual esta asociada.
     * @return La lista de imagenes asociadas.
     */
    @Override
    public ArrayList<String> getImagenes() {
        return this.pagina.getImagenes();
    }
    
    /**
     * Metodo que agrega una imagen a la pagina a la cual esta asociada.
     * @param imagen La imagen que se desea agregar a la pagina.
     */
    @Override
    public void addImagenes(String imagen) {
        this.pagina.addImagenes(imagen);
    }
    
    

}