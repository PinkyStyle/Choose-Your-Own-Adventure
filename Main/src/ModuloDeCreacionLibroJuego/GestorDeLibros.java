package ModuloDeCreacionLibroJuego;

import java.awt.Image;
import java.util.ArrayList;


/**
 * 
 */
public class GestorDeLibros {
    private ArrayList<LibroJuego> listaLibrojuego;

    /**
     * 
     */
    public GestorDeLibros() {
        this.listaLibrojuego=new ArrayList<>();
    }

    /**
     * 
     * @param nombreDeAutor
     * @param tituloDeAventura
     * @param imagen
     * @param sinopsis 
     */
    public void crearLibroJuego(String nombreDeAutor, String tituloDeAventura, Image imagen, String sinopsis){
        this.listaLibrojuego.add(new LibroJuego(nombreDeAutor, tituloDeAventura, imagen, sinopsis));
    }
    
    /**
     * 
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
         
    /**
     * 
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

}