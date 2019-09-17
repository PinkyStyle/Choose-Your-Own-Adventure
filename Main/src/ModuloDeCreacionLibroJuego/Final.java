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
     * 
     */
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