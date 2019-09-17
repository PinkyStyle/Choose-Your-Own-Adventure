package ModuloDeCreacionLibroJuego;

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
        super(numeroPagina,descripcion,tipo);
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

}