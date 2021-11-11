
package presentacion;

import juegotimbiriche.Jugador;
import socket.Conexion;

/**
 *
 * @author Equipo 5
 */
public class IngresarPartida extends javax.swing.JDialog {
    private juegoTimbiriche juego;
    private Jugador jugador;
    
    public IngresarPartida(java.awt.Frame parent, boolean modal, juegoTimbiriche juego, Jugador jugador) {
        super(parent, modal);
        this.juego= juego;
        this.jugador=jugador;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCodigo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        fondoIngresar = new javax.swing.JPanel();
        fondoCancelar = new javax.swing.JPanel();
        fondo = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 230, -1));

        btnIngresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 130, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 130, 40));

        fondoIngresar.setBackground(new java.awt.Color(3, 152, 158));
        getContentPane().add(fondoIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 130, 40));

        fondoCancelar.setBackground(new java.awt.Color(255, 87, 87));
        getContentPane().add(fondoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 130, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IngresarPartida.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu2.setText("Ayuda");
        menu.add(jMenu2);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        SalaDeEspera partida = new SalaDeEspera((java.awt.Frame) this.getParent(), true, this.juego, this.jugador);
        Conexion.conecta(jugador.getNombre(),"localhost",5001,5000);
        Conexion.getConexion().enviar("JugadorConexion@"+jugador.toString());
        this.dispose();
        partida.setVisible(true);
        partida.setLocationRelativeTo(this);

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MenuJuego partida = new MenuJuego((java.awt.Frame) this.getParent(), true, this.juego, this.jugador);
        this.dispose();
        partida.setVisible(true);
        partida.setLocationRelativeTo(this);
            
    }//GEN-LAST:event_btnCancelarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel fondoCancelar;
    private javax.swing.JPanel fondoIngresar;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menu;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
