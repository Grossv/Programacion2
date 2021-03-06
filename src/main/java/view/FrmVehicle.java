/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import backend.dao.implementation.JsonVehicleDaoImpl;
import backend.dao.implementation.VehicleTableModel;
import controllers.PnlVehicleController;
import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JComponent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import pojo.Vehicle;
import view.views.panel.PnlVehicle;
import view.views.panel.PnlVehicleView;


/**
 *
 * @author Usuario
 */
public class FrmVehicle extends javax.swing.JFrame {

    private PnlVehicle pnlVehicle;
    private PnlVehicleView pnlVehicleView;
    private PnlVehicleController pnlVehicleController;
    private VehicleTableModel vehicleTableModel;
    
    private JsonVehicleDaoImpl jsonVehicleDaoImpl;

    /**
     * Creates new form FrmVehicles
     */
    public FrmVehicle(){
        initComponents();  
        try {
            jsonVehicleDaoImpl = new JsonVehicleDaoImpl();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlBottom = new javax.swing.JPanel();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vehicle App");

        jSplitPane1.setDividerLocation(140);
        jSplitPane1.setDividerSize(15);
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
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel1.add(btnView);

        btnReport.setText("Report");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        jPanel1.add(btnReport);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        pnlBottom.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(pnlBottom, java.awt.BorderLayout.PAGE_START);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setLayout(new java.awt.BorderLayout());
        jPanel2.add(pnlContent, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(712, 598));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        try {
            if (pnlVehicle == null) {
                pnlVehicle = new PnlVehicle();
                pnlVehicleController = new PnlVehicleController(pnlVehicle);
            }
        } catch (FileNotFoundException ex) {
        }

        addComponent(pnlVehicle);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        try {
            if (pnlVehicleView == null) {
                pnlVehicleView = new PnlVehicleView();
//                pnlVehicleController = new PnlVehicleController(pnlVehicleView);
            }
        } catch (Exception ex) {
        }
        
        addComponent(pnlVehicleView);
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        List<Vehicle> vehicles;
        try {
            vehicles = jsonVehicleDaoImpl.getAll().stream().collect(Collectors.toList());
            JRBeanCollectionDataSource collection = new JRBeanCollectionDataSource(vehicles);
        String fileName = getClass().getResource("/reports/VehicleReport.jasper").getPath();
        
        JasperPrint print = JasperFillManager.fillReport(fileName, null, collection);
        JasperViewer viewer = new JasperViewer(print);
        viewer.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(FrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(FrmVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnReportActionPerformed

    private void addComponent(JComponent component) {
        pnlContent.removeAll();
        pnlContent.add(component, BorderLayout.CENTER);
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
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnView;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlContent;
    // End of variables declaration//GEN-END:variables
}
