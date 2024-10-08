/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formulario;

/**
 *
 * @author Ruben
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        DpFormulario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuCliente = new javax.swing.JMenuItem();
        jMenuProducto = new javax.swing.JMenuItem();
        jMenuProveedor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DpFormulario.setFont(new java.awt.Font("Segoe UI Emoji", 0, 48)); // NOI18N
        DpFormulario.setForeground(new java.awt.Color(153, 153, 255));
        DpFormulario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DpFormulario.setText("Rubefact");

        jDesktopPane1.setLayer(DpFormulario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DpFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DpFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
        );

        jMenu1.setText("Vender");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Venta");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Administracion");

        jMenuCliente.setText("Clientes");
        jMenuCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuClienteMouseClicked(evt);
            }
        });
        jMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuCliente);

        jMenuProducto.setText("Productos");
        jMenuProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuProductoMouseClicked(evt);
            }
        });
        jMenuProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProductoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuProducto);

        jMenuProveedor.setText("Proveedores");
        jMenuProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProveedorActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuProveedor);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Informes");

        jMenuItem3.setText("Buscar por Comprobante");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Buscar por Fecha");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Salir");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       /* Formulario.ForVentas objetoFormularioVenta = new Formulario.ForVentas();
        PanelForemularios.add(objetoFormularioVenta);
        objetoFormularioVenta.setVisible(true);
         
    Al FORMULARIO VENTAS SE AGREGO UN PANEL , CON EL NOMBRE DE PANELFORMULARIO,
        SE INTRODUJO EL OBJETOFORMULARIO Y SE LO HIZO VISIBLE
         */        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuClienteMouseClicked
        Formulario.ForClientes objetoFormularioCliente = new Formulario.ForClientes();
       DpFormulario.add(objetoFormularioCliente);
        objetoFormularioCliente.setVisible(true);
    }//GEN-LAST:event_jMenuClienteMouseClicked

    private void jMenuProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuProductoMouseClicked
        Formulario.ForProducto objetoFormularioProducto = new Formulario.ForProducto();
        DpFormulario.add(objetoFormularioProducto);
        objetoFormularioProducto.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuProductoMouseClicked

    private void jMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClienteActionPerformed
        Formulario.ForClientes objetoFormularioCliente = new Formulario.ForClientes();
        DpFormulario.add(objetoFormularioCliente);
        objetoFormularioCliente.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuClienteActionPerformed

    private void jMenuProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProductoActionPerformed
        Formulario.ForProducto objetoFormularioProducto = new Formulario.ForProducto();
        DpFormulario.add(objetoFormularioProducto);
        objetoFormularioProducto.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuProductoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Formulario.ForBuscarComprobante objetoFormularioBuscarComprobante = new Formulario.ForBuscarComprobante();
        DpFormulario.add(objetoFormularioBuscarComprobante);
        objetoFormularioBuscarComprobante.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Formulario.ForBuscarPorFecha objetoFormularioBuscarPoFecha = new Formulario.ForBuscarPorFecha();
        DpFormulario.add(objetoFormularioBuscarPoFecha);
        objetoFormularioBuscarPoFecha.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        System.exit(0);

// TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
System.exit(0);        
// TODO add your handling code here:
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
         Formulario.ForVentas objetoFormularioVenta = new Formulario.ForVentas();
        DpFormulario.add(objetoFormularioVenta);
        objetoFormularioVenta.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
       Formulario.ForVentas objetoFormularioVenta = new Formulario.ForVentas();
        DpFormulario.add(objetoFormularioVenta);
        objetoFormularioVenta.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5MouseClicked

    private void jMenuProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProveedorActionPerformed
          Formulario.ForProveedores objetoFormularioProveedor = new Formulario.ForProveedores();
          DpFormulario.add(objetoFormularioProveedor);
        objetoFormularioProveedor.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jMenuProveedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DpFormulario;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCliente;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuProducto;
    private javax.swing.JMenuItem jMenuProveedor;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
