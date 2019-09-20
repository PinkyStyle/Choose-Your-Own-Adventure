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
     * Constructor del adaptador, que crea el directorio general donde se
     * almacenaran todos los librjuegos.
     *
     * @throws java.io.IOException
     */
    public Adapter() throws IOException {
        origen = new File("").getAbsolutePath();
        origen = origen + "/LibroJuegos";
        File directorio = new File(origen);
        if (!directorio.exists()) {
            if (directorio.mkdir()) {
                System.out.println("Se ha creado el directorio para almacenar los librojuegos");
            }
        } else {
            System.out.println("El directorio para libros ya existe");
            //cargarLibroJuego();
        }
    }

    /**
     * Metodo que transforma el librojuego a un archivo txt.
     *
     * @param librojuego El librojuego a transformar.
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public void guardarLibroJuego(LibroJuego librojuego) throws FileNotFoundException, UnsupportedEncodingException {
        String libro = "/" + librojuego.getTituloDeAventura();
        File lj = new File(this.origen + libro);
        if (!lj.exists()) {
            if (lj.mkdirs()) {
                System.out.println("Se creo el directorio del librojuego");
                File paginas = new File(this.origen + libro + "/paginas");
                if (!paginas.exists()) {
                    if (paginas.mkdirs()) {
                        System.out.println("Directorio para imagenes creado con exito");
                    } else {
                        System.out.println("Ya existe un directorio para paginas");
                    }
                }
                File imagenes = new File(this.origen + libro + "/imagenes");
                if (!imagenes.exists()) {
                    if (imagenes.mkdirs()) {
                        System.out.println("Directorio para imagenes creado con exito");
                    } else {
                        System.out.println("Ya existe un directorio para imagenes");
                    }
                }
                String rutaImagen = librojuego.getImagen();
                if (rutaImagen != null) {
                    Path imagenOrigen = FileSystems.getDefault().getPath(librojuego.getImagen());
                    Path imagenDestino = FileSystems.getDefault().getPath(this.origen + libro + "/imagenLibro.jpg");
                    try {
                        Files.copy(imagenOrigen, imagenDestino, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        System.err.println(e);
                    }
                }

                try (PrintWriter pw = new PrintWriter(this.origen + libro + "/" + "Descripcion.txt", "UTF-8")) {
                    pw.println(librojuego.getTituloDeAventura());
                    pw.println(librojuego.getNombreDeAutor());
                    pw.println("-");
                    pw.println(librojuego.getSinopsis());
                    pw.println("-");
                }

                System.out.println("Se guardo el txt con el juego");
            } else {
                System.out.println("Error al crear el directorio del librojuego");
            }
        } else {
            System.out.println("Ese libro (o titulo) ya existe");
        }
    }

    /**
     * Metodo que transforma una pagina para ser guardada en un archivo .txt
     *
     * @param pagina La pagina a guardar
     * @param titulo El titulo del libro al que pertenece la pagina.
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void guardarPagina(BuilderPagina pagina, String titulo) throws FileNotFoundException, UnsupportedEncodingException {
        String directorio = origen + "/" + titulo + "/paginas";

        try (PrintWriter pw = new PrintWriter(directorio + "/pagina" + pagina.getNumeroPagina() + ".txt", "UTF-8")) {
            pw.println(pagina.getNumeroPagina());
            pw.println(pagina.getTipo());
            pw.println("-");
            pw.println(pagina.getDescripcion());
            pw.println("-");
            if (pagina.getTipo().contains("Final")) {
                Final f = (Final) pagina;
                if (f.getArtefacto() == null) {
                    pw.println("");
                } else {
                    pw.println(f.getArtefacto().getNombre());
                }
            } else {
                pw.println("");
            }
            ArrayList<String> img = pagina.getImagenes();
            for (int i = 0; i < img.size(); i++) {
                if (!img.isEmpty()) {
                    if (img.get(0) != null) {
                        Path imagenOrigen = FileSystems.getDefault().getPath(img.get(i));
                        Path imagenDestino = FileSystems.getDefault().getPath(
                                this.origen + "/" + titulo + "/imagenes/imagenPagina" + pagina.getNumeroPagina() + "p" + i + ".jpg");

                        try {
                            Files.copy(imagenOrigen, imagenDestino, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            System.err.println(e);
                        }
                    }
                }
            }
            if (pagina.getTipo().equals("Pagina Normal")) {
                PaginaNormal pn = (PaginaNormal) pagina;
                ArrayList<Camino> caminos = pn.getCaminos();

                for (Camino c : caminos) {
                    pw.println("-");
                    pw.println(c.getOpcion());
                    if (c.getDarArtefacto() != null) {
                        pw.println(c.getDarArtefacto().getNombre());
                    } else {
                        pw.println("");
                    }
                    if (c.getQuitarArtefacto() != null) {
                        pw.println(c.getQuitarArtefacto().getNombre());
                    } else {
                        pw.println("");
                    }
                    if (c.getSolicitarArtefacto() != null) {
                        pw.println(c.getSolicitarArtefacto().getNombre());
                    } else {
                        pw.println("");
                    }

                    pw.println(c.getNumeroPagina());
                }

            }
            pw.println("end");
        }
    }

    /**
     * Metodo para cargar los librojuegos ya existentes como txt.
     *
     * @throws java.io.FileNotFoundException
     */
    public void cargarLibroJuego() throws FileNotFoundException, IOException {
        File ruta = new File(this.origen);
        File[] libros = ruta.listFiles();

        if (libros.length != 0) {

            FileReader fr;
            BufferedReader br;

            for (File f : libros) {
                String autor = "";
                String titulo = "";
                String imagen = "";
                String sinopsis = "";

                int count = 0;
                String cadena;
                File[] archivos = f.listFiles();

                File[] imagenes = null;
                File[] paginas = null;
                count = 0;
                while (true) {
                    if (archivos[count].getName().equals("imagenes")) {
                        imagenes = archivos[count].listFiles();
                    }
                    if (archivos[count].getName().equals("paginas")) {
                        paginas = archivos[count].listFiles();
                    }
                    if (imagenes != null && paginas != null) {
                        break;
                    }
                    count++;
                }
                count = 0;
                if (paginas.length != 0) {
                    while (true) {
                        System.out.println(archivos[count].getName());
                        if (archivos[count].getName().equals("imagenLibro.jpg")) {
                            imagen = archivos[count].getAbsolutePath();
                            break;
                        }
                        count++;
                        if (count >= archivos.length) {
                            break;
                        }
                        
                    }
                    if (imagen.equals("")) {
                        imagen = null;
                    }
                    File descLibro = null;
                    count = 0;
                    while (true) {
                        System.out.println(archivos[count].getName());
                        if (archivos[count].getName().contains("Descripcion")) {
                            descLibro = archivos[count].getAbsoluteFile();
                            break;
                        }
                        count++;
                        if (count >= archivos.length - 1) {
                            break;
                        }
                    }
                    fr = new FileReader(descLibro);
                    br = new BufferedReader(fr);
                    int i = 0;
                    while ((cadena = br.readLine()) != null) {
                        if (i == 0) {
                            titulo = cadena;
                        }
                        if (i == 1) {
                            autor = cadena;
                        }
                        if (!"-".equals(cadena) && i != 0 && i != 1) {
                            sinopsis = sinopsis + cadena;
                        }
                        i++;
                    }
                    cadena = "";

                    ControladorVistaConstructor.gestorDeLibros.crearLibroJuego(autor, titulo, imagen, sinopsis);

                    int numeroPagina;
                    String tipo;
                    String descripcion = "";
                    Artefacto regalo;
                    for (File pag : paginas) {
                        fr = new FileReader(pag);
                        br = new BufferedReader(fr);
                        descripcion = "";
                        numeroPagina = Integer.parseInt(br.readLine());
                        tipo = br.readLine();
                        int contador = 0;
                        while (contador != 2) {
                            if ("-".equals(cadena = br.readLine())) {
                                contador++;
                            } else {
                                descripcion = descripcion + " " + cadena;
                            }
                        }

                        if (tipo.equals("Pagina Normal")) {

                            br.readLine();
                            if (imagenes.length != 0) {

                                for (File img : imagenes) {
                                    String algo = numeroPagina + "p";

                                    if (img.getName().contains(algo)) {
                                        ControladorVistaConstructor.gestorDeLibros.agregarPagina(
                                                titulo, numeroPagina, descripcion, tipo, img.getAbsolutePath(), null);
                                        System.out.println(img.getAbsolutePath());
                                    }
                                }
                            } else {
                                ControladorVistaConstructor.gestorDeLibros.agregarPagina(
                                        titulo, numeroPagina, descripcion, tipo, null, null);
                            }

                            Artefacto dar = null;
                            Artefacto quitar = null;
                            Artefacto solicitar = null;
                            String opcion = "";
                            int salto = 0;

                            while (!(cadena = br.readLine()).equals("end")) {
                                if (cadena.equals("-")) {
                                    opcion = br.readLine();
                                    if (!"".equals(cadena = br.readLine())) {
                                        dar = new Artefacto(cadena);
                                    } else {
                                        dar = null;
                                    }
                                    if (!"".equals(cadena = br.readLine())) {
                                        quitar = new Artefacto(cadena);
                                    } else {
                                        quitar = null;
                                    }
                                    if (!"".equals(cadena = br.readLine())) {
                                        solicitar = new Artefacto(cadena);
                                    } else {
                                        solicitar = null;
                                    }
                                    String numero = br.readLine();
                                    salto = Integer.parseInt(numero);
                                }
                                ControladorVistaConstructor.gestorDeLibros.agregarCamino(titulo, numeroPagina, salto, opcion, dar, quitar, solicitar);
                            }
                        } else {
                            String nombreRegalo = br.readLine();
                            if ("".equals(nombreRegalo)) {
                                regalo = null;
                            } else {
                                regalo = new Artefacto(nombreRegalo);
                            }
                            if (imagenes.length != 0) {
                                for (File img : imagenes) {
                                    String algo = numeroPagina + "p";
                                    if (img.getName().contains(algo)) {

                                        String hola = img.getAbsolutePath();
                                        System.out.println("el ruben es weco °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°|||" + hola);
                                        ControladorVistaConstructor.gestorDeLibros.agregarPagina(
                                                titulo, numeroPagina, descripcion, tipo, hola, regalo);
                                        System.out.println("el milla es weco!!!!!!!!!!!!!!!!!!!!!!!!!1" + ControladorVistaConstructor.gestorDeLibros.mostrarImagenesDePagina(titulo, numeroPagina).get(0));
                                        break;
                                    }

                                }
                                ControladorVistaConstructor.gestorDeLibros.agregarPagina(
                                        titulo, numeroPagina, descripcion, tipo, null, regalo);
                            } else {
                                ControladorVistaConstructor.gestorDeLibros.agregarPagina(
                                        titulo, numeroPagina, descripcion, tipo, null, regalo);
                            }
                        }
                    }
                } else {
                    System.out.println("El libro no tiene suficientes paginas");
                    System.out.println("Se eliminara el directorio asociado");
                    eliminarDirectorio(f);
                }

            }
        } else {
            System.out.println("No hay libros");
        }
    }

    private void eliminarDirectorio(File directorio) {
        if (directorio.isDirectory()) {

            if (directorio.list().length == 0) {
                directorio.delete();
            } else {

                for (String temp : directorio.list()) {
                    File fileDelete = new File(directorio, temp);
                    //recursive delete
                    eliminarDirectorio(fileDelete);
                }
                if (directorio.list().length == 0) {
                    directorio.delete();
                }

            }

        } else {
            directorio.delete();
        }
    }
}
