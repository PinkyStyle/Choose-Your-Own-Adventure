package ModuloDeCreacionLibroJuego;

import java.awt.Image;
import java.util.ArrayList;

/**
 * 
 */
public class Final extends BuilderPagina {
    
    private Artefacto artefacto;

    /**
     * 
     * @param numeroPagina
     * @param descripcion
     * @param tipo
     * @param artefacto 
     */
    public Final(int numeroPagina, String descripcion, String tipo, Artefacto artefacto) {
        super.crearNuevaPagina(numeroPagina, descripcion, tipo);
        this.artefacto = artefacto;
    }
    
    /**
     * 
     */
    public void getRecompensa() {
        // TODO implement here
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
    public ArrayList<Image> getImagenes() {
        return this.pagina.getImagenes();
    }
    
    /**
     * Metodo que agrega una imagen a la pagina a la cual esta asociada.
     * @param imagen La imagen que se desea agregar a la pagina.
     */
    @Override
    public void addImagenes(Image imagen) {
        this.pagina.addImagenes(imagen);
    }

}