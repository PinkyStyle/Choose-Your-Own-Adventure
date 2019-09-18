package GestionDeJugarLibroJuego;
import ModuloDeCreacionLibroJuego.Artefacto;
import java.util.ArrayList;

/**
 * 
 */
public class Protagonista {
    private ArrayList<Artefacto> artefactos;
    private ArrayList<Artefacto> artefactosQuemados;
    private String nombre; 
    
    /**
     * Default constructor
     */
    public Protagonista(String nombre) {
        this.nombre = nombre;
    }

    public boolean buscarArtefacto(Artefacto artefacto) {
        if(artefactos.contains(artefacto)){
            return true;
        }
        else {
            return false;
        }
    }
    
    
    
    public void setArtefactos(ArrayList<Artefacto> artefactos) {
        this.artefactos = artefactos;
    }
    
    public void addArtefacto(Artefacto artefacto){
        artefactos.add(artefacto);
    }
    
    public void eliminarArtefacto(Artefacto artefacto){
        artefactos.remove(artefacto);  
        addArtefactoQuemado(artefacto);
    }
    
    public boolean buscarAtefactoQuemado(Artefacto artefacto){
       if(artefactos.contains(artefacto)){
            return true;
        }
        else {
            return false;
        }
    }
    public void setArtefactosQuemados(ArrayList<Artefacto> artegactosQuemados) {
        this.artefactosQuemados = artegactosQuemados;
    }
    public void addArtefactoQuemado(Artefacto artefacto){
        artefactosQuemados.add(artefacto);
    }
  
    
    public String getNombre(){
        return this.nombre;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}