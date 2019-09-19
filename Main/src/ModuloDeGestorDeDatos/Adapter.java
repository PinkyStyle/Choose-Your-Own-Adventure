package ModuloDeGestorDeDatos;
import ControladorDeUsuario.ControladorVistaConstructor;
import ModuloDeCreacionLibroJuego.Artefacto;
import ModuloDeCreacionLibroJuego.BuilderPagina;
import ModuloDeCreacionLibroJuego.Camino;
import ModuloDeCreacionLibroJuego.Final;
import ModuloDeCreacionLibroJuego.LibroJuego;
import ModuloDeCreacionLibroJuego.PaginaNormal;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Adapter {
    private String origen;
    
    /**
     * Constructor del adaptador, que crea el directorio general donde se almacenaran todos los librjuegos.
     */
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
        String[] ruta = librojuego.getImagen().split(".");
                
        Path imagenOrigen = FileSystems.getDefault().getPath(librojuego.getImagen());
        Path imagenDestino = FileSystems.getDefault().getPath(this.origen+libro+"/imagenLibro."+ruta[1]);
        
        try {
            Files.copy(imagenOrigen, imagenDestino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }  
        
        try (PrintWriter pw = new PrintWriter(this.origen+libro+"Descripcion.txt","UTF-8")) {
            pw.println(librojuego.getTituloDeAventura());
            pw.println(librojuego.getNombreDeAutor());
            pw.println("-");
            pw.println(librojuego.getSinopsis());
            pw.println("-");                  
        }                       
    }
    
    /**
     * Metodo que transforma una pagina para ser guardada en un archivo .txt
     * @param pagina La pagina a guardar
     * @param titulo El titulo del libro al que pertenece la pagina.
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException 
     */
    public void guardarPagina(BuilderPagina pagina, String titulo) throws FileNotFoundException, UnsupportedEncodingException{
        String directorio = origen+"/"+titulo+"/paginas";
        
        try (PrintWriter pw = new PrintWriter(directorio+"/pagina"+pagina.getNumeroPagina(),"UTF-8")) {
            pw.println(pagina.getNumeroPagina());
            pw.println(pagina.getTipo());
            pw.println(pagina.getDescripcion());
            if("Final".equals(pagina.getTipo())){
                Final f = (Final) pagina;
                pw.println(f.getArtefacto().getNombre());
            }
            ArrayList<String> img = pagina.getImagenes();
            for (int i = 0; i < img.size(); i++) {
                String[] ruta = img.get(i).split(".");
                
                Path imagenOrigen = FileSystems.getDefault().getPath(img.get(i));
                Path imagenDestino = FileSystems.getDefault().getPath(
                        this.origen+titulo+"/imagenPagina"+pagina.getNumeroPagina()+"-"+i+"."+ruta[1]);

                try {
                    Files.copy(imagenOrigen, imagenDestino, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.err.println(e);
                }  
                
            }
            if(pagina.getTipo().equals("Pagina Normal")){
                PaginaNormal pn = (PaginaNormal) pagina;
                ArrayList<Camino> caminos = pn.getCaminos();
                
                for(Camino c:caminos){
                    pw.println("-");
                    pw.println(c.getOpcion());
                    pw.println(c.getDarArtefacto());
                    pw.println(c.getQuitarArtefacto());
                    pw.println(c.getSolicitarArtefacto());
                    pw.println(c.getNumeroPagina());                
                }
                pw.println("end");
            }
        }
    }
    
    /**
     * Metodo para cargar los librojuegos ya existentes como txt.
     * @throws java.io.FileNotFoundException
     */
    public void cargarLibroJuego() throws FileNotFoundException, IOException{
        File ruta = new File(this.origen);
        File[] libros = ruta.listFiles();
        String autor = "";
        String titulo = "";
        String imagen = "";
        String sinopsis = "";
        
        FileReader fr;
        BufferedReader br;
        
        for(File f:libros){  
            
            String cadena;
            File[] archivos = f.listFiles();
            imagen = archivos[3].getAbsolutePath();
            fr = new FileReader(archivos[2]);
            br = new BufferedReader(fr);    
            
            for (int i = 0; i <0; i++) {
                if((cadena = br.readLine()) != null){
                    if(i== 0){
                        titulo = cadena;
                    }
                    if(i==1){
                        autor = cadena;
                    }
                    if(i>=3 && !"-".equals(cadena)){
                        sinopsis = sinopsis+cadena;
                    }
                }
                break;
            }
            
            ControladorVistaConstructor.gestorDeLibros.crearLibroJuego(autor, titulo, imagen, sinopsis);
            
            File[] imagenes = archivos[0].listFiles();            
            File[] paginas = archivos[1].listFiles();
            
            int numeroPagina;
            String tipo;
            String descripcion = "";    
            Artefacto regalo;
            
            for(File pag:paginas){
                fr = new FileReader(pag);
                br = new BufferedReader(fr);                                
                
                numeroPagina = Integer.parseInt(br.readLine());
                tipo = br.readLine();
                descripcion = descripcion+br.readLine();
                
                if(tipo.equals("Pagina Normal")){
                    
                    ControladorVistaConstructor.gestorDeLibros.agregarPagina(titulo, numeroPagina, descripcion, tipo, null);
                    
                    Artefacto dar = null;
                    Artefacto quitar = null;
                    Artefacto solicitar = null;
                    String opcion = "";
                    int salto = -1;
                    
                    while(!(cadena = br.readLine()).equals("end")){
                        if(cadena.equals("-")){
                            opcion = br.readLine();
                            if((cadena=br.readLine()) != null ){
                                dar = new Artefacto(cadena);
                            }
                            if((cadena=br.readLine()) != null ){
                                quitar = new Artefacto(cadena);
                            }
                            if((cadena=br.readLine()) != null ){
                                solicitar = new Artefacto(cadena);
                            }
                            salto = Integer.parseInt(br.readLine());
                        }
                        ControladorVistaConstructor.gestorDeLibros.agregarCamino(titulo, numeroPagina, salto, origen, dar, quitar, solicitar);
                    }                                                              
                }
                else{
                    regalo = new Artefacto(br.readLine());
                    ControladorVistaConstructor.gestorDeLibros.agregarPagina(titulo, numeroPagina, descripcion, tipo, regalo);
                }
                
                for(File img:imagenes){
                    if(img.getAbsolutePath().contains(numeroPagina+"-")){
                        
                    }
                }
            }
            
        }        
    }
}
