package ModuloDeCreacionLibroJuego;


/**
 * Clase encargada de establecer el camino de nodo a nodo
 */
public class Camino {
    private final int numeroPagina;
    private final String opcion;
    private final Artefacto darArtefacto;
    private final Artefacto quitarArtefacto;
    private final Artefacto solicitarArtefacto;

    /**
     * Constructor de camino que declara todas las variables al ser creada
     * @param n
     * @param opcion
     * @param dar
     * @param quitar
     * @param solicitar
     */
    public Camino(int n, String opcion, Artefacto dar, Artefacto quitar, Artefacto solicitar) {
        this.numeroPagina=n;
        this.opcion=opcion;
        this.darArtefacto=dar;
        this.quitarArtefacto=quitar;
        this.solicitarArtefacto=solicitar;
        
    }
    

    /**
     * Metodo que retorna el numero de la pagina
     * @return numeroPagina
     */
    public int getNumeroPagina() {
        return numeroPagina;
    }

    /**
     * Metodo que retorna la opcion "el texto adjunto a este"
     * @return 
     */
    public String getOpcion() {
        return opcion;
    }

    /**
     * Metodo que retorna el artefacto a dar
     * @return 
     */
    public Artefacto getDarArtefacto() {
        return darArtefacto;
    }

    /**
     * Metodo que retorna el artefacto a quitar si ocupa este camino
     * @return 
     */
    public Artefacto getQuitarArtefacto() {
        return quitarArtefacto;
    }

    /**
     * Metodo que retorna el artefacto necesario para ocupara el camino
     * @return 
     */
    public Artefacto getSolicitarArtefacto() {
        return solicitarArtefacto;
    }
    
}