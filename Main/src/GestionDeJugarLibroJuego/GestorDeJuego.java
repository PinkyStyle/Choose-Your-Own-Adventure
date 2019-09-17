package GestionDeJugarLibroJuego;
import static ControladorDeUsuario.ControladorVistaConstructor.gestorDeLibros;
import ModuloDeCreacionLibroJuego.Camino;
import ModuloDeCreacionLibroJuego.LibroJuego;
import java.util.ArrayList;

/**
 * 
 */
public class GestorDeJuego {
    private boolean protagonistaCreado = false; 
    private Protagonista protagonista;
    
    /**
     * Default constructor
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
        this.protagonista=new Protagonista(nombre);
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
    
    public void cambiarNombre(){
     //cambia NOMBRE por el nombre ingresado por el Protagonista
    }
    
    public void gestionarArtefacto(){
    // obtiene el artefacto de la pagina segun la opcion seleccionada
    // elimina el artefactgo en caso de ser quemado segun la opcion seleccionada
    }
    
    public void validarOpciones(){
    // segun los artefactos que se tengan son las opciones 
    // segun los objetos quemados 
    
    }
    
    public ArrayList<String> mostrarListaLibroJuegos(){
        
        return null;
    }
    
    
    public ArrayList<String> mostrarinformacionDeUnLibroJuegos(String tituloDeAventura){
        ArrayList<String> lista = new ArrayList<>();
        LibroJuego libro =gestorDeLibros.informacionLibroJuego(tituloDeAventura); 
        return null;
    }
    
    public String mostrarDescripcionDePagina(String tituloDeAventura, int i){
        return gestorDeLibros.descripcionDePagina(tituloDeAventura); 
    }
    
    public ArrayList<String> mostrarImagenesDePagina(String tituloDeAventura, int i){
        
        return gestorDeLibros.mostrarRutasDePagina();
    }
    
    
    public ArrayList<Camino> mostrarListaCaminosDePagina(String tituloDeAventura, int i){
        
        return gestorDeLibros.mostrarListaDeCaminosDePagina();
    }
}