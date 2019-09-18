package ControladorDeUsuario;

import ModuloDeCreacionLibroJuego.Artefacto;
import ModuloDeCreacionLibroJuego.GestorDeLibros;
import java.awt.Image;

/**
 * Clase que se encarga de redireccionar acciones solicitadas por la vista del constructor
 */
public class ControladorVistaConstructor {

    private String tituloDeAventura;
    public static GestorDeLibros gestorDeLibros;
    
    /**
     * Constructor de la vista del autor
     */
    public ControladorVistaConstructor() {
        this.gestorDeLibros=new GestorDeLibros();
    }

    /**
     * Metodo que se encarga de decirle al gestor de libros que cree un libro
     * @param nombreDeAutor
     * @param tituloDeAventura
     * @param imagen
     * @param sinopsis 
     */
    public void crearLibroJuego(String nombreDeAutor, String tituloDeAventura, String imagen, String sinopsis) {
        this.gestorDeLibros.crearLibroJuego(nombreDeAutor, tituloDeAventura, imagen, sinopsis);
    }

    
    /**
     * Metodo que se encarga de decirle al gestor de libros que cree una pagina
     * @param tituloDeAventura
     * @param numeroPagina
     * @param descripcion
     * @param tipo
     * @param artefacto 
     */
    public void crearPagina(String tituloDeAventura, int numeroPagina, String descripcion, String tipo, Artefacto artefacto) {
        this.gestorDeLibros.agregarPagina(tituloDeAventura, numeroPagina, descripcion, tipo, artefacto);
    }

    
    
}