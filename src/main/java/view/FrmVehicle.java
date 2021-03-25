/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.PnlVehicleController;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import javax.swing.JComponent;
import view.views.panel.PnlVehicle;

/**
 *
 * @author Sistemas-03
 */
public class FrmVehicle extends javax.swing.JFrame {

    private PnlVehicle pnlVehicle;
    private PnlVehicleController pnlVehicleController;

    /**
     * Creates new form FrmVehicle
     */
    public FrmVehicle() {
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlButtom = new javax.swing.JPanel();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vehicle App");

        jSplitPane1.setOneTouchExpandable(true);

        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);

        btnView.setText("View");
        jPanel1.add(btnView);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlButtomLayout = new javax.swing.GroupLayout(pnlButtom);
        pnlButtom.setLayout(pnlButtomLayout);
        pnlButtomLayout.setHorizontalGroup(
            pnlButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        pnlButtomLayout.setVerticalGroup(
            pnlButtomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(pnlButtom, java.awt.BorderLayout.PAGE_START);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setForeground(new java.awt.Color(204, 204, 204));
        pnlContent.setLayout(new java.awt.BorderLayout());
        jPanel2.add(pnlContent, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(773, 557));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            if (pnlVehicle == null) {
                pnlVehicle = new PnlVehicle();
                pnlVehicleController = new PnlVehicleController(pnlVehicle);
            }
        } catch (FileNotFoundException error) {
        }
        
        addComponent(pnlVehicle);
    }//GEN-LAST:event_btnNewActionPerformed

    private void addComponent(JComponent component){
        pnlContent.removeAll();
        pnlContent.add(component,BorderLayout.CENTER);
        pnlContent.repaint();
        this.validate();
    }
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
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVehicle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVehicle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pnlButtom;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}
