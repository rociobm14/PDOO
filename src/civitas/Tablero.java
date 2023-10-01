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
public class Tablero {
    
    static private int CASILLAINICIAL = 0;
    static private int CASILLAFINAL = 20;
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    
    public Tablero(){
        casillas = new ArrayList<>();
        Casilla salida = new Casilla("Salida");
        casillas.add(salida);
        porSalida = false;
    }
    
    private boolean correcto(int numCasilla){
        return(numCasilla >= CASILLAINICIAL && numCasilla < CASILLAFINAL);
    }
    
    boolean computarPasoPorSalida(){
        return porSalida = false;
    }
    
    void añadeCasilla(Casilla casilla){
        casillas.add(casilla);
    } 
    
    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }
    
    //Lo he cambiado de paquete a public
    public Casilla getCasilla(int numCasilla){
        if (correcto(numCasilla))
            return casillas.get(numCasilla);
        else
            return null;
    }
    
    int nuevaPosicion(int actual, int tirada){
        int nuevaPosicion = (actual + tirada) % CASILLAFINAL;
        
        if(nuevaPosicion == CASILLAINICIAL)
            porSalida = true;
        
        return nuevaPosicion;
    }
      
    
}
