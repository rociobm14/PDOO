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
public class Jugador implements Comparable<Jugador>{
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    private int casillaActual;
    protected static int HotelesMax = 4;
    private String nombre;
    protected static float PasoPorSalida = 1000;
    private boolean puedeComprar;
    private ArrayList <CasillaCalle> propiedades;
    private float saldo;
    private static float SaldoInicial = 7500;
    
    Jugador(String nombre){
        this.nombre = nombre;
        propiedades = new ArrayList<>();
        casillaActual = 0;
        puedeComprar = false;
        saldo = SaldoInicial;
    }
    
    protected Jugador(Jugador otro){
        casillaActual = otro.casillaActual;
        nombre = otro.nombre;
        puedeComprar = otro.puedeComprar;
        propiedades = otro.propiedades;
        saldo = otro.saldo;    
    }
    
    int cantidadCasasHoteles(){
        int cantidad = 0;
        for (int i=0; i<propiedades.size(); i++)
            cantidad = cantidad + propiedades.get(i).cantidadCasasHoteles();
        
        return cantidad; 
    }
    
    public int compareTo(Jugador otro){
        return Float.compare(saldo, otro.saldo);
    }
    
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        if (puedeComprar){
            float precio = titulo.getPrecioCompra();
            
            if(puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + this +
                        " compra la propiedad " + titulo.getNombre() + ".\n");
                puedeComprar = false;
            }
            
            else
                Diario.getInstance().ocurreEvento("El jugador " + this + 
                        " no tiene saldo para comprar la propiedad " + titulo.getNombre()
                + ".\n");
        }
        
        return result; 
    }
    
    boolean construirCasa(int ip){
        
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        boolean puedoEdificar = false;
        if (existe){
            CasillaCalle propiedad = propiedades.get(ip);
            puedoEdificar = puedoEdificarCasa(propiedad);
            if(puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + 
                " construye casa en su propiedad " + propiedad.getNombre() + 
                        " y queda así:\n" + propiedad.toString() + "\n");
            }
        }
        
        return result;
    }
    
    boolean construirHotel(int ip){
        boolean result = false;
        if (existeLaPropiedad(ip)){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            if (puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + 
                    " construye hotel en su propiedad " + propiedad.getNombre() 
                    + " y queda así:\n" + propiedad.toString()+ "\n");
            }
        }
        return result; 
    }
    
    boolean enBancarrota(){
        return(saldo < 0);  
    }
    
    private boolean existeLaPropiedad(int ip){
        return(ip >= 0 && ip < propiedades.size());
    }
    
    protected int getCasasMax(){
        return CasasMax;
    }
    
    static int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    //lo he cambiado de paquete a public
    public int getCasillaActual(){
        return casillaActual;
    }
    
    protected int getHotelesMax(){
        return HotelesMax;
    }
    
    //Lo he cambiado de protected a public para que se pueda acceder 
    //a él desde otras clases de otros paquetes. Si es protected no 
    //se puede
    public String getNombre(){
        return nombre;
    }
    
    private static float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    public ArrayList <CasillaCalle> getPropiedades(){
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    //Lo he cambiado también a public por lo mismo
    public float getSaldo(){
        return saldo;
    }
    
    boolean modificarSaldo(float cantidad){
        float saldoModificado = saldo + cantidad;
        Diario.getInstance().ocurreEvento("El saldo de " + nombre +
                " fue modificado de " 
                + saldo + " a " + saldoModificado + ".\n");
        saldo+=cantidad;
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        puedeComprar = false;
        int casillaActualMasUno = casillaActual+1;
        int numCasillaMasUno = numCasilla+1;
        Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " se ha movido de la casilla " 
                + casillaActualMasUno + " a la casilla " + numCasillaMasUno + ".\n");
        casillaActual = numCasilla;
        return true;
    }
    
    boolean paga(float cantidad){
        return(modificarSaldo(cantidad * -1));
    }
    
    boolean pagaAlquiler(float cantidad){
        return paga(cantidad); 
    }
    
    boolean pasaPorSalida(){
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento("Un jugador ha pasado por la casilla de salida y ha"
                + " recibido la cantidad de " + PasoPorSalida + ".\n");
        return true;
    }
    
    boolean puedeComprarCasilla(){
        return(puedeComprar = true); 
    }
    
    private boolean puedoEdificarCasa(CasillaCalle propiedad){
         boolean puedoEdificar = false;
        
        if ( (puedoGastar(propiedad.getPrecioEdificar())) 
                && (Jugador.CasasMax > propiedad.getNumCasas())
                && (propiedad.getNumHoteles() < Jugador.HotelesMax))
            puedoEdificar = true;
        else
            Diario.getInstance().ocurreEvento("\nNo has podido construir la casa "
                    + "por uno de los siguientes motivos: \n"
                    + "- No tienes dinero suficiente.\n"
                    + "- Has superado el número máximo de casas.\n"
                    + "- Has superado el número máximo de hoteles.\n");   
        return puedoEdificar;
    }
    
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        boolean puedoEdificar = false;
        
        if ( (puedoGastar(propiedad.getPrecioEdificar())) 
                && (Jugador.HotelesMax > propiedad.getNumHoteles())
                && (Jugador.CasasPorHotel == propiedad.getNumCasas()) )
            puedoEdificar = true;
        else
            Diario.getInstance().ocurreEvento("\nNo has podido construir el hotel "
                    + "por uno de los siguientes motivos: \n"
                    + "- No tienes dinero suficiente.\n"
                    + "- Has superado el número máximo de hoteles.\n"
                    + "- No tienes casas suficientes para construir un hotel. "
                    + "Necesitas al menos " + CasasPorHotel + " casas para "
                            + "construir uno.\n");
        return puedoEdificar;
    }
    
    
    boolean puedoGastar(float precio){
        return(saldo >= precio);
    }
    
    boolean recibe(float cantidad){
        return(modificarSaldo(cantidad));
    }
    
    boolean tieneAlgoQueGestionar(){
      boolean tieneAlgo = true;
        if (propiedades.isEmpty())
            tieneAlgo = false;
        return tieneAlgo;
        
        
    }
    
    protected JugadorEspeculador convertir(){
        JugadorEspeculador especulador = new JugadorEspeculador(this);
        return especulador;
    }
    
    public boolean esEspeculador(){
        return false;
    }
    
    public String toString(){
        String cadena = "Casilla actual: " + casillaActual +
                        "\nNombre del jugador: " + nombre +
                         "\nSaldo: " + saldo + "\n";
        return cadena;
    }
    
    
    
    
    
   
    
    
    
}
