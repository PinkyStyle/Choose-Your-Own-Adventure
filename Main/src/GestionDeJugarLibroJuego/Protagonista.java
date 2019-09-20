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
        this.artefactos=new ArrayList<>();
        this.artefactosQuemados=new ArrayList<>();
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
        this.artefactos.remove(artefacto);  
        this.addArtefactoQuemado(artefacto);
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
    
    /**
     * 
     * @param artegactosQuemados 
     */
    public void setArtefactosQuemados(ArrayList<Artefacto> artegactosQuemados) {
        this.artefactosQuemados = artegactosQuemados;
    }
    
    /**
     * 
     * @param artefacto 
     */
    public void addArtefactoQuemado(Artefacto artefacto){
        artefactosQuemados.add(artefacto);
    }
  
    /**
     * 
     * @return 
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}