/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vapi;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.JTextField;
import view.views.panel.pnlCalculadora;

/**
 *
 * @author Usuario
 */
public class ValidatorMaster {

    //OPCION #1
    public static boolean letterValidator(String datos) {
        return datos.matches("[0-9]*");
    }

    //OPCION #2 Para solo letras
    public static void sLetras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        }
        );
    }

    //OPCION #3 (excluyendo el punto)
    public static void soloNumeros(final JTextField txtRandom) {
        txtRandom.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                int numeroPresionado = (int)evt.getKeyChar();
                
                //ESTE IF NO PERMITE EL INGRESO DE LETRAS Y OTROS SIMBOLOS
                if (numeroPresionado >= 46 &&  numeroPresionado <= 57) {
                    
                    //ESTOS VALORES ESTAN CONFORME LA TABLA ASCII
                    if (numeroPresionado == 46) {
                        String dato = txtRandom.getText();
                        int tama = dato.length();
                        for (int i = 0; i < tama; i++) {
                            if (dato.contains(".")) {
                                evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                            }
                        }
                    }else if (numeroPresionado == 47) {
                        evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                    }
                }else{
                    evt.setKeyChar((char)KeyEvent.VK_CLEAR);
                    evt.consume();
                }
            }
        });
    }
}
