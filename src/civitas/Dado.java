/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package civitas;
import java.util.Random;

/**
 *
 * @author Rocío Barragán Moreno
 */

public class Dado {
    private final static int UNO = 1;
    private final static int SEIS = 6;
    static final private Dado instance = new Dado();
    private final Random random;
    private int ultimoResultado;
    private boolean debug;
    
    private Dado(){
        random = new Random();
        ultimoResultado = random.nextInt(SEIS-UNO)+SEIS;
        debug = false;     
    }
    
    static public Dado getInstance(){
        return instance;
    }
    
    public int tirar(){
        if(!debug)
            ultimoResultado = random.nextInt(SEIS)+UNO;
        else
            ultimoResultado = UNO;
        
        return ultimoResultado;
    }
    
    public int quienEmpieza(int n){
        return random.nextInt(n);
    }
    
    public void setDebug(boolean d){
        debug = d;
        Diario.getInstance().ocurreEvento("El dado se ha puesto en modo" + debug);
    }
    
    public int getUltimoResultado(){
        return ultimoResultado;    
    } 
    
}
