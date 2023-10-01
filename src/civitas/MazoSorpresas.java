/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.*;

/**
 *
 * @author Rocío Barragán Moreno
 */
public class MazoSorpresas {
    static private int CERO = 0;
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init(){
        sorpresas = new ArrayList<>();
        barajada = false;
        usadas = CERO;
    }
    
    MazoSorpresas(boolean debug){
        init();
        this.debug = debug;
        if(debug)
            Diario.getInstance().ocurreEvento("El modo debug esta activado.\n");
    }
    
    MazoSorpresas(){
        init();
        debug = false;
    }
    
    void alMazo(Sorpresa s){
        if(!barajada)
            sorpresas.add(s); 
    }
    
    Sorpresa siguiente(){
        if(!barajada || usadas >= sorpresas.size()){
            if(!debug)
                Collections.shuffle(sorpresas);  
        }
        usadas = 0;
        barajada = true;
        
        usadas++;
        Sorpresa sorpresa = sorpresas.get(CERO);
        sorpresas.remove(CERO);
        sorpresas.add(sorpresa);
        return sorpresa;
    }
    
}
