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

    /**
     * 
     * @param artefacto
     * @return 
     */
    public boolean buscarArtefacto(Artefacto artefacto) {
        for (int i = 0; i < artefactos.size(); i++) {
            if(artefactos.get(i).getNombre().equals(artefacto.getNombre())){
                return true;
            }
        }  
        return false;
    }
   
    /**
     * 
     * @param artefactos 
     */
    public void setArtefactos(ArrayList<Artefacto> artefactos) {
        this.artefactos = artefactos;
    }
    
    /**
     * 
     * @param artefacto 
     */
    public void addArtefacto(Artefacto artefacto){
        artefactos.add(artefacto);
    }
    
    /**
     * 
     * @param artefacto 
     */
    public void eliminarArtefacto(Artefacto artefacto){
        artefactos.remove(artefacto);  
        addArtefactoQuemado(artefacto);
    }
    
    /**
     * 
     * @param artefacto
     * @return 
     */
    public boolean buscarAtefactoQuemado(Artefacto artefacto){
       for (int i = 0; i < artefactosQuemados.size(); i++) {
            if(artefactosQuemados.get(i).getNombre().equals(artefacto.getNombre())){
                return true;
            }
        }  
        return false;
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