/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.ArrayList;

/**
 *
 * @author Rocío Barragán Moreno
 */
public class CasillaSorpresa extends Casilla {
    MazoSorpresas mazo;
    
    CasillaSorpresa(String nombre, MazoSorpresas mazo){
        super(nombre);
        this.mazo = mazo;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
        mazo.siguiente().aplicarAJugador(iactual, todos);
    }
    
    public String toString(){
        String cadena;
        cadena = "Acabas de llegar a una casilla de tipo sorpresa.";
        return cadena;
    }
}
