
package presentacion;

import control.Control;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juegotimbiriche.Juego;
import juegotimbiriche.Jugador;
import juegotimbiriche.Tablero;

/**
 *
 * @author Equipo 5
 */
public class SalaDeEspera extends javax.swing.JDialog {
    
    private juegoTimbiriche juego;
    private Juego partida;
    private static JPanel[] paneles=new JPanel[4];
    private static JLabel[] nombres=new JLabel[4];
    
    public SalaDeEspera(java.awt.Frame parent, boolean modal, juegoTimbiriche juego, Jugador jugador1) {
        super(parent, modal);
        this.juego= juego;
        initComponents();
        this.partida= new Juego(new Tablero("10x10"));
        this.partida.getJugadores()[0]=jugador1;
        Control control= Control.getControl();
        setLocationRelativeTo(null);
        fondoJugador1.setBackground(new Color(jugador1.getColor()[0], jugador1.getColor()[1], jugador1.getColor()[2]));
        nombreJugador1.setText(jugador1.getNombre());
        paneles[0]=fondoJugador1;
        paneles[1]=fondoJugador2;
        paneles[2]=fondoJugador3;
        paneles[3]=fondoJugador4;
        nombres[0]=nombreJugador1;
        nombres[1]=nombreJugador2;
        nombres[2]=nombreJugador3;
        nombres[3]=nombreJugador4;
        //SimuladorThread t= new SimuladorThread(this,control);
        //t.start();
    }
    
