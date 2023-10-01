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
public class CasillaCalle extends Casilla {
    
    private static float FACTORALQUILERCALLE = 1.0f;
    private static float FACTORALQUILERCASA = 1.0f;
    private static float FACTORALQUILERHOTEL = 4.0f;
    private int numCasas;
    private int numHoteles;
    private float precioAlquilerBase;
    private float precioCompra;
    private float precioEdificar;
    Jugador propietario;
    
    private void init(){
        propietario = null;
        numCasas = 0;
        numHoteles = 0;
    }
    
    CasillaCalle(String nombre, float precioCompra, float precioEdificar, 
            float precioAlquilerBase){
        super(nombre);
        init();
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioAlquilerBase = precioAlquilerBase;
    }
    
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
        Jugador jugador = todos.get(iactual);
        
        if (!tienePropietario())
            jugador.puedeComprarCasilla();
        
        else
            tramitarAlquiler(jugador); 
        
    }
    
    public String ToString(){
        
        String cadena;
        if (this.tienePropietario()){
            cadena = "\nEl propietario de esta casilla es " + propietario.getNombre()+ "."
                    + "\nAlquiler base: " + precioAlquilerBase
                    + "\nCasas: " + numCasas
                    + "\nHoteles: " + numHoteles;
        }
        
        else 
            cadena = "\nEsta Casilla no tiene propietario";
        
        String otra_cadena = "\nAcabas de llegar a la siguiente casilla:" +
                    "\nNombre de la casilla: " + super.getNombre() + 
                    "\n---- Precios: ----" +
                    "\n- Compra: " + precioCompra + 
                    "\n- Edificar: " + precioEdificar +
                    "\n- Alquiler base: " + precioAlquilerBase +
                    "\n------------------" +
                    "\nCasas: " + numCasas + 
                    "\nHoteles: " + numHoteles + "\n";
        
        return cadena + otra_cadena;  
    }
    
    public int cantidadCasasHoteles(){
        return (numCasas + numHoteles);
    }
    
    boolean comprar(Jugador jugador){
        propietario = jugador;
        return propietario.paga(precioCompra);
    }
    
    boolean construirCasa(Jugador jugador){
        jugador.paga(precioEdificar);
        numCasas++;
        return true;
    }
    
    boolean construirHotel(Jugador jugador){
        jugador.paga(precioEdificar);
        numHoteles++;
        return true; 
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        return(jugador == propietario);
    }
    
    //no lo he modificado
    boolean derruirCasas(int numero, Jugador jugador){
        
        boolean seRealizaOperacion = false;
        if(esEsteElPropietario(jugador) && numCasas >= numero){
            numCasas = numCasas - numero;  
            seRealizaOperacion = true;
        }
        
        return seRealizaOperacion;
       
    }
    
    public float getPrecioAlquilerCompleto(){
        
        float precioAlquilerCompleto = precioAlquilerBase * 
                (FACTORALQUILERCASA + numCasas + 
                (numHoteles * FACTORALQUILERHOTEL));
        return precioAlquilerCompleto; 
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }
    
     public int getNumCasas(){
        return numCasas;
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    
    public boolean tienePropietario(){
        boolean tiene = false;
        
        if (propietario != null)
            tiene = true;
        return tiene;
    }
    
    
    public void tramitarAlquiler(Jugador jugador){
        if(tienePropietario() && !(esEsteElPropietario(jugador))){
            jugador.pagaAlquiler(getPrecioAlquilerCompleto());
             Diario.getInstance().ocurreEvento(jugador.getNombre() + " tiene que"
            + " pagar al propietario "+ propietario.getNombre() + " " + getPrecioAlquilerCompleto() + 
                     " euros.\n");
            propietario.recibe(getPrecioAlquilerCompleto()); 
        }
    }
    
    void actualizaPropietarioPorConversion(Jugador j){
        this.propietario=j;
    }
     
    
}
