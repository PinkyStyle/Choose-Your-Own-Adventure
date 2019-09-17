package ControladorDeUsuario;

import GestionDeJugarLibroJuego.GestorDeJuego;
import ModuloDeCreacionLibroJuego.Camino;
import java.util.ArrayList;


/**
 *  Clase que se encarga de redireccionar acciones solicitadas por la vista del jugador
 */
public class ControladorVistaJugador {

    private GestorDeJuego gestorDeJuego;
    
    /**
     * El usuario debe seleccionar 
     * Default constructor
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
     * 
     * @param tituloDeAventura 
     */
    public void iniciarJuego(String tituloDeAventura){
        this.gestorDeJuego.inicialJuego(tituloDeAventura);
    }
    
    /**
     * 
     * @param camino 
     */
    public void actualizarPagina(String camino){
        this.gestorDeJuego.actualizarPagina(camino);
    }
    
    /**
     * muestra la descripcion de una pagina atraves de el titulo de la aventura 
     * y el numero de pagina
     * @param tituloDeAventura nombre de la libro
     * @param i numero de pagina actual
     * @return String
     */
    public String mostrarDescripcionDePagina(){ 
        return this.gestorDeJuego.mostrarDescripcionDePagina();
    }
    
    /**
     * 
     * @param tituloDeAventura
     * @param i
     * @return 
     */
    public ArrayList<String> mostrarImagenesDePagina(){
        return this.gestorDeJuego.mostrarImagenesDePagina();
    }
    
    /**
     * Muestra la lista de caminos que si puede transitar
     * @param tituloDeAventura
     * @param i
     * @return 
     */
    public ArrayList<String> mostrarListaCaminosDePagina(){     
         return this.gestorDeJuego.mostrarListaCaminosDePagina();
    }
}