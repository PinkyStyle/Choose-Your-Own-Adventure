package GestionDeJugarLibroJuego;

import static ControladorDeUsuario.ControladorVistaConstructor.gestorDeLibros;
import ModuloDeCreacionLibroJuego.Camino;
import ModuloDeCreacionLibroJuego.LibroJuego;
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
    public GestorDeJuego() {}
    
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
    }

    /**
     * 
     * @param camino 
     */
    public void actualizarPagina(String camino) {
        String[] parse = camino.split(" ");
        this.nPagina=Integer.parseInt(parse[parse.length-1]);
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
     * 
     * @return 
     */
    public ArrayList<String> mostrarListaCaminosDePagina() {
        return gestorDeLibros.mostrarListaCaminosDePagina();
    }
}