package GestionDeJugarLibroJuego;
import ModuloDeCreacionLibroJuego.Artefacto;
import java.util.ArrayList;

/**
 * 
 */
public class Protagonista {
    private ArrayList<String> artefactos;
    private ArrayList<String> artefactosQuemados;
    private String nombre; 
    /**
     * Default constructor
     */
    public Protagonista(String nombre) {
        this.nombre = nombre;
    }

    public boolean buscarArtefacto(String artefacto) {
        if(artefactos.contains(artefacto)){
            return true
        }
        else {
            return false;
        }
    }
    public void setArtefactos(ArrayList<String> artefactos) {
        this.artefactos = artefactos;
    }
    public void addArtefacto(String artefacto){
        artefactos.add(artefacto);
    }
    public void eliminarArtefacto(String artefacto){
        artefactos.remove(artefacto);  
        addArtefactoQuemado(artefacto);
    }
    
    public boolean buscarAtefactoQuemado(String artefacto){
       if(artefactos.contains(artefacto)){
            return true;
        }
        else {
            return false;
        }
    }
    public void setArtefactosQuemados(ArrayList<String> artegactosQuemados) {
        this.artefactosQuemados = artegactosQuemados;
    }
    public void addArtefactoQuemado(String artefacto){
        artefactosQuemados.add(artefacto);
    }
  
    
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}