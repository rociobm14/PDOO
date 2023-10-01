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
public class SorpresaPagarCobrar extends Sorpresa{
    
    SorpresaPagarCobrar(String texto, int valor){
        super(texto, valor);
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificarSaldo(super.getValor());
    }
    
    
}
