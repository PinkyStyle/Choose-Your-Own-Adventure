package ModuloDeCreacionLibroJuego;

import java.awt.Image;
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
    public void crearLibroJuego(String nombreDeAutor, String tituloDeAventura, Image imagen, String sinopsis){
        this.listaLibrojuego.add(new LibroJuego(nombreDeAutor, tituloDeAventura, imagen, sinopsis));
    }
    
    /**
     * Metodo que se encarga de crear una pagina nueva al libro
     * @param tituloDeAventura
     * @param numeroPagina
     * @param descripcion
     * @param tipo
     * @param artefacto 
     */
    public void agregarPagina(String tituloDeAventura, int numeroPagina, String descripcion, String tipo, Artefacto artefacto){
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                this.listaLibrojuego.get(i).crearPagina(numeroPagina, descripcion, tipo, artefacto);
                return;
            }
        }
        System.out.println("no se creo la nueva pagina");
    }
    
    public LibroJuego informacionLibroJuego(String tituloDeAventura){
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                return this.listaLibrojuego.get(i);
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
    public BuilderPagina retornarPagina(String tituloDeAventura, int numeroPagina) {
        for (int i = 0; i < listaLibrojuego.size() ; i++) {
            if(this.listaLibrojuego.get(i).getTituloDeAventura().equals(tituloDeAventura)){
                return this.listaLibrojuego.get(i).getPagina(i);
            }
        }
        System.out.println("No se encontro el libro");
        return null;
    }
    /**
     * retorna la descripcion de una pagina, atraves del nombre de la aventura
     * y el numero de pagina.
     * @param tituloDeAventura
     * @param numeroPag
     * @return 
     */
    public String mostrarDescripcionDePagina(String tituloDeAventura, int numeroPag) {
        BuilderPagina builderPagina=retornarPagina(tituloDeAventura, numeroPag);
        PaginaNormal pagina = (PaginaNormal)builderPagina;
        return pagina.getDescripcion();
    }
    /**
     * retorna una array con la lista de las rutas de la imagenes.
     * OJO NO ESTA FUNCIONAL, FALTA QUE EN VEZ DE QUE ME PASEN LA IMAGEN, SOLO ME PASEN LA RUTA.
     * @param tituloDeAventura
     * @param numeroPag
     * @return 
     */
    public ArrayList<String> mostrarRutasDePagina(String tituloDeAventura, int numeroPag) {
        BuilderPagina builderPagina=retornarPagina(tituloDeAventura, numeroPag);
        PaginaNormal pagina = (PaginaNormal)builderPagina;
        //return pagina.getImagenes();
        return null;
    }

    public ArrayList<String> mostrarImagenesDePagina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<String> mostrarListaCaminosDePagina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




}

