package ModuloDeCreacionLibroJuego;


/**
 * Clase encargada de establecer el camino de nodo a nodo
 */
public class Camino {
    private int numeroPagina;
    private String opcion;
    private Artefacto darArtefacto;
    private Artefacto quitarArtefacto;
    private Artefacto solicitarArtefacto;

    /**
     * Constructor que declara todas las variables al ser creada
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
     * 
     * @return 
     */
    public String getOpcion() {
        return opcion;
    }

    public Artefacto getDarArtefacto() {
        return darArtefacto;
    }

    public Artefacto getQuitarArtefacto() {
        return quitarArtefacto;
    }

    public Artefacto getSolicitarArtefacto() {
        return solicitarArtefacto;
    }
    
}