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
public class CivitasJuego {
    private final int NUM_MAXJUGADORES = 4;
    private int indiceJugadorActual;
    private ArrayList <Jugador> jugadores;
    private EstadoJuego estado;
    private GestorEstados gestor;
    MazoSorpresas mazo;
    Tablero tablero;
    
    private void avanzaJugador(){
        
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        Diario.getInstance().ocurreEvento(jugadorActual.getNombre() + 
                " ha sacado un " + tirada + ".");
        contabilizarPasosPorSalida();
        jugadorActual.moverACasilla(posicionNueva);
        Diario.getInstance().ocurreEvento("\n" + casilla.toString() + "\n");
        casilla.recibeJugador(indiceJugadorActual, jugadores);
    }
    
    public CivitasJuego(ArrayList <String> nombres, boolean debug){
        
        if (nombres.size() <= NUM_MAXJUGADORES){
            jugadores = new ArrayList();
            
            for (int i=0; i<nombres.size(); i++)
                jugadores.add(new Jugador(nombres.get(i)));
            
            gestor = new GestorEstados();
            estado = gestor.estadoInicial();
            Dado.getInstance().setDebug(debug);
            indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
            System.out.println("Comienza el juego Civitas. El primer turno es para el jugador " + 
                jugadores.get(indiceJugadorActual).getNombre() + ".\n");
            mazo = new MazoSorpresas(debug);
            tablero = new Tablero();
            inicializaMazoSorpresas();
            inicializaTablero(mazo);
        }
        
        else{
            System.err.println("El número máximo de jugadores permitidos es " + 
                    NUM_MAXJUGADORES + ".\n");
            System.exit(1);
        }
    }
    
    public boolean comprar(){
        boolean res;
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        CasillaCalle casilla = (CasillaCalle)tablero.getCasilla(numCasillaActual);
        res = jugadorActual.comprar(casilla);
        return res;
    }
    
    public boolean construirCasa(int ip){
        return getJugadorActual().construirCasa(ip);  
    }
    
    public boolean construirHotel(int ip){
        return getJugadorActual().construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida(){
        if(tablero.computarPasoPorSalida()){
            getJugadorActual().pasaPorSalida();
        } 
    }
    
    public boolean finalDelJuego(){
        boolean bancarrota = false;
        
        for (int i=0; i<jugadores.size() && !bancarrota ; i++){
            if(jugadores.get(i).enBancarrota())
                bancarrota = true;
        }
        
        return bancarrota;
    }
    
    public Casilla getCasillaActual(){
        return tablero.getCasilla(jugadores.get(indiceJugadorActual).getCasillaActual());
    }
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList <Jugador> getJugadores(){
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    //lo arreglo en la p3
    private void inicializaMazoSorpresas(){
        mazo.alMazo(new SorpresaPagarCobrar("Se te ha multado por"
                    + " evasión de impuestos, paga 1000.", -1000));
        
        mazo.alMazo(new SorpresaPagarCobrar("Has ganado la lotería, "
                    + "recibes 800.", 800));
        
        mazo.alMazo(new SorpresaPagarCobrar("Debido a la inflación, "
                    + "recibes 550.", 550));
        
        mazo.alMazo(new SorpresaPagarCobrar("Se te ha multado por"
                    + " exceso de velocidad, pagas 1200.", -1200));
        
        mazo.alMazo(new SorpresaPorCasaHotel("Tus bienes han sido "
                    + "revalorizados, recibes 60 por cada casa u hotel.", 60));
        
        mazo.alMazo(new SorpresaPorCasaHotel("Una inspección ha "
        + "detectado fugas de gas en tus construcciones, pagas 100 por cada "
        + "construcción.", -100));
        
        mazo.alMazo(new SorpresaPorCasaHotel("Te ha llegado el "
                  + "recibo del IBI, paga 80 por cada casa u hotel.", -80));
        
        mazo.alMazo(new SorpresaPorCasaHotel("El Colegio de "
        + "Arquitectos te ha premiado por tener las mejores construcciones, "
        + "recibes 20 por cada casa u hotel.", 20));
    }
    
    //lo arreglo en la p3
    private void inicializaTablero(MazoSorpresas mazo){
        //Casilla de salida ya agregada (se agrega en el constructor de tablero)
        tablero.añadeCasilla(new CasillaCalle("Velázquez", 60f, 30f, 20f));
        tablero.añadeCasilla(new CasillaCalle("Salamanca", 80f, 40f, 27f));
        tablero.añadeCasilla(new CasillaCalle("Castellana", 100f, 50f, 33f));
        tablero.añadeCasilla(new CasillaCalle("Tirso de M.", 120f, 60f, 40f));
        tablero.añadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Lavapiés", 140f, 70f, 47f));
        tablero.añadeCasilla(new CasillaCalle("Goya", 150f, 75f, 50f));
        tablero.añadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Mataelpino", 200f, 100f, 67f));
        tablero.añadeCasilla(new Casilla("Puro Relax"));
        tablero.añadeCasilla(new CasillaCalle("Leganitos", 220f, 110f, 73f));
        tablero.añadeCasilla(new CasillaCalle("Serrano", 240f, 120f, 80f));
        tablero.añadeCasilla(new CasillaCalle("P. del Prado", 260f, 130f, 87f));
        tablero.añadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("Valdelatas", 280f, 140f, 93f));
        tablero.añadeCasilla(new CasillaCalle("Méndez A.", 300f, 150f, 100f));
        tablero.añadeCasilla(new CasillaSorpresa("Sorpresa", mazo));
        tablero.añadeCasilla(new CasillaCalle("O`Donell", 350f, 175f, 117f));
        tablero.añadeCasilla(new CasillaCalle("San Jerónimo", 400f, 200f, 133f));
    }
    
    private void pasarTurno(){
        if(indiceJugadorActual==(jugadores.size()-1))
            indiceJugadorActual=0;
        
        else
            indiceJugadorActual++;
    }
   
    //no lo he modificado
    public ArrayList<Jugador> ranking(){
       Collections.sort(jugadores, Collections.reverseOrder());
       return jugadores;
    }
    
     public String mostrarRanking(){
        ArrayList<Jugador> rank = ranking();
        String ranking = "";
        
        //El ranking se ordena de menos a más, por tanto,
        //imprimimos el ArrayList al revés, para que a nivel de usuario,
        //aparezca de más a menos
        int posicion = 1;
        for (int i = 3; i >= 0; i--){
            ranking += "\n" + posicion + "º) " + rank.get(i).getNombre() 
                    + " (Saldo: " + rank.get(i).getSaldo() + ")" + "\n";
            posicion++;
        }
        
        return ranking;
    }    
    
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugadorActual, estado);
        
        if (operacion == OperacionJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        }
        
        else if (operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        
        return operacion;
        
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estado = gestor.siguienteEstado(getJugadorActual(), estado, operacion);
    }
}
