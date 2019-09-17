package ModuloDeGestorDeDatos;
import ModuloDeCreacionLibroJuego.LibroJuego;
import ModuloDeCreacionLibroJuego.Pagina;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Adapter {
    private String origen;
    
    public Adapter(){
        origen = new File("").getAbsolutePath();
        origen = origen+"/LibroJuegos";
        File directorio = new File(origen);
        if(directorio.mkdir()){
            System.out.println("Se ha creado el directorio para almacenar los librojuegos");
        }
    }
       
    /**
     * Metodo que transforma el librojuego a un archivo txt.
     * @param librojuego El librojuego a transformar.
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public void guardarLibroJuego(LibroJuego librojuego) throws FileNotFoundException, UnsupportedEncodingException{
        String libro = "/"+librojuego.getTituloDeAventura();
        File lj = new File(this.origen+libro);
        if(!lj.exists()){
            if(lj.mkdirs()){
                System.out.println("Se creo el directorio del librojuego");
            }
            else{
                System.out.println("Error al crear el directorio del librojuego");
            }
        }
        else{
            System.out.println("Ese libro (o titulo) ya existe");
        }
        File paginas = new File(this.origen+libro+"/paginas");
        if(!paginas.exists()){
            if(paginas.mkdirs()){
                System.out.println("Directorio para imagenes creado con exito");
            }
            else{
                System.out.println("Ya existe un directorio para paginas");
            }
        }
        File imagenes = new File(this.origen+libro+"/imagenes");
        if(!imagenes.exists()){
            if(imagenes.mkdirs()){
                System.out.println("Directorio para imagenes creado con exito");
            }
            else{
                System.out.println("Ya existe un directorio para imagenes");
            }
        }
        
        try (PrintWriter pw = new PrintWriter(this.origen+libro+"Descripcion.txt","UTF-8")) {
            pw.println(librojuego.getTituloDeAventura());
            pw.println(librojuego.getNombreDeAutor());
            
            pw.println(librojuego.getSinopsis());
            
        }               
        
    }
    
    public void guardarPagina(Pagina pagina, String titulo) throws FileNotFoundException, UnsupportedEncodingException{
        String directorio = origen+"/"+titulo+"/paginas";
        
        PrintWriter pw = new PrintWriter(directorio+"/pagina"+pagina.getNumeroPagina(),"UTF-8");
        
    }
    
    
    /**
     * Metodo que transforma un archivo txt a un librjuego.
     */
    public void cargarPaginaLibroJuegos(){        
        
    }
    
    
}
