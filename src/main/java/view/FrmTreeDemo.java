/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.FrmTreeController;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;


/**
 *
 * @author Sistemas-03
 */
public class FrmTreeDemo extends javax.swing.JFrame {

    private FrmTreeController frmTreeController;
    /**
     * Creates new form FrmTreeDemo
     */
    public FrmTreeDemo() {
        initComponents();
        frmTreeController = new FrmTreeController(this);
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JTree getTreeAcount() {
        return treeAcount;
    }

    public JPopupMenu getPmnTree() {
        return pmnTree;
    }

    public JMenuItem getMniAdd() {
        return mniAdd;
    }

    public JMenuItem getMniRemove() {
        return mniRemove;
    }

    public JMenuItem getMniClear() {
        return mniClear;
    }
    
    

    public JButton getBtnClear() {
        return btnClear;
    }
    
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmnTree = new javax.swing.JPopupMenu();
        mniAdd = new javax.swing.JMenuItem();
        mniRemove = new javax.swing.JMenuItem();
        mniClear = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeAcount = new javax.swing.JTree();

        mniAdd.setText("Add");
        pmnTree.add(mniAdd);

        mniRemove.setText("Remove");
        pmnTree.add(mniRemove);

        mniClear.setText("Clear All");
        pmnTree.add(mniClear);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tree Demo");

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnAdd.setText("Add");
        jPanel1.add(btnAdd);

        btnDelete.setText("Delete");
        jPanel1.add(btnDelete);

        btnClear.setText("Clear");
        jPanel1.add(btnClear);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeAcount.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(treeAcount);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(493, 485));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmTreeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTreeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTreeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTreeDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTreeDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mniAdd;
    private javax.swing.JMenuItem mniClear;
    private javax.swing.JMenuItem mniRemove;
    private javax.swing.JPopupMenu pmnTree;
    private javax.swing.JTree treeAcount;
    // End of variables declaration//GEN-END:variables
}
