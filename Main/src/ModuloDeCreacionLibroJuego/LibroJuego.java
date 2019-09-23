package ModuloDeCreacionLibroJuego;

import java.awt.Image;
import java.util.ArrayList;


/**
 * Clase que se encarga de crear un LibroJuego
 */
public class LibroJuego {
    private String nombreDeAutor;
    private String tituloDeAventura;
    private String imagen;
    private String sinopsis;
    private ArrayList<BuilderPagina> paginas;
    private String estado="No Completado";

    /**
     * Constructor que inicializa el libro con sus atributos genericos y el arreglo lo crea sin paginas
     * @param nombreDeAutor
     * @param tituloDeAventura
     * @param imagen
     * @param sinopsis 
     */
    public LibroJuego(String nombreDeAutor, String tituloDeAventura, String imagen, String sinopsis) {
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
    public void crearPagina(int numeroPagina, String descripcion, String tipo, String imagen, Artefacto artefacto) {
        if("Pagina Normal".equals(tipo)){
            PaginaNormal pagina= new PaginaNormal(numeroPagina, descripcion, tipo);
            pagina.addImagenes(imagen);
            this.paginas.add(pagina);
            return;
        }
        String[] parseo= tipo.split(" ");
        if("Final".equals(parseo[0])){
            Final pagina=new Final(numeroPagina, descripcion, tipo, artefacto);
            pagina.addImagenes(imagen);
            this.paginas.add(pagina);
            System.out.println("se creo una pagina final de tipo " + tipo);
            return;
        }
    }
 
    /**
     * 
     * @param nPagina
     * @param proximoSalto
     * @param opcion
     * @param dar
     * @param quitar
     * @param solicitar 
     */
    public void agregarCamino(int nPagina, int proximoSalto, String opcion, Artefacto dar, Artefacto quitar, Artefacto solicitar){
        for (int i = 0; i < this.paginas.size(); i++) {
            if(this.paginas.get(i).getNumeroPagina()==nPagina){
                PaginaNormal pagina=(PaginaNormal)this.paginas.get(i);
                pagina.agregarCamino(new Camino(proximoSalto, opcion,  dar,  quitar,  solicitar));
                return;
            }
        }
    }

    /**
     * Metodo que retorna una pagina especifica del LibroJuego
     * @param i
     * @return 
     */
    public BuilderPagina getPagina(int nPagina) {
        for (int j = 0; j < this.paginas.size(); j++) {
            if(this.paginas.get(j).getNumeroPagina()==nPagina){
                return this.paginas.get(j);
            }
        }
        System.out.println("No se encontro la pagina");
        return null;
    }
    
    /**
     * 
     */
    public void editarEstado(){
        this.estado="Completado";
    }

    /**
     * Metodo que retorna el titulo de la aventura
     * @return tituloDeAventura
     */
    public String getTituloDeAventura() {
        return tituloDeAventura;
    }

    /**
     * 
     * @return 
     */
    public String getNombreDeAutor() {
        return nombreDeAutor;
    }

    /**
     * 
     * @return 
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * 
     * @return 
     */
    public String getSinopsis() {
        return sinopsis;
    }
    
    /**
     * Metodo que retorna la informacion de un libro en una cadena
     * @return 
     */
    @Override
    public String toString(){
        return nombreDeAutor + " " + tituloDeAventura + " " + sinopsis + " " + imagen + " " + estado;
    }

    /**
     * Metodo que retorna una lista con toda la informacion del libro juego
     * @return 
     */
    public ArrayList<String> informacionDeLibroJuego() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add(this.nombreDeAutor);
        lista.add(this.tituloDeAventura);
        lista.add(this.sinopsis);
        lista.add(this.imagen);
        lista.add(this.estado);
        return lista;
    }
}