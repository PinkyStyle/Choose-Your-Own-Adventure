package ModuloDeCreacionLibroJuego;

import java.util.ArrayList;

/**
 * Clase abstracta que el el cascaron para la generacion de builder este se encarga de crear una pagina y definir la estructura estandar de todas las paginas
 */
public abstract class BuilderPagina {
    
    protected Pagina pagina;
    
    /**
     * 
     * @param numeroPagina
     * @param descripcion
     * @param tipo 
     */
    public void crearNuevaPagina(int numeroPagina, String descripcion, String tipo) {
        this.pagina=new Pagina(numeroPagina, descripcion, tipo);
    }
    

    /**
     * Metodo que retorna la pagina
     */
    public Pagina getPagina() {
        return this.pagina;
    }
    

    public abstract String getTipo();
    public abstract int getNumeroPagina();
    public abstract String getDescripcion() ;
    public abstract ArrayList<String> getImagenes();
    public abstract void addImagenes(String imagen);
    
}