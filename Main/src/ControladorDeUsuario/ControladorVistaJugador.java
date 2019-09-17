package ControladorDeUsuario;

import GestionDeJugarLibroJuego.GestorDeJuego;
import ModuloDeCreacionLibroJuego.LibroJuego;
import java.util.ArrayList;

import GestionDeJugarLibroJuego.GestorDeJuego;
import ModuloDeCreacionLibroJuego.Camino;
import java.awt.Image;
import java.util.ArrayList;


/**
 *  Clase que se encarga de redireccionar acciones solicitadas por la vista del jugador
 */
public class ControladorVistaJugador {

    private GestorDeJuego gestorDeJuego;
    
    /**
     * El usuario debe seleccionar 
     * Default constructor
     * @param nombreLibro
     */
    public ControladorVistaJugador() {
        this.gestorDeJuego=new GestorDeJuego();
    }

    /**
     * Muestra una array con el nombre de todas las aventuras.
     * @return 
     */
    public ArrayList<String> mostrarListaLibros(){
        return this.gestorDeJuego.mostrarListaLibroJuegos();
    }
    
    /**
     * dependiendo del nombre de la aventura, retorna una array Con los siguientes
     * parametros: nombreAutor, tituloAventura,Sinopsis,rutaImagen.
     * @param tituloDeAventura
     * @return ArrayList<String>
     */
    public ArrayList<String> mostrarInformacionDeUnLibroJuego(String tituloDeAventura){
        return this.gestorDeJuego.mostrarinformacionDeUnLibroJuegos(tituloDeAventura);
    }
    /**
     * muestra la descripcion de una pagina atraves de el titulo de la aventura 
     * y el numero de pagina
     * @param tituloDeAventura
     * @param i
     * @return String
     */
    public String mostrarDescripcionDePagina(String tituloDeAventura, int i){
        
        return this.gestorDeJuego.mostrarDescripcionDePagina(tituloDeAventura, i);
    }
    
    public ArrayList<String> mostrarImagenesDePagina(String tituloDeAventura, int i){
        
        return this.gestorDeJuego.mostrarImagenesDePagina(tituloDeAventura, i);
    }
    
    public ArrayList<Camino> mostrarListaCaminosDePagina(String tituloDeAventura, int i){
        
         return this.gestorDeJuego.mostrarListaCaminosDePagina(tituloDeAventura,i);
    }
}