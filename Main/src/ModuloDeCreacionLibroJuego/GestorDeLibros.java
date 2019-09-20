package ModuloDeCreacionLibroJuego;
import ModuloDeGestorDeDatos.Adapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


/**
 * Clase que se encarga de administrar la creacion de libros y paginas, ademas este guarda el arreglo de libros
 */
public class GestorDeLibros {
    
    private ArrayList<LibroJuego> listaLibrojuego;
    private Adapter adaptador;

    /**
     * Constructor que inicializa el arreglo de libros vacio
     */
    public GestorDeLibros() throws IOException {
        this.listaLibrojuego=new ArrayList<>();
        this.adaptador = new Adapter();
    }

    /**
     * Metodo que se encarga de crear un libro nuevo
     * @param nombreDeAutor
     * @param tituloDeAventura
     * @param imagen
     * @param sinopsis 
     */
    public void crearLibroJuego(String nombreDeAutor, String tituloDeAventura, String imagen, String sinopsis) throws FileNotFoundException, UnsupportedEncodingException{
        this.listaLibrojuego.add(new LibroJuego(nombreDeAutor, tituloDeAventura, imagen, sinopsis));
        System.out.println("se creo el libro: gestor de libros - metodo crearLibroJuego");
        //ADAPTADOR VEN A BUSCARLO        
        this.adaptador.guardarLibroJuego(new LibroJuego(nombreDeAutor, tituloDeAventura, imagen, sinopsis));
    }
    
