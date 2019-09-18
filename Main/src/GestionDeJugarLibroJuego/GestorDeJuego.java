package GestionDeJugarLibroJuego;

import static ControladorDeUsuario.ControladorVistaConstructor.gestorDeLibros;
import ModuloDeCreacionLibroJuego.Artefacto;
import ModuloDeCreacionLibroJuego.Camino;
import ModuloDeCreacionLibroJuego.LibroJuego;
import ModuloDeCreacionLibroJuego.PaginaNormal;
import java.util.ArrayList;

/**
 *
 */
public class GestorDeJuego {

    private Protagonista protagonista;
    private String tituloDeAventura;
    private int nPagina;
    /**
     * Default constructor
     *
     */
    public GestorDeJuego() {
    }

    //noh vimoh giles ctm
    /**
     *
     */
    public void jugarLibroJuego(String nombre) {
        this.crearProtagonista(nombre);
    }

    /**
     *
     */
    public void crearProtagonista(String nombre) {
        // TODO implement here
        this.protagonista = new Protagonista(nombre);
    }

   

    /**
     *
     * @return
     */
    public ArrayList<String> mostrarListaLibroJuegos() {
        /**
         * ArrayList<LibroJuego>libros=gestorDeLibros.getLibros();
         * ArrayList<String>nombreLibros=new ArrayList<>(); for (int i = 0; i <
         * libros.size(); i++) { LibroJuego libro = libros.get(i); String
         * tituloAventura = libro.getTituloDeAventura();
         * nombreLibros.add(tituloAventura); }
         *
         * return nombreLibros;
         *
         */
        return null;
    }

    /**
     *
     * @param tituloDeAventura
     * @return
     */
    public ArrayList<String> mostrarinformacionDeUnLibroJuegos(String tituloDeAventura) {
        return gestorDeLibros.mostrarinformacionDeUnLibroJuegos(tituloDeAventura);
    }

    //-----------------------------------------------------------------------
    /**
     * Inicializa el juego creando el protagonista, npagina 1, tituloDeAventura
     *
     * @param tituloDeAventura
     * @param nombreAventuraro
     */
    public void inicialJuego(String tituloDeAventura, String nombreAventuraro) {
        this.protagonista = new Protagonista(nombreAventuraro);
        this.tituloDeAventura = tituloDeAventura;
        this.nPagina = 1;
        this.protagonista.setArtefactos(new ArrayList<>());
        this.protagonista.setArtefactosQuemados(new ArrayList<>());
    }

    /**
     *
     * @param camino
     */
    public void actualizarPagina(String opcionCamino) {
        //1.agrego artefacto o elimino artefacto segun sea el caso.
        procesarOpcionDeCamino(opcionCamino);
        //2.verificar si la siguiente pagina existe.

        //3. setiar los el numero de pagina 
    }

    /**
     *
     * @return
     */
    public String mostrarDescripcionDePagina() {
        return gestorDeLibros.mostrarDescripcionDePagina(this.tituloDeAventura, this.nPagina);
    }

    /**
     *
     * @return
     */
    public ArrayList<String> mostrarImagenesDePagina() {
        return gestorDeLibros.mostrarImagenesDePagina(this.tituloDeAventura, this.nPagina);
    }

    /**
     * muestra todos los posibles caminos a los que puedo llegar teniendo en
     * cuenta la pagina actual y si tengo los artefactos necesarios para
     * transitar por este camino
     *
     * @return ArrayList<String> o null, dependera de si existen caminos.
     */
    public ArrayList<String> mostrarListaCaminosDePagina() {
        ArrayList<Camino> caminosAux = gestorDeLibros.getCaminosDePagina(tituloDeAventura, nPagina);
        return procesarCaminosMostrar(caminosAux);
    }

    /**
     * verifica los caminos a los cuales puedo llegar desde la pagina actual y
     * con los artefactos que tengo actualmente, solo muestra los caminos a los
     * que puedo llegar.
     *
     * @param caminos
     * @return
     */
    public ArrayList<String> procesarCaminosMostrar(ArrayList<Camino> caminos) {
        ArrayList<String> caminosQuePuedoIr = new ArrayList<>();
        for (int i = 0; i < caminos.size(); i++) {
            Camino camino = caminos.get(i);
            Artefacto solicitarArtefacto = camino.getSolicitarArtefacto();
            if (solicitarArtefacto != null) {// me solicitan un artefacto para transitar por ese camino.
                    if (protagonista.buscarArtefacto(solicitarArtefacto)) { //significa que tengo el artefacto para ir por ese camino.
                        caminosQuePuedoIr.add(camino.getOpcion());
                    }
                }
            }
        return caminosQuePuedoIr;
    }

    /**
     *
     * @param opcionCamino
     */
    public void procesarOpcionDeCamino(String opcionCamino) {
        ArrayList<Camino> caminosAux = gestorDeLibros.getCaminosDePagina(tituloDeAventura, nPagina);
        if (caminosAux != null)// si es null significa que el libro esta incompleto.
        {
            for (int i = 0; i < caminosAux.size(); i++) {
                Camino camino = caminosAux.get(i);
                if (camino.getOpcion().equalsIgnoreCase(opcionCamino) == true) {
                    //String nombreArtefacto = camino.getDarArtefacto().getNombre();
                    if (camino.getDarArtefacto() != null) {// me estan dando un  artefacto
                        protagonista.addArtefacto(camino.getDarArtefacto());
                    } else if (camino.getQuitarArtefacto() != null) {// me estan quitando un artefacto por ir a ese camino.
                        protagonista.eliminarArtefacto(camino.getQuitarArtefacto()); // al eliminar el artefacto de la lista se agrega al tiro a la lista de quemados
                    }

                }

            }
        }

    }

    /**
     * verifica el tipo de pagina que tiene un libro. Si una pagina es de tipo
     * final significa que no tiene camino, y por ende termina la historia.
     *
     * @param nombreLibro
     * @param pag
     * @return -1 si la pagina no se encontro, 0 si la pagina es de tipo final y
     * 1 si la pagina es paginaNormal.
     */
    public int tipoPag(String nombreLibro, int pag) {
        String tipoPagina = gestorDeLibros.tipoDePagina(tituloDeAventura, pag);
        if (tipoPagina != null) {
            if (tipoPagina.equalsIgnoreCase("final") == true) {
                return 0;
            } else if (tipoPagina.equalsIgnoreCase("paginaNormal") == true) {
                return 1;

            }
        }
        return -1;
    }

    /* Recibe el String de la pagina del libro al que se le modificara NOMBRE 
    por el nombre del prota
    */
    public String agregarNombre (String texto){
        texto = texto.replaceAll("NOMBRE", this.protagonista.getNombre());
        return texto;
    }
    
    }
