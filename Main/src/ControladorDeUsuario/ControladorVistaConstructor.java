package ControladorDeUsuario;

import ModuloDeCreacionLibroJuego.Artefacto;
import ModuloDeCreacionLibroJuego.GestorDeLibros;
import java.awt.Image;

/**
 * 
 */
public class ControladorVistaConstructor {

    /**
     * Default constructor
     */
    
    private String tituloDeAventura;
    private GestorDeLibros gestorDeLibros;
    
    public ControladorVistaConstructor() {
        this.gestorDeLibros=new GestorDeLibros();
    }


    /**
     * 
     * @param nombreDeAutor
     * @param tituloDeAventura
     * @param imagen
     * @param sinopsis 
     */
    public void crearLibroJuego(String nombreDeAutor, String tituloDeAventura, Image imagen, String sinopsis) {
        this.gestorDeLibros.crearLibroJuego(nombreDeAutor, tituloDeAventura, imagen, sinopsis);
    }

    /**
     * 
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