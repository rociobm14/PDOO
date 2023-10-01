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
public class Casilla {
    
    private String nombre;
   
     private void init(){
        nombre = "";
    }
    
    Casilla (String nombre){
        init();
        this.nombre = nombre;
    }
    
    
    public String getNombre(){
        return nombre;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
       informe(iactual, todos);
    }
    
    
    void informe(int iactual, ArrayList <Jugador> todos){
        Diario.getInstance().ocurreEvento(todos.get(iactual).toString());
    }
    
    
    
    public String toString(){
        String cadena = "Acabas de llegar a una casilla de descanso.";
        return cadena;
    }
    
    
}
