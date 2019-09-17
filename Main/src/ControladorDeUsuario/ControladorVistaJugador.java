package ControladorDeUsuario;


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
     * Default constructor
     */
    public ControladorVistaJugador() {
    }

    /**
     * 
     * @return 
     */
    public ArrayList<String> mostrarListaLibros(){
        return this.gestorDeJuego.mostrarListaLibroJuegos();
    }
    
    
    public ArrayList<String> mostrarInformacionDeUnLibroJuego(String tituloDeAventura){
        return this.gestorDeJuego.mostrarinformacionDeUnLibroJuegos(tituloDeAventura);
    }
    
    public String mostrarDescripcionDePagina(String tituloDeAventura, int i){
        
        return null;
    }
    
    public ArrayList<String> mostrarImagenesDePagina(String tituloDeAventura, int i){
        
        return null;
    }
    
    public ArrayList<Camino> mostrarListaCaminosDePagina(String tituloDeAventura, int i){
        
        return null;
    }
    
}