    public SalaDeEspera(java.awt.Frame parent, boolean modal, juegoTimbiriche juego, Jugador[] jugadores){
        super(parent, modal);
        this.juego= juego;
        initComponents();
        this.partida= new Juego(new Tablero("10x10"));
        this.partida.getJugadores()[0]=jugadores[0];
        this.partida.getJugadores()[1]=jugadores[1];
        this.partida.getJugadores()[2]=jugadores[2];
        this.partida.getJugadores()[3]=jugadores[3];
         paneles[0]=fondoJugador1;
        paneles[1]=fondoJugador2;
        paneles[2]=fondoJugador3;
        paneles[3]=fondoJugador4;
        nombres[0]=nombreJugador1;
        nombres[1]=nombreJugador2;
        nombres[2]=nombreJugador3;
        nombres[3]=nombreJugador4;
        setLocationRelativeTo(null);
        mostrarJugadores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        fondoJugador1 = new javax.swing.JPanel();
        nombreJugador1 = new javax.swing.JLabel();
        fondoJugador2 = new javax.swing.JPanel();
        nombreJugador2 = new javax.swing.JLabel();
        fondoJugador3 = new javax.swing.JPanel();
        nombreJugador3 = new javax.swing.JLabel();
        fondoJugador4 = new javax.swing.JPanel();
        nombreJugador4 = new javax.swing.JLabel();
        fondoCancelar = new javax.swing.JPanel();
        fondoIngresar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 130, 40));

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 130, 40));

        nombreJugador1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombreJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador1.setText("Esperando jugador...");
        nombreJugador1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout fondoJugador1Layout = new javax.swing.GroupLayout(fondoJugador1);
        fondoJugador1.setLayout(fondoJugador1Layout);
        fondoJugador1Layout.setHorizontalGroup(
            fondoJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );
        fondoJugador1Layout.setVerticalGroup(
            fondoJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoJugador1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(nombreJugador1)
                .addGap(45, 45, 45))
        );

        getContentPane().add(fondoJugador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 260, 110));

        nombreJugador2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombreJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador2.setText("Esperando jugador...");

        javax.swing.GroupLayout fondoJugador2Layout = new javax.swing.GroupLayout(fondoJugador2);
        fondoJugador2.setLayout(fondoJugador2Layout);
        fondoJugador2Layout.setHorizontalGroup(
            fondoJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJugador2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
        fondoJugador2Layout.setVerticalGroup(
            fondoJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJugador2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(nombreJugador2)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        getContentPane().add(fondoJugador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        nombreJugador3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombreJugador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador3.setText("Esperando jugador...");
        nombreJugador3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout fondoJugador3Layout = new javax.swing.GroupLayout(fondoJugador3);
        fondoJugador3.setLayout(fondoJugador3Layout);
        fondoJugador3Layout.setHorizontalGroup(
            fondoJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJugador3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreJugador3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
        fondoJugador3Layout.setVerticalGroup(
            fondoJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoJugador3Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(nombreJugador3)
                .addGap(45, 45, 45))
        );

        getContentPane().add(fondoJugador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        nombreJugador4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        nombreJugador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador4.setText("Esperando jugador...");

        javax.swing.GroupLayout fondoJugador4Layout = new javax.swing.GroupLayout(fondoJugador4);
        fondoJugador4.setLayout(fondoJugador4Layout);
        fondoJugador4Layout.setHorizontalGroup(
            fondoJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoJugador4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreJugador4, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );
        fondoJugador4Layout.setVerticalGroup(
            fondoJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoJugador4Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(nombreJugador4)
                .addGap(46, 46, 46))
        );

        getContentPane().add(fondoJugador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        fondoCancelar.setBackground(new java.awt.Color(255, 87, 87));
        getContentPane().add(fondoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 130, 40));

        fondoIngresar.setBackground(new java.awt.Color(3, 152, 158));
        getContentPane().add(fondoIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 130, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SalaDeEspera.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jMenu2.setText("Ayuda");
        menu.add(jMenu2);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        agregarCantJugadores();
        
        this.dispose();
        presentacion.DlgTablero partida = new DlgTablero((java.awt.Frame) this.getParent(), true, this.juego, this.partida);
        partida.setVisible(true);
        partida.setLocationRelativeTo(this);

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        MenuJuego partida = new MenuJuego((java.awt.Frame) this.getParent(), true, this.juego, this.partida.getJugadores()[0]);
        partida.setVisible(true);
        partida.setLocationRelativeTo(this);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

   public void mostrarJugadores(){
        fondoJugador1.setBackground(new Color(partida.getJugadores()[0].getColor()[0], partida.getJugadores()[0].getColor()[1], partida.getJugadores()[0].getColor()[2]));
        nombreJugador1.setText(partida.getJugadores()[0].getNombre());
        
        fondoJugador2.setBackground(new Color(partida.getJugadores()[1].getColor()[0], partida.getJugadores()[1].getColor()[1], partida.getJugadores()[1].getColor()[2]));
        nombreJugador2.setText(partida.getJugadores()[1].getNombre());

        fondoJugador3.setBackground(new Color(partida.getJugadores()[2].getColor()[0], partida.getJugadores()[2].getColor()[1], partida.getJugadores()[2].getColor()[2]));
        nombreJugador3.setText(partida.getJugadores()[2].getNombre());

        fondoJugador4.setBackground(new Color(partida.getJugadores()[3].getColor()[0], partida.getJugadores()[3].getColor()[1], partida.getJugadores()[3].getColor()[2]));
        nombreJugador4.setText(partida.getJugadores()[3].getNombre());
    }

    public static void Conecta(ArrayList jugadores){
    int i=0;
        Jugador[] jugadors=Juego.getJugadores();
        for (Iterator iterator = jugadores.iterator(); iterator.hasNext();) {
            Jugador next = (Jugador)iterator.next();
            
            paneles[i].setBackground(new Color(next.getColor()[0], next.getColor()[1], next.getColor()[2]));
            nombres[i].setText(next.getNombre());   
            paneles[i].repaint();
            jugadors[i]=next;
            i++;
            System.out.println(next);
            
        }
        Juego.setJugador(jugadors);
}
    public void mostrarJugadores(int numero){
        switch(numero){
            case 2: 
                fondoJugador2.setBackground(new Color(partida.getJugadores()[1].getColor()[0], partida.getJugadores()[1].getColor()[1], partida.getJugadores()[1].getColor()[2]));
                nombreJugador2.setText(partida.getJugadores()[1].getNombre());
                break;
            case 3: 
                fondoJugador3.setBackground(new Color(partida.getJugadores()[2].getColor()[0], partida.getJugadores()[2].getColor()[1], partida.getJugadores()[2].getColor()[2]));
                nombreJugador3.setText(partida.getJugadores()[2].getNombre());
                break; 
            case 4: 
                fondoJugador4.setBackground(new Color(partida.getJugadores()[3].getColor()[0], partida.getJugadores()[3].getColor()[1], partida.getJugadores()[3].getColor()[2]));
                nombreJugador4.setText(partida.getJugadores()[3].getNombre());
                break;
        }
        
    }
    
    public void agregarCantJugadores(){
        int cantJugadores=0;
        for (int i =0; i<4; i++) {
            if(partida.getJugadores()[i]!=null){
                cantJugadores++;
            }
        }
        partida.setNumJugadores(cantJugadores);
    }
    
    public class SimuladorThread extends Thread{
        
        private SalaDeEspera sala;
        private Control control;
        
        public SimuladorThread(SalaDeEspera sala, Control control){
            this.sala=sala;
            this.control=control;
        }
        
        @Override
        public void run(){
            for(int i=0; i<3;i++){
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SalaDeEspera.class.getName()).log(Level.SEVERE, null, ex);
                }
                switch(i){
                    case 0: 
                        partida.getJugadores()[1]= control.crearJugador("Andrés", "Azul");
                        sala.mostrarJugadores(2);
                        break;
                    case 1: 
                        partida.getJugadores()[2]= control.crearJugador("Michelle", "Rojo");
                        sala.mostrarJugadores(3);
                        break; 
                    case 2: 
                        partida.getJugadores()[3]= control.crearJugador("Clarisa", "Amarillo");
                        sala.mostrarJugadores(4);
                        break;
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JPanel fondoCancelar;
    private javax.swing.JPanel fondoIngresar;
    private javax.swing.JPanel fondoJugador1;
    private javax.swing.JPanel fondoJugador2;
    private javax.swing.JPanel fondoJugador3;
    private javax.swing.JPanel fondoJugador4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menu;
    private static javax.swing.JLabel nombreJugador1;
    private static javax.swing.JLabel nombreJugador2;
    private static javax.swing.JLabel nombreJugador3;
    private static javax.swing.JLabel nombreJugador4;
    // End of variables declaration//GEN-END:variables
    
}
