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
public abstract class Sorpresa {
    private String texto;
    int valor;
    
    Sorpresa(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    
    void informe(int actual, ArrayList <Jugador> todos){
        
        Diario.getInstance().ocurreEvento("Se está aplicando una sorpresa al jugador " + todos.get(actual).getNombre() + ".\n");
        Diario.getInstance().ocurreEvento("La sorpresa es: " + texto + "\n");
        
    }
    
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);
    
    
    public String toString(){
        return texto;
    }
    
    protected int getValor(){
        return valor;
    }
    
}
