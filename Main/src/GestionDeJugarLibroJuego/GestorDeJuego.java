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

    /**
     *
     * @return
     */
    public ArrayList<String> mostrarListaLibroJuegos() {
        return gestorDeLibros.mostrarListaDeLibroJuegos(); 
    }

    /**
     *
     * @param tituloDeAventura
     * @return
     */
    public ArrayList<String> mostrarinformacionDeUnLibroJuegos(String tituloDeAventura) {
        System.out.println("Mostrando información del libro " + tituloDeAventura);
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
        System.out.println("Ha iniciado el juego!");
        System.out.println("Protagonista: " + nombreAventuraro);
        
    }

    /**
     * @return -1 si la pagina no se encontro, 0 si la pagina es de tipo final y
     * 1 si la pagina es paginaNormal.
     * @param camino
     */
    public int actualizarPagina(String opcionCamino) {
        //1.agrego artefacto o elimino artefacto segun sea el caso.
        Camino camino=null;
        ArrayList<Camino> caminos = gestorDeLibros.getCaminosDePagina(tituloDeAventura, nPagina);
        ArrayList<String> lista = gestorDeLibros.mostrarRutasDePagina(tituloDeAventura, nPagina);
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).equals(opcionCamino)){
                camino = caminos.get(i);
                if (camino.getDarArtefacto() != null) {// me estan dando un  artefacto
                    if(!protagonista.buscarAtefactoQuemado(camino.getDarArtefacto())){
                        protagonista.addArtefacto(camino.getDarArtefacto());
                        System.out.println("Artefacto añadido: " + camino.getDarArtefacto().getNombre());
                    }
                } 
                if(!protagonista.buscarArtefacto(camino.getDarArtefacto())){
                    if (camino.getQuitarArtefacto() != null) {// me estan quitando un artefacto por ir a ese camino.
                        System.out.println("Artefacto quitado: " + camino.getQuitarArtefacto().getNombre());
                        protagonista.eliminarArtefacto(camino.getQuitarArtefacto()); // al eliminar el artefacto de la lista se agrega al tiro a la lista de quemados
                    }
                }
                break;
            }
        }
        if(camino==null){
            System.out.println("Camino null. Página no encontrada");
            return -1;
        }
        String tipo =gestorDeLibros.tipoDePagina(tituloDeAventura, camino.getNumeroPagina());
        if(tipo==null){
            System.out.println("Tipo null. Página no encontrada");
            return -1;
        }
        if("Final".equals(tipo)){
            Final pagina = (Final)gestorDeLibros.retornarPagina(tituloDeAventura, nPagina);
            if("Bueno".equals(pagina.getTipoFinal())){
                System.out.println("Final bueno obtenido");
                gestorDeLibros.cambiarEstadoLibro(tituloDeAventura);
            }
            System.out.println("Esta es la pagina final");
            return 0;
        }
        System.out.println("fin de página normal");
        this.nPagina=camino.getNumeroPagina();
        return 1;
    }

    /**
     *
     * @return
     */
    public String mostrarDescripcionDePagina() {
        String aux = gestorDeLibros.mostrarDescripcionDePagina(this.tituloDeAventura, this.nPagina);
        return this.agregarNombre(aux);
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
        //Eliminar caminos que no se pueden transitar
        ArrayList<Camino> caminos = gestorDeLibros.getCaminosDePagina(tituloDeAventura, nPagina);
        ArrayList<String> lista = gestorDeLibros.mostrarRutasDePagina(tituloDeAventura, nPagina);
        ArrayList<String> aux = new ArrayList<>();
        for (int i = 0; i < caminos.size(); i++) {
            if(caminos.get(i).getSolicitarArtefacto()!=null){
                if(protagonista.buscarArtefacto(caminos.get(i).getSolicitarArtefacto())){
                    aux.add(lista.get(i));
                    System.out.println("Camino transitable añadido");
                }
            }else{
                aux.add(lista.get(i));
                System.out.println("Camino transitable añadido");
            }
        }
        if(aux.isEmpty()){
            System.out.println("No hay caminos");
            return null;
        }
        System.out.println("Se ha retornado la lista con todos los caminos transitables");
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
                    System.out.println("Artefacto solicitado: " + solicitarArtefacto.getNombre());
                    if (protagonista.buscarArtefacto(solicitarArtefacto)) { //significa que tengo el artefacto para ir por ese camino.
                        caminosQuePuedoIr.add(camino.getOpcion());
                        System.out.println("Sí tengo el artefacto");
                    }
                }
            }
        return caminosQuePuedoIr;
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
    public int tipoPag() {
        String tipoPagina = gestorDeLibros.tipoDePagina(this.tituloDeAventura, this.nPagina);
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

    /**
     * 
     */
    public void nuevoInicio() {
        System.out.println("Nuevo inicio de libro");
        this.nPagina = 1;
    }
    
    }
