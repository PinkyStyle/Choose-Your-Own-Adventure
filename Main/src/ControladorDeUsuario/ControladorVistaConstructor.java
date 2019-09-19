package ControladorDeUsuario;

import ModuloDeCreacionLibroJuego.Artefacto;
import ModuloDeCreacionLibroJuego.GestorDeLibros;

/**
 * Clase que se encarga de redireccionar acciones solicitadas por la vista del constructor
 * Metodologia de creacion
 * 1._ Primero se debe crear el libro, para esto ocupe el metodo "crearLibroJuego"
 * 2._ Despues debe crear la pagina, para esto ocupe el metodo "crearPagina"
 * 3._ por ultimo agrege 1 por 1 los caminos, para esto ocupe el metodo "crearPagina"
 * Nota: la parte 3 tiene que hacerlo 1 a 1, un camino a la vez
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
     * @param imagen
     * @param artefacto
     */
    public void crearPagina(String tituloDeAventura, int numeroPagina, String descripcion, String tipo, String imagen, Artefacto artefacto) {
        this.gestorDeLibros.agregarPagina(tituloDeAventura, numeroPagina, descripcion, tipo, imagen, artefacto);
    }
    
    /**
     * Metodo que agrega un camino
     * @param tituloDeAventura
     * @param nPagina
     * @param proximoSalto
     * @param opcion
     * @param dar
     * @param quitar
     * @param solicitar 
     */
    public void agregarCamino(String tituloDeAventura, int nPagina, int proximoSalto, String opcion, Artefacto dar, Artefacto quitar, Artefacto solicitar){
         this.gestorDeLibros.agregarCamino(tituloDeAventura,  nPagina,  proximoSalto,  opcion,  dar,  quitar,  solicitar);
    }

}