/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;

/**
 *
 * @author Rocío Barragán Moreno
 */
public class TestP5 {
    
    public static void main(String[] args) {
        
        CivitasView vista = new CivitasView();
        CapturaNombres captura = new CapturaNombres(vista,true);
        
        ArrayList<String> nombres = new ArrayList();
        
        nombres = captura.getNombres();
        
        CivitasJuego juego = new CivitasJuego(nombres,false);
        Controlador controlador = new Controlador(juego,vista);
        
        vista.setCivitasJuego(juego);
        
        controlador.juega();
        
    }
   
    
}
