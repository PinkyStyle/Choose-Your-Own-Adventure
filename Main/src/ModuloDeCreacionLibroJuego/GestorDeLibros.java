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
    
    public ArrayList<String> mostrarinformacionDeUnLibroJuegos(String tituloDeAventura){
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                return null;
            }
        }
        return null;
    }
    
    public ArrayList<String> mostrarListaNombreLibroJuegos(){
        
        return null;
    }
         
    /**
     * Metodo que se encarga de retornar una pagina especifica dado a un tituloDeAventura y un numero de pagina
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
    
    /**
     * retorna la descripcion de una pagina, atraves del nombre de la aventura
     * y el numero de pagina.
     * @param tituloDeAventura
     * @param nPagina
     * @return 
     */
    public String mostrarDescripcionDePagina(String tituloDeAventura, int nPagina) {
        BuilderPagina builderPagina=retornarPagina(tituloDeAventura, nPagina);
        return builderPagina.getDescripcion();
    }
    
    /**
     * 
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
     * retorna una array con la lista de las rutas de la imagenes.
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

    public ArrayList<String> mostrarImagenesDePagina(String tituloDeAventura, int nPagina) {
        BuilderPagina builderPagina=retornarPagina(tituloDeAventura, nPagina);
        if(builderPagina==null){
            System.out.println("no encuntro la pagina");
            return null;
        }
        
        return null;
    }

    public ArrayList<String> mostrarListaCaminosDePagina() {
        
        return null;
    }

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
    
}

