package ModuloDeCreacionLibroJuego;

import java.awt.Image;
import java.util.ArrayList;


/**
 * Clase que se encarga de crear un LibroJuego
 */
public class LibroJuego {
    private String nombreDeAutor;
    private String tituloDeAventura;
    private Image imagen;
    private String sinopsis;
    private ArrayList<BuilderPagina> paginas;

    /**
     * Constructor que inicializa el libro con sus atributos genericos y el arreglo lo crea sin paginas
     * @param nombreDeAutor
     * @param tituloDeAventura
     * @param imagen
     * @param sinopsis 
     */
    public LibroJuego(String nombreDeAutor, String tituloDeAventura, Image imagen, String sinopsis) {
        this.nombreDeAutor = nombreDeAutor;
        this.tituloDeAventura = tituloDeAventura;
        this.imagen = imagen;
        this.sinopsis = sinopsis;
        this.paginas=new ArrayList<>();
    }

    /**
     * Metodo que crea una pagina de 2 tipos:
     * 1._ Pagina normal
     * 2._ Final
     * @param numeroPagina
     * @param descripcion
     * @param tipo
     * @param artefacto 
     */
    public void crearPagina(int numeroPagina, String descripcion, String tipo, Artefacto artefacto) {
        if("Pagina Normal".equals(tipo)){
            this.paginas.add(new PaginaNormal(numeroPagina, descripcion, tipo));
            System.out.println("Se creo una pagina normal");
            return;
        }
        String[] parseo= descripcion.split(" ");
        if("Final".equals(parseo[0])){
            this.paginas.add(new Final(numeroPagina, descripcion, tipo, artefacto));
            System.out.println("se creo una pagina final");
            return;
        }
        System.out.println("Fallo al crear la pagina");
    }

    /**
     * Metodo que retorna una pagina especifica del LibroJuego
     * @param i
     * @return 
     */
    public BuilderPagina getPagina(int i) {
        return this.paginas.get(i);
    }

    /**
     * Metodo que retorna el titulo de la aventura
     * @return tituloDeAventura
     */
    public String getTituloDeAventura() {
        return tituloDeAventura;
    }

    public String getNombreDeAutor() {
        return nombreDeAutor;
    }

    public Image getImagen() {
        return imagen;
    }

    public String getSinopsis() {
        return sinopsis;
    }
    
    
    
}