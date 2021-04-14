/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import view.FrmTreeDemo;

/**
 *
 * @author Sistemas-03
 */
public class FrmTreeController {

    private FrmTreeDemo frmTreeDemo;
    private DefaultTreeModel treeModel; //Agrega modelos al arbol
    private DefaultMutableTreeNode root; //Agrega nodos

    public FrmTreeController(FrmTreeDemo frmTreeDemo) {
        this.frmTreeDemo = frmTreeDemo;
        initComponent();
    }
    
    public void initComponent() {
        root = new DefaultMutableTreeNode("Accounting", true);
        treeModel = new DefaultTreeModel(root); //Agrega el nodo a model
        
        frmTreeDemo.getTreeAcount().setModel(treeModel);
        
        frmTreeDemo.getBtnAdd().addActionListener((e) -> {
            btnAddActionListener(e);
        });
        
        frmTreeDemo.getBtnDelete().addActionListener((e) -> {
            btnDeleteActionListener(e);
        });
        
        frmTreeDemo.getBtnClear().addActionListener((e)->{
            btnClearActionListener(e);
        });
        
        frmTreeDemo.getTreeAcount().addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e){
            treeAccountMouseListener(e);
        }
        });
        
        frmTreeDemo.getMniAdd().addActionListener((e)->{
            btnAddActionListener(e);
        });
        
        frmTreeDemo.getMniRemove().addActionListener((e)->{
            btnDeleteActionListener(e);
        });
        
        frmTreeDemo.getMniClear().addActionListener((e)->{
            btnClearActionListener(e);
        });
    }
    
    public void btnAddActionListener(ActionEvent e) {
        DefaultMutableTreeNode node = getSelectedTreeNode();
        if (node == null) {
            return;
        }
        
        String accountName = JOptionPane.showInputDialog(null, "Account name", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
        
        int childCount = node.getChildCount();
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(accountName);
        treeModel.insertNodeInto(child, node, childCount);
        
//        node.insert(new DefaultMutableTreeNode(accountName),node.getChildCount());
    }
    
    public void btnDeleteActionListener(ActionEvent e)
    {
        DefaultMutableTreeNode node = getSelectedTreeNode();
        if (node == null || node.isRoot()) {
            return;
        }
        
        treeModel.removeNodeFromParent(node);
    }
    
    private void btnClearActionListener(ActionEvent e){
        DefaultMutableTreeNode node = getSelectedTreeNode();
        if (node.isRoot()) {
            root.removeAllChildren();
            treeModel.reload();
        }else{JOptionPane.showMessageDialog(frmTreeDemo, "Can't remove all Nodes", "Warning", 0);}
    }
    
    private DefaultMutableTreeNode getSelectedTreeNode(){
        TreePath treepath = frmTreeDemo.getTreeAcount().getSelectionPath();
        
        if (treepath == null) {
            return null;
        }
        
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) treepath.getLastPathComponent();
        
        return (DefaultMutableTreeNode) treepath.getLastPathComponent();
    }
    
    private void treeAccountMouseListener(MouseEvent e){
        if (e.getButton() == MouseEvent.BUTTON3) {
            TreePath c = frmTreeDemo.getTreeAcount().getPathForLocation(e.getX(), e.getY()); //Valida que no se abra el popmenu en todos lados
            
            if (c == null) {
                return;
            }
            
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) c.getLastPathComponent();
            frmTreeDemo.getPmnTree().show(frmTreeDemo.getTreeAcount(), e.getX(), e.getY());
        }
    }
}
