/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.views.panel;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Sistemas-03
 */
public class pnlTextEditor extends javax.swing.JPanel {

    /**
     * Creates new form pnlTextEditor
     */
    public pnlTextEditor() {
        initComponents();
    }

    public JLabel getLblLetters() {
        return lblLetters;
    }

    public JLabel getLblLines() {
        return lblLines;
    }

    public JLabel getLblWords() {
        return lblWords;
    }

    public JTextArea getTxtAEditor() {
        return txtAEditor;
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
        lblLines = new javax.swing.JLabel();
        lblLetters = new javax.swing.JLabel();
        lblWords = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAEditor = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(228, 225, 226));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblLines.setText("Lines:");
        jPanel1.add(lblLines);

        lblLetters.setText("Letters:");
        jPanel1.add(lblLetters);

        lblWords.setText("Words:");
        jPanel1.add(lblWords);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        txtAEditor.setColumns(20);
        txtAEditor.setRows(5);
        jScrollPane1.setViewportView(txtAEditor);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLetters;
    private javax.swing.JLabel lblLines;
    private javax.swing.JLabel lblWords;
    private javax.swing.JTextArea txtAEditor;
    // End of variables declaration//GEN-END:variables
}
