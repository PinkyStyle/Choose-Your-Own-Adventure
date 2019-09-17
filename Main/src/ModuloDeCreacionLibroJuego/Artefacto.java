package ModuloDeCreacionLibroJuego;

/**
 * 
 */
public class Artefacto {
    private String nombre;

    /**
     * Constructor de artefactos.
     * @param nombre El nombre del artefacto a crear.
     */
    public Artefacto(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo que retorna el nombre del artefacto.
     * @return El nombre del artefacto.
     */
    public String getNombre() {
        return nombre;
    }        
}