    /**
     * Metodo que se encarga de crear una pagina nueva al libro
     * @param tituloDeAventura
     * @param nPagina
     * @param descripcion
     * @param tipo
     * @param imagen
     * @param artefacto 
     */
    public void agregarPagina(String tituloDeAventura, int nPagina, String descripcion, String tipo, String imagen, Artefacto artefacto){
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                this.listaLibrojuego.get(i).crearPagina(nPagina, descripcion, tipo, imagen, artefacto);
                System.out.println("Se agrego la pagina: gestor de libros - metodo agregarPagina");
                return;
            }
        }
        System.out.println("no se creo la nueva pagina: gestor de libros - metodo agregarPagina");
    }
    
    /**
     * Metodo que retorna una lista con los datos del libro para ser enviados a la interfaz
     * @param tituloDeAventura
     * @return 
     */
    public ArrayList<String> mostrarinformacionDeUnLibroJuegos(String tituloDeAventura){
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                System.out.println("se encontro el libro: gestor de libros - metodo mostrarinformacionDeUnLibroJuegos");
                return this.listaLibrojuego.get(i).informacionDeLibroJuego();
            }
        }
        System.out.println("no se encontro el libro:: gestor de libros - metodo mostrarinformacionDeUnLibroJuegos");
        return null;
    }
    
    /**
     * Metodo que retorna una lista con los nombres de todos los libros para ser mandados a la interfaz
     * @return 
     */
    public ArrayList<String> mostrarListaDeLibroJuegos(){
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            lista.add(this.listaLibrojuego.get(i).getTituloDeAventura());
        }
        System.out.println("se creo la lista de libros: gestor de libros - metodo mostrarListaDeLibroJuegos");
        return lista;
    }
    
    /**
     * Metodo que retorna el tipo de pagina
     * @param tituloDeAventura
     * @param nPagina
     * @return 
     */
    public String tipoDePagina(String tituloDeAventura, int nPagina){
        BuilderPagina builderPagina=this.retornarPagina(tituloDeAventura, nPagina);
        if(builderPagina==null){
            System.out.println("no se encontro la pagina: gestor de libros - metodo tipoDePagina");
            return null;
        }
        System.out.println("se encontro la pagina y mandamos de vuelta el tipo: gestor de libros - metodo tipoDePagina");
        return builderPagina.getTipo();
    }
    
    /**
     * Metodo que devuelve la lista de caminos pero en tipo camino
     * @param tituloDeAventura
     * @param nPagina
     * @return 
     */
    public ArrayList<Camino> getCaminosDePagina(String tituloDeAventura, int nPagina) {
        BuilderPagina builderPagina=retornarPagina(tituloDeAventura, nPagina);
        if(builderPagina==null){
            System.out.println("no encuntro la pagina: gestor de libros - metodo getCaminosDePagina");
            return null;
        }
        PaginaNormal pagina;
        if("Pagina Normal".equals(builderPagina.getTipo())){
            pagina = (PaginaNormal)builderPagina;
        }else{
            System.out.println("no era pagina normal: gestor de libros- metodo getCaminosDePagina");
            return null;
        }
        System.out.println("se retornan los caminos: gestor de libros- metodo getCaminosDePagina");
        return pagina.getCaminos();
    }
    
    /**
     * Metodo que cambia el estado del libro de no completado a completado
     * @param tituloDeAventura 
     */
    public void cambiarEstadoLibro(String tituloDeAventura){
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                this.listaLibrojuego.get(i).editarEstado();
                System.out.println("se cambio el estado del libro: gestor de libros- metodo cambiarEstadoLibro");
                return;
            }
        }
    }
    
    /**
     * Metodo que retorna la descripcion de una pagina
     * @param tituloDeAventura
     * @param nPagina
     * @return 
     */
    public String mostrarDescripcionDePagina(String tituloDeAventura, int nPagina) {
        BuilderPagina builderPagina=retornarPagina(tituloDeAventura, nPagina);
        if(builderPagina==null){
            System.out.println("no se encontro la pagina: gestor de libros- metodo mostrarDescripcionDePagina");
            return null;
        }
        System.out.println("se devuelve la descripcion: gestor de libros- metodo mostrarDescripcionDePagina");
        return builderPagina.getDescripcion();
    }
    
    /**
     * Metodo que retorna las rutas para la interfaz
     * @param tituloDeAventura
     * @param nPagina
     * @return 
     */
    public ArrayList<String> mostrarRutasDePagina(String tituloDeAventura, int nPagina) {
        BuilderPagina builderPagina=retornarPagina(tituloDeAventura, nPagina);
        if(builderPagina==null){
            System.out.println("no encuntro la pagina: gestor de libros- metodo mostrarRutasDePagina");
            return null;
        }
        PaginaNormal pagina;
        if("Pagina Normal".equals(builderPagina.getTipo())){
            pagina = (PaginaNormal)builderPagina;
        }else{
            System.out.println("no era pagina normal: gestor de libros- metodo mostrarRutasDePagina");
            return null;
        }
        System.out.println("se retorna la lista de caminos para la interfaz: gestor de libros- metodo mostrarRutasDePagina");
        return pagina.arragloDeCaminos();
    }

    /**
     * Metodo que retorna las rutas de imagenes para la interfas
     * @param tituloDeAventura
     * @param nPagina
     * @return 
     */
    public ArrayList<String> mostrarImagenesDePagina(String tituloDeAventura, int nPagina) {
        BuilderPagina builderPagina=retornarPagina(tituloDeAventura, nPagina);
        if(builderPagina==null){
            System.out.println("no encuntro la pagina: gestor de libros- metodo mostrarImagenesDePagina");
            return null;
        }
        System.out.println("se manda la imagen: gestor de libros- metodo mostrarImagenesDePagina");
        return builderPagina.getImagenes();
    }
    
     /**
     * Metodo que se encarga de retornar una pagina especifica pero es privado, solo uso interno
     * @param tituloDeAventura
     * @param nPagina
     * @return 
     */
    public BuilderPagina retornarPagina(String tituloDeAventura, int nPagina) {
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                System.out.println("se encontro el libro y se retorna la pagina: gestor de libros- metodo retornarPagina");
                return this.listaLibrojuego.get(i).getPagina(nPagina);
            }
        }
        System.out.println("No se encontro el libro: gestor de libros- metodo retornarPagina");
        return null;
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
    public void agregarCamino(String tituloDeAventura, int nPagina, int proximoSalto, String opcion, Artefacto dar, Artefacto quitar, Artefacto solicitar) {
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                this.listaLibrojuego.get(i).agregarCamino(nPagina, proximoSalto, opcion, dar, quitar, solicitar);
                System.out.println("se agrego el camino: gestor de libros- metodo retornarPagina");
                return;
            }
        }
        System.out.println("no se agrego el camino no se encontro el libro o la pagina: gestor de libros- metodo retornarPagina");
    }

    /**
     * Metodo que avisa al adapter de que la pagina esta completamente creada
     * @param tituloLibroJuego
     * @param nPagina 
     */
    public void caminosCreados(String tituloLibroJuego, int nPagina) {
        //PINKI ACA LOCO, ESTAMOS READY CON LA PAGINA
        
    }
    
    
    public void cargar() throws IOException{
        this.adaptador.cargarLibroJuego();
    }
}