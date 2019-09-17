package GestionDeJugarLibroJuego;

import static ControladorDeUsuario.ControladorVistaConstructor.gestorDeLibros;
import ModuloDeCreacionLibroJuego.Camino;
import ModuloDeCreacionLibroJuego.LibroJuego;
import java.util.ArrayList;

import ModuloDeCreacionLibroJuego.BuilderPagina;
import ModuloDeCreacionLibroJuego.GestorDeLibros;
import ModuloDeCreacionLibroJuego.LibroJuego;
import ModuloDeCreacionLibroJuego.Pagina;
import ModuloDeCreacionLibroJuego.PaginaNormal;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 */
public class GestorDeJuego {

    private boolean protagonistaCreado = false;
    private Protagonista protagonista;

    /**
     * Default constructor
     *
     * @param nombreLibro
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
     */
    public void obtenerSiguientePagina() {
        // TODO implement here

    }

    /**
     *
     */
    public void nuevoInicio() {
        // TODO implement here

    }

    /**
     *
     */
    public void libroFinalizado() {
        // TODO implement here
        // que cambie el estado del libro al inicio del juego como completado
    }

    public void cambiarNombre() {
        //cambia NOMBRE por el nombre ingresado por el Protagonista
    }

    public void gestionarArtefacto() {
        // obtiene el artefacto de la pagina segun la opcion seleccionada
        // elimina el artefactgo en caso de ser quemado segun la opcion seleccionada
    }

    public void validarOpciones() {
        // segun los artefactos que se tengan son las opciones 
        // segun los objetos quemados 

    }

    public ArrayList<String> mostrarListaLibroJuegos() {
        ArrayList<LibroJuego>libros=gestorDeLibros.getLibros();
        ArrayList<String>nombreLibros=new ArrayList<>();
        for (int i = 0; i < libros.size(); i++) {
            LibroJuego libro = libros.get(i);
            String tituloAventura = libro.getTituloDeAventura();
            nombreLibros.add(tituloAventura);
        }

        return nombreLibros;
    }

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
    /**
     * muestra la informacion de una pagina.
     * @param tituloDeAventura
     * @param numeroPag
     * @return 
     */
    public String mostrarDescripcionDePagina(String tituloDeAventura, int numeroPag) {
        return gestorDeLibros.descripcionDePagina(tituloDeAventura,numeroPag);
    }
    /**
     * retorna una array con la lista de las rutas de las imagenes.
     * NO ESTA FUNCIONAL AUN, HASTA QUE MODIFIQUEN EL TIPO DE ATRIBUTO QUE TIENE
     * LIBRO JUEGO.
     * @param tituloDeAventura
     * @param i
     * @return 
     */
    public ArrayList<String> mostrarImagenesDePagina(String tituloDeAventura, int i) {

        //return gestorDeLibros.mostrarRutasDePagina();
        return null;
    }

    public ArrayList<Camino> mostrarListaCaminosDePagina(String tituloDeAventura, int i) {

        return gestorDeLibros.mostrarListaDeCaminosDePagina(tituloDeAventura,i);
    }
}