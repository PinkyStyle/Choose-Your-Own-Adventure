package GestionDeJugarLibroJuego;

import static ControladorDeUsuario.ControladorVistaConstructor.gestorDeLibros;
import ModuloDeCreacionLibroJuego.Artefacto;
import ModuloDeCreacionLibroJuego.Camino;
import ModuloDeCreacionLibroJuego.Final;
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

    //noh vimoh giles ctm v 1.1

    /**
     *Lista que retorna todos los nombres de los libros para ser mostrados en la interfaz.
     * @return
     */
    public ArrayList<String> mostrarListaLibroJuegos() {
        return gestorDeLibros.mostrarListaDeLibroJuegos(); 
    }

    /**
     *devuelve toda la informacion de un libro, con exepción de las
     * paginas que este contenga.
     * @param tituloDeAventura
     * @return
     */
    public ArrayList<String> mostrarinformacionDeUnLibroJuegos(String tituloDeAventura) {
        return gestorDeLibros.mostrarinformacionDeUnLibroJuegos(tituloDeAventura);
    }

    //-----------------------------------------------------------------------
    /**
     * Inicializa el juego creando el protagonista, npagina 1, tituloDeAventura,
     * ademas de resetear las lista de artefactos y artefactos quemados
     * que tienen un protagonista.
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
     * @return -1 si la pagina no se encontro, 0 si la pagina es de tipo final y
     * 1 si la pagina es paginaNormal.
     * @param camino
     */
    public int actualizarPagina(String opcionCamino) {
        //1.agrego artefacto o elimino artefacto segun sea el caso.
        Camino camino=null;
        // se obtienen todos los caminos de una pagina.
        ArrayList<Camino> caminos = gestorDeLibros.getCaminosDePagina(tituloDeAventura, nPagina);
        // obtengo todos los caminos a los que puedo ir, con los artefactos que tiene el protagonista.
        ArrayList<String> lista = gestorDeLibros.mostrarRutasDePagina(tituloDeAventura, nPagina);
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).equals(opcionCamino)){
                camino = caminos.get(i);
                if (camino.getDarArtefacto() != null) {// me estan dando un  artefacto, y por ende debo guardarlo.
                    if(!protagonista.buscarAtefactoQuemado(camino.getDarArtefacto())){
                        protagonista.addArtefacto(camino.getDarArtefacto());
                    }
                } 
                if(!protagonista.buscarArtefacto(camino.getDarArtefacto())){
                    if (camino.getQuitarArtefacto() != null) {// me estan quitando un artefacto por ir a ese camino.
                        protagonista.eliminarArtefacto(camino.getQuitarArtefacto()); // al eliminar el artefacto de la lista se agrega al tiro a la lista de quemados
                    }
                }
                break;// salimos del ciclo debido a que dar y quitar son las unicas opciones que podemos realizar
            }
        }
        if(camino==null){//significa que la pagina no tenia caminos
            return -1;
        }
        String tipo =gestorDeLibros.tipoDePagina(tituloDeAventura, camino.getNumeroPagina());// obtenemos el tipo de pagina, de la pagina a la que saltaremos.
        if(tipo==null){// significa que no hay salgo, osea no existe una forma de llegar al camino
            return -1;
        }
        if("Final".equals(tipo)){
            Final pagina = (Final)gestorDeLibros.retornarPagina(tituloDeAventura, nPagina);
            if("Bueno".equals(pagina.getTipoFinal())){
                gestorDeLibros.cambiarEstadoLibro(tituloDeAventura);
            }
            return 0;
        }
        this.nPagina=camino.getNumeroPagina();
        return 1;
    }

    /**
     *devuelve la descripcion de una pagina.
     * @return
     */
    public String mostrarDescripcionDePagina() {
        String aux = gestorDeLibros.mostrarDescripcionDePagina(this.tituloDeAventura, this.nPagina);
        return this.agregarNombre(aux);
    }

    /**
     * devuelve la ruta de la imagen de una pagina.
     * @return puede ser null si la pagina no tiene imagene.
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
        //Eliminar caminos que no se pueden transitar
        ArrayList<Camino> caminos = gestorDeLibros.getCaminosDePagina(tituloDeAventura, nPagina);
        ArrayList<String> lista = gestorDeLibros.mostrarRutasDePagina(tituloDeAventura, nPagina);
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i < caminos.size(); i++) {
            if(caminos.get(i).getSolicitarArtefacto()!=null){
                if(protagonista.buscarArtefacto(caminos.get(i).getSolicitarArtefacto())){
                    aux.add(lista.get(i));
                }
            }else{
                aux.add(lista.get(i));
            }
        }
        if(aux.isEmpty()){
            return null;
        }
        return aux;
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
     * verifica el tipo de pagina que tiene un libro. Si una pagina es de tipo
     * final significa que no tiene camino, y por ende termina la historia.
     *
     * @return -1 si la pagina no se encontro, 0 si la pagina es de tipo final y
     * 1 si la pagina es paginaNormal.
     */
    public int tipoPag() {
        String tipoPagina = gestorDeLibros.tipoDePagina(this.tituloDeAventura, this.nPagina);
        if (tipoPagina != null) {
            if (tipoPagina.equalsIgnoreCase("Final") == true) {
                return 0;
            } else if (tipoPagina.equalsIgnoreCase("Pagina Normal") == true) {
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

    /**
     * actualiza el numero de pagina.
     */
    public void nuevoInicio() {
        this.nPagina = 1;
    }
    
    }
