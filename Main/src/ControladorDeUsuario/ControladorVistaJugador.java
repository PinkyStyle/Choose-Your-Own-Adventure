package ControladorDeUsuario;

import GestionDeJugarLibroJuego.GestorDeJuego;
import java.util.ArrayList;


/**
 *  Clase que se encarga de redireccionar acciones solicitadas por la vista del jugador
 * Procedimiento para utilizar el controlador
 * 1._ Para tu primera vista tienes los siguientes metodos
 * mostrarListaLibros: muestra la lista de todos los libros
 * mostrarInformacionDeUnLibroJuego: muestra los datos de un libro en espesifico
 * iniciarJuego: cuando este precione el boton de empezar, tienes que llamar este metodo para arrancar la historia
 * 2._Cuando se esta jugando
 * Cuando se esta jugando se hace el siguiente procedimiento:
 * tipoDePagina: metodo que te determina que tipo de pagina es: final o normal
 * mostrarDescripcionDePagina: metodo que te da la descripcion de la pagina "texto" NOTA: el texto ya se encuentra modificado cuando aparesca NOMBRE se cambie al nombre del aventurero
 * mostrarImagenesDePagina: metodo que retorna un listado de la imagen, NOTA: puedes ocupar solo la primera 0, dado que solo guardamos 1
 * mostrarListaCaminosDePagina: metodo que retorna lista de string listos para ponerlos en la interfaz con los caminos NOTA: el texto se puede modificar
 * actualizarPagina: Metodo que cambia la pagina, esto es cuando ya selecciono un camino NOTA: YA APRETO EL BOTON DE SIGUIENTE
 * 3._ al momento de llegar a un estado final o de que la pagina normal no tenga caminos
 * Si llegas a un final regular mandalo al inicio con este metodo "nuevoInicio", pero avisale
 * Si llegas a un final malo mandale un mensaje de opcion que diga que murio
 * Si llegas a un final bueno mandale un mensaje si quiere volver a jugar, si pone que si utiliza el metodo "nuevoInicio"
 * si la pagina normal no tiene caminos el metodo "mostrarListaCaminosDePagina" te saldra con un null, en ese caso dile que al quemar todos los artefactos no puede seguir avanzando
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
     * parametros: nombreAutor, tituloAventura,Sinopsis,rutaImagen, estado.
     * @param tituloDeAventura
     * @return ArrayList<String>
     */
    public ArrayList<String> mostrarInformacionDeUnLibroJuego(String tituloDeAventura){
        return this.gestorDeJuego.mostrarinformacionDeUnLibroJuegos(tituloDeAventura);
    }
    
    /**
     * Metodo que se encarga de inicializar el juego seleccionando el libroJuego y el nombre del protagonista
     * @param tituloDeAventura 
     * @param nombreAventuraro 
     */
    public void iniciarJuego(String tituloDeAventura, String nombreAventuraro){
        this.gestorDeJuego.inicialJuego(tituloDeAventura, nombreAventuraro);
    }
    
    /**
     * 
     */
    public void nuevoInicio(){
        this.gestorDeJuego.nuevoInicio();
    }
    
    /**
     * 
     * 
     * @param camino 
     */
    public int actualizarPagina(String camino){
        return this.gestorDeJuego.actualizarPagina(camino);
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
    
    /**
     * verifica el tipo de pagina que tiene un libro. Si una pagina es de tipo
     * final significa que no tiene camino, y por ende termina la historia.
     * Acuerdate de ocuparlo para saber si es pagina normal o final
     * Si es paginaNormal sigue con el procedimientio
     * Si es final tienes 2 opciones:
     * 1._ Final Bueno: cuando ya actualizaste nosotros lo dimos por completada, pero puedes darle la opcion al usuario de reiniciar con nuevoInicio()
     * 2._ Final Malo: Dile que murio y le muestras la ultima pagina
     * 3._ Final Regular: mandalo directamente al inicio con el metodo nuevoInicio
     * @return -1 si la pagina no se encontro, 0 si la pagina es de tipo final y
     * 1 si la pagina es paginaNormal.
     */
    public int tipoDePagina(){
        return this.gestorDeJuego.tipoPag();
    }
}