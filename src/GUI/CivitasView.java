/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import civitas.CivitasJuego;
import civitas.Diario;
import civitas.Casilla;
import civitas.CasillaCalle;
import civitas.CasillaSorpresa;
import civitas.Jugador;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import civitas.Tablero;
import controladorCivitas.Respuesta;
import java.awt.FlowLayout;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JDialog;


import java.util.Arrays;
import java.util.Collections;


/**
 *
 * @author Rocío Barragán Moreno
 */

public class CivitasView extends javax.swing.JFrame implements Vista {
    
    private CivitasJuego juego;
    private ArrayList<CasillaPanel> casillas;
   

    /**
     * Creates new form CivitasView
     */
    public CivitasView() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        casillas = new ArrayList<CasillaPanel>();
        for(int i = 0; i < 20; ++i){ 
        CasillaPanel aux = new CasillaPanel();
        casillas.add(aux);
        }
       FlowLayout layout0 = (FlowLayout)casilla0.getLayout();
        layout0.setVgap(0);
        FlowLayout layout1 = (FlowLayout)casilla1.getLayout();
        layout1.setVgap(0);
        FlowLayout layout2 = (FlowLayout)casilla2.getLayout();
        layout2.setVgap(0);
        FlowLayout layout3 = (FlowLayout)casilla3.getLayout();
        layout3.setVgap(0);
        FlowLayout layout4 = (FlowLayout)casilla4.getLayout();
        layout4.setVgap(0);
        FlowLayout layout5 = (FlowLayout)casilla5.getLayout();
        layout5.setVgap(0);
        FlowLayout layout6 = (FlowLayout)casilla6.getLayout();
        layout6.setVgap(0);
        FlowLayout layout7 = (FlowLayout)casilla7.getLayout();
        layout7.setVgap(0);
        FlowLayout layout8 = (FlowLayout)casilla8.getLayout();
        layout8.setVgap(0);
        FlowLayout layout9 = (FlowLayout)casilla9.getLayout();
        layout9.setVgap(0);
        FlowLayout layout10 = (FlowLayout)casilla10.getLayout();
        layout10.setVgap(0);
        FlowLayout layout11 = (FlowLayout)casilla11.getLayout();
        layout11.setVgap(0);
        FlowLayout layout12 = (FlowLayout)casilla12.getLayout();
        layout12.setVgap(0);
        FlowLayout layout13 = (FlowLayout)casilla13.getLayout();
        layout13.setVgap(0);
        FlowLayout layout14 = (FlowLayout)casilla14.getLayout();
        layout14.setVgap(0);
        FlowLayout layout15 = (FlowLayout)casilla15.getLayout();
        layout15.setVgap(0);
        FlowLayout layout16 = (FlowLayout)casilla16.getLayout();
        layout16.setVgap(0);
        FlowLayout layout17 = (FlowLayout)casilla17.getLayout();
        layout17.setVgap(0);
        FlowLayout layout18 = (FlowLayout)casilla18.getLayout();
        layout18.setVgap(0);
        FlowLayout layout19 = (FlowLayout)casilla19.getLayout();
        layout19.setVgap(0);
        
        //Ponemos en cada casilla del panel las casillas del vector
        casilla0.add(casillas.get(0)); 
        casilla1.add(casillas.get(1));
        casilla2.add(casillas.get(2));
        casilla3.add(casillas.get(3));
        casilla4.add(casillas.get(4));
        casilla5.add(casillas.get(5));
        casilla6.add(casillas.get(6));
        casilla7.add(casillas.get(7));
        casilla8.add(casillas.get(8));
        casilla9.add(casillas.get(9));
        casilla10.add(casillas.get(10));
        casilla11.add(casillas.get(11));
        casilla12.add(casillas.get(12));
        casilla13.add(casillas.get(13));
        casilla14.add(casillas.get(14));
        casilla15.add(casillas.get(15));
        casilla16.add(casillas.get(16));
        casilla17.add(casillas.get(17));
        casilla18.add(casillas.get(18));
        casilla19.add(casillas.get(19));
        repaint();
        revalidate();
        
    }
    
    
    
    void setCivitasJuego(CivitasJuego juego){
        this.juego=juego;
        setVisible(true);
    }
    
    
 public void actualiza() {
     jugadorPanel1.setJugador(juego.getJugadorActual());
     
     
     for(int i = 0; i < 20; ++i){ 
        casillas.get(i).setCasilla(juego.getTablero().getCasilla(i),
                juego.getCasillaActual(), juego.getJugadorActual(),juego.getIndiceJugadorActual());
        
     }
    jScrollPane1.setVisible(false);
     labelRanking.setVisible(false);
     areaRanking.setVisible(false);
     
     
     if(juego.finalDelJuego()){
         areaRanking.setText(juego.mostrarRanking());
         areaRanking.setVisible(true);
         jScrollPane1.setVisible(true);
         labelRanking.setVisible(true);
         
     }
         
         
     repaint();
     revalidate();
    }

           
  public  void pausa() {
      
      int val= JOptionPane.showConfirmDialog(null, "¿Continuar?","Siguiente paso", JOptionPane.YES_NO_OPTION);
        if (val==1) System.exit(0);
  }

 
  
  public Respuesta comprar(){
      
      int opcion= 1-JOptionPane.showConfirmDialog(null, "¿Quieres comprar la calle actual?", "Compra", JOptionPane.YES_NO_OPTION);
    return (Respuesta.values()[opcion]);
  
  }
  
  public OperacionInmobiliaria elegirOperacion(){
     
      OperacionInmobiliaria operacion=null;
      GestionarDialog gestion = new GestionarDialog(this);
      int ngestion = gestion.gestionElegida;
      
     switch(ngestion){
         case 0:
          return OperacionInmobiliaria.CONSTRUIR_CASA;
         case 1:
          return OperacionInmobiliaria.CONSTRUIR_HOTEL;
         case 2:
          return OperacionInmobiliaria.TERMINAR;
         default:
               return null;
     }
     
      
  }
  
  public int elegirPropiedad(){

     PropiedadDialog propiedad= new PropiedadDialog (this, juego.getJugadorActual());
       return propiedad.getPropiedad();
  }
  
  public void mostrarSiguienteOperacion(OperacionJuego operacion){
      siguienteOperacion.setText(operacion.toString());
      if(operacion==operacion.AVANZAR){

      Dado.createInstance(this);
      Dado.getInstance().setVisible(true);
        
      
      }
      repaint();
      
  }
  
  
  
  public void mostrarEventos(){
      if (!Diario.getInstance().getEventos().isEmpty()){
        DiarioDialog diarioD= new DiarioDialog(this); //crea la ventana del diario
      }
  }
  
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jugadorPanel1 = new GUI.JugadorPanel();
        labelOperacion = new javax.swing.JLabel();
        siguienteOperacion = new javax.swing.JTextField();
        labelRanking = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaRanking = new javax.swing.JTextArea();
        casilla0 = new javax.swing.JPanel();
        casilla5 = new javax.swing.JPanel();
        casilla10 = new javax.swing.JPanel();
        casilla15 = new javax.swing.JPanel();
        casilla11 = new javax.swing.JPanel();
        casilla7 = new javax.swing.JPanel();
        casilla2 = new javax.swing.JPanel();
        casilla12 = new javax.swing.JPanel();
        casilla1 = new javax.swing.JPanel();
        casilla6 = new javax.swing.JPanel();
        casilla18 = new javax.swing.JPanel();
        casilla17 = new javax.swing.JPanel();
        casilla19 = new javax.swing.JPanel();
        casilla4 = new javax.swing.JPanel();
        casilla8 = new javax.swing.JPanel();
        casilla3 = new javax.swing.JPanel();
        casilla9 = new javax.swing.JPanel();
        casilla13 = new javax.swing.JPanel();
        casilla14 = new javax.swing.JPanel();
        casilla16 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("C059", 1, 24)); // NOI18N
        titulo.setText("CIVITAS");

        labelOperacion.setText("Siguiente operación:");

        siguienteOperacion.setEditable(false);
        siguienteOperacion.setText("                           ");
        siguienteOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteOperacionActionPerformed(evt);
            }
        });

        labelRanking.setText("Ranking:");

        areaRanking.setEditable(false);
        areaRanking.setColumns(20);
        areaRanking.setRows(5);
        jScrollPane1.setViewportView(areaRanking);

        casilla0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        casilla16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(casilla6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casilla7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casilla8, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casilla9, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casilla10, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(siguienteOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(casilla11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(casilla12, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(casilla13, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(casilla14, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla15, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(casilla17, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(casilla16, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(casilla18, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(casilla19, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(254, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(casilla5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(casilla3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(casilla2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(casilla1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(casilla0, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jugadorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(labelOperacion)
                        .addGap(108, 108, 108)
                        .addComponent(labelRanking))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(titulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(labelOperacion)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelRanking)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(siguienteOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jugadorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(casilla11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(casilla10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(casilla8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(casilla7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(casilla12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(casilla6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(casilla16, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla18, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(casilla19, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(casilla1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(casilla0, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(146, 146, 146))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siguienteOperacionActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaRanking;
    private javax.swing.JPanel casilla0;
    private javax.swing.JPanel casilla1;
    private javax.swing.JPanel casilla10;
    private javax.swing.JPanel casilla11;
    private javax.swing.JPanel casilla12;
    private javax.swing.JPanel casilla13;
    private javax.swing.JPanel casilla14;
    private javax.swing.JPanel casilla15;
    private javax.swing.JPanel casilla16;
    private javax.swing.JPanel casilla17;
    private javax.swing.JPanel casilla18;
    private javax.swing.JPanel casilla19;
    private javax.swing.JPanel casilla2;
    private javax.swing.JPanel casilla3;
    private javax.swing.JPanel casilla4;
    private javax.swing.JPanel casilla5;
    private javax.swing.JPanel casilla6;
    private javax.swing.JPanel casilla7;
    private javax.swing.JPanel casilla8;
    private javax.swing.JPanel casilla9;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.JugadorPanel jugadorPanel1;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel labelRanking;
    private javax.swing.JTextField siguienteOperacion;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables

   

}
