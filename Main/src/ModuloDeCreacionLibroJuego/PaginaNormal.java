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

    @Override
    public void getTipo() {
        super.pagina.getTipo();
    }

    @Override
    public int getNumeroPagina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescripcion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Image> getImagenes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addImagenes(Image imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}