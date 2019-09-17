package GestionDeJugarLibroJuego;

/**
 * 
 */
public class GestorDeJuego {
    private boolean protagonistaCreado = false; 
    /**
     * Default constructor
     */
    public GestorDeJuego() {
    }

    /**
     * 
     */
    public void jugarLibroJuego() {
        if(protagonistaCreado){
            // el wn juega 
        }else{
            // el wn no juega 
        }
    }

    /**
     * 
     */
    public void crearProtagonista() {
        protagonistaCreado = true;
        // TODO implement here
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
}