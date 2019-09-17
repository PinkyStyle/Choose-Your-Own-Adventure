package ModuloDeCreacionLibroJuego;


/**
 * 
 */
public class Camino {
    private int numeroPagina;
    private String opcion;
    private Artefacto darArtefacto;
    private Artefacto quitarArtefacto;
    private Artefacto solicitarArtefacto;

    /**
     * Default constructor
     */
    public Camino(int n, String opcion, Artefacto dar, Artefacto quitar, Artefacto solicitar) {
        this.numeroPagina=n;
        this.opcion=opcion;
        this.darArtefacto=dar;
        this.quitarArtefacto=quitar;
        this.solicitarArtefacto=solicitar;
        
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

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