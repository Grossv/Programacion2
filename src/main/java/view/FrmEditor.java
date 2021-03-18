/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.StyleConstants;
import view.views.panel.pnlTextEditor;
import view.ClassImplements.GestionA;

/**
 *
 * @author Usuario
 */
public class FrmEditor extends javax.swing.JFrame {

    private int countTab;
    JFileChooser archivoSeleccionado = new JFileChooser();
    File archivo;
    GestionA gestion = new GestionA();

    /**
     * Creates new form FrmEditor
     */
    public FrmEditor() {
        countTab = 1;
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

        tbpContent = new javax.swing.JTabbedPane();
        try {
            jToolBar1 =(javax.swing.JToolBar)java.beans.Beans.instantiate(getClass().getClassLoader(), "view.FrmEditor_jToolBar1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        btnCloseTab = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mnINew = new javax.swing.JMenuItem();
        mnIOpen = new javax.swing.JMenuItem();
        mnISave = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor de Texto");
        getContentPane().add(tbpContent, java.awt.BorderLayout.CENTER);

        btnCloseTab.setText("X");
        btnCloseTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCloseTab.setFocusable(false);
        btnCloseTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCloseTab);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        mnFile.setText("File");

        mnINew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnINew.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Programacion2\\src\\main\\java\\Source\\imgNew.png")); // NOI18N
        mnINew.setText("New");
        mnINew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnINewActionPerformed(evt);
            }
        });
        mnFile.add(mnINew);

        mnIOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnIOpen.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Programacion2\\src\\main\\java\\Source\\imgOpen.png")); // NOI18N
        mnIOpen.setText("Open...");
        mnIOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnIOpenActionPerformed(evt);
            }
        });
        mnFile.add(mnIOpen);

        mnISave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnISave.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Programacion2\\src\\main\\java\\Source\\imgSave.png")); // NOI18N
        mnISave.setText("Save");
        mnISave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnISaveActionPerformed(evt);
            }
        });
        mnFile.add(mnISave);

        jMenuBar1.add(mnFile);

        mnEdit.setText("Edit");
        jMenuBar1.add(mnEdit);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(816, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnINewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnINewActionPerformed
        pnlTextEditor pnlTextEditor = new pnlTextEditor();
        tbpContent.addTab("Editor" + countTab++, pnlTextEditor);
    }//GEN-LAST:event_mnINewActionPerformed

    private void btnCloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabActionPerformed
        if (tbpContent.getComponentCount() <= 0) {
            return;
        }
        int option = JOptionPane.showInternalConfirmDialog(null, "Are you sure to delete this tab?", "Confirmation dialog", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (option == 1) {
            return;
        }

        int index = tbpContent.getSelectedIndex();
        tbpContent.remove(index);
    }//GEN-LAST:event_btnCloseTabActionPerformed

    private void mnISaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnISaveActionPerformed
        if (archivoSeleccionado.showDialog(null, "Save") == JFileChooser.APPROVE_OPTION) {
            archivo = archivoSeleccionado.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                String contenido = tbpContent.getToolTipText();
                String respuesta = gestion.guardarTexto(archivo, contenido);
                if (respuesta != null) {
                    JOptionPane.showMessageDialog(null, respuesta);
                } else {
                    JOptionPane.showMessageDialog(null, "Error to save the text.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The text should be save in txt format");
            }
        }
    }//GEN-LAST:event_mnISaveActionPerformed

    private void mnIOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnIOpenActionPerformed
        if (archivoSeleccionado.showDialog(null, "Open...") == JFileChooser.APPROVE_OPTION) {
            archivo = archivoSeleccionado.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    String contenido = gestion.abrirTexto(archivo);
//                    txtAEditor.setText(contenido);
                }
            }
        }
    }//GEN-LAST:event_mnIOpenActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEditor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseTab;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuItem mnINew;
    private javax.swing.JMenuItem mnIOpen;
    private javax.swing.JMenuItem mnISave;
    private javax.swing.JTabbedPane tbpContent;
    // End of variables declaration//GEN-END:variables
}
