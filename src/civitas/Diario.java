/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;

/**
 *
 * @author Rocío Barragán Moreno
 */
import java.util.ArrayList;

public class Diario{
    
    //singleton
    static final private Diario instance = new Diario();
    private final ArrayList<String> eventos;
  
    static public Diario getInstance(){
        return instance;
    }

    public ArrayList<String> getEventos(){
        return eventos;
    }
  
    private Diario(){
        eventos = new ArrayList<>();
    }
  
    void ocurreEvento(String e){
        eventos.add (e);
    }
  
    public boolean eventosPendientes(){
        return !eventos.isEmpty();
    }
  
    public String leerEvento(){
        String salida = "";
        if (!eventos.isEmpty())
            salida = eventos.remove(0);
        
        return salida;
    }
}