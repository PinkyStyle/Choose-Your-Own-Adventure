package GestionDeJugarLibroJuego;

import static ControladorDeUsuario.ControladorVistaConstructor.gestorDeLibros;
import ModuloDeCreacionLibroJuego.Artefacto;
import ModuloDeCreacionLibroJuego.BuilderPagina;
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
    private ArrayList<String>artefactosQuemados;
    private ArrayList<String>artefactosActuales;

    /**
     * Default constructor
     *
     */
    public GestorDeJuego() {
    }
    
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
     * devuelve el nombre del autor del libro
     *
     * @param libro
     * @return
     */
    public String getNombreAutorLibro(LibroJuego libro) {
        return libro.getNombreDeAutor();
    }

    /**
     * 
     * @return 
     */
    public ArrayList<String> mostrarListaLibroJuegos() {
        /**
        ArrayList<LibroJuego>libros=gestorDeLibros.getLibros();
        ArrayList<String>nombreLibros=new ArrayList<>();
        for (int i = 0; i < libros.size(); i++) {
            LibroJuego libro = libros.get(i);
            String tituloAventura = libro.getTituloDeAventura();
            nombreLibros.add(tituloAventura);
        }

        return nombreLibros;
        * */
        return null;
    }

    /**
     * 
     * @param tituloDeAventura
     * @return 
     */
    public ArrayList<String> mostrarinformacionDeUnLibroJuegos(String tituloDeAventura) {
        ArrayList<String> lista = new ArrayList<>();
        LibroJuego libro = gestorDeLibros.informacionLibroJuego(tituloDeAventura);
        if (libro != null) {
            String nombreAutor = libro.getNombreDeAutor();
            String tituloAventura = libro.getTituloDeAventura();
            String Sinopsis = libro.getSinopsis();
            // cuando cambien el contructor de la imagen descomentan esta parte.
            //String rutaImagen=libro.getImagen();

            lista.add(nombreAutor);
            lista.add(tituloAventura);
            lista.add(Sinopsis);
            //lista.add(rutaImagen);
            return lista;
        }
        return null;
    }

 //-----------------------------------------------------------------------


    /**
     * Inicializa el juego creando el protagonista, npagina 1, tituloDeAventura
     * @param tituloDeAventura 
     * @param nombreAventuraro 
     */
    public void inicialJuego(String tituloDeAventura, String nombreAventuraro) {
        this.protagonista=new Protagonista(nombreAventuraro);
        this.tituloDeAventura=tituloDeAventura;
        this.nPagina=1;  
        this.artefactosActuales= new ArrayList<>();
        this.artefactosQuemados= new ArrayList<>();
    }

    /**
     * 
     * @param camino 
     */
    public void actualizarPagina(String opcionCamino) {
        
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
        return gestorDeLibros.mostrarImagenesDePagina();
    }

    /**
     * muestra todos los posibles caminos a los que puedo llegar teniendo en cuenta
     * la pagina actual y si tengo los artefactos necesarios para transitar por este
     * camino
     * @return ArrayList<String> o null, dependera de si existen caminos.
     */
    public ArrayList<String> mostrarListaCaminosDePagina() {
         ArrayList<Camino>caminosAux=gestorDeLibros.getCaminosDePagina(tituloDeAventura, nPagina);
        return procesarCaminosMostrar(caminosAux);
    }
    /**
     * verifica los caminos a los cuales puedo llegar desde la pagina actual
     * y con los artefactos que tengo actualmente, solo muestra los 
     * caminos a los que puedo llegar.
     * @param caminos
     * @return 
     */
    public ArrayList<String> procesarCaminosMostrar(ArrayList<Camino>caminos){
        ArrayList<String>caminosQuePuedoIr=new ArrayList<>();
        for (int i = 0; i < caminos.size(); i++) {
            Camino camino = caminos.get(i);
            Artefacto solicitarArtefacto=camino.getSolicitarArtefacto();
            if( solicitarArtefacto != null ){// me solicitan un artefacto para transitar por ese camino.
                String nombreArtefactoSolicitado=solicitarArtefacto.getNombre();
                for (String artefactosActuale : this.artefactosActuales) {
                    String miArtefacto=this.artefactosActuales.get(i);// obtengo el nombre del primer artefacto.
                    if(nombreArtefactoSolicitado.equalsIgnoreCase(miArtefacto) == true){ //significa que tengo el artefacto para ir por ese camino.
                        
                        caminosQuePuedoIr.add(camino.getOpcion());
                    }
                }
            }
            
        }
        return caminosQuePuedoIr;
    }

    public void procesarOpcionDeCamino(String opcionCamino){
        ArrayList<Camino>caminosAux=gestorDeLibros.mostrarListaDeCaminosDePagina(tituloDeAventura, nPagina);
    }
}