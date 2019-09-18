package ModuloDeCreacionLibroJuego;
import java.util.ArrayList;


/**
 * Clase que se encarga de administrar la creacion de libros y paginas, ademas este guarda el arreglo de libros
 */
public class GestorDeLibros {
    private ArrayList<LibroJuego> listaLibrojuego;

    /**
     * Constructor que inicializa el arreglo de libros vacio
     */
    public GestorDeLibros() {
        this.listaLibrojuego=new ArrayList<>();
    }

    /**
     * Metodo que se encarga de crear un libro nuevo
     * @param nombreDeAutor
     * @param tituloDeAventura
     * @param imagen
     * @param sinopsis 
     */
    public void crearLibroJuego(String nombreDeAutor, String tituloDeAventura, String imagen, String sinopsis){
        this.listaLibrojuego.add(new LibroJuego(nombreDeAutor, tituloDeAventura, imagen, sinopsis));
    }
    
    /**
     * Metodo que se encarga de crear una pagina nueva al libro
     * @param tituloDeAventura
     * @param nPagina
     * @param descripcion
     * @param tipo
     * @param artefacto 
     */
    public void agregarPagina(String tituloDeAventura, int nPagina, String descripcion, String tipo, Artefacto artefacto){
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                this.listaLibrojuego.get(i).crearPagina(nPagina, descripcion, tipo, artefacto);
                return;
            }
        }
        System.out.println("no se creo la nueva pagina");
    }
    
    /**
     * Metodo que retorna una lista con los datos del libro para ser enviados a la interfaz
     * @param tituloDeAventura
     * @return 
     */
    public ArrayList<String> mostrarinformacionDeUnLibroJuegos(String tituloDeAventura){
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                return null;
            }
        }
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
            return null;
        }
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
            System.out.println("no encuntro la pagina");
            return null;
        }
        PaginaNormal pagina;
        if("Pagina Normal".equals(builderPagina.getTipo())){
            pagina = (PaginaNormal)builderPagina;
        }else{
            System.out.println("no era pagina normal");
            return null;
        }
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
            System.out.println("no encuntro la pagina");
            return null;
        }
        PaginaNormal pagina;
        if("Pagina Normal".equals(builderPagina.getTipo())){
            pagina = (PaginaNormal)builderPagina;
        }else{
            System.out.println("no era pagina normal");
            return null;
        }
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
            System.out.println("no encuntro la pagina");
            return null;
        }
        
        return null;
    }
    
     /**
     * Metodo que se encarga de retornar una pagina especifica pero es privado, solo uso interno
     * @param tituloDeAventura
     * @param numeroPagina
     * @return 
     */
    private BuilderPagina retornarPagina(String tituloDeAventura, int nPagina) {
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                return this.listaLibrojuego.get(i).getPagina(nPagina);
            }
        }
        System.out.println("No se encontro el libro");
        return null;
    }
}

