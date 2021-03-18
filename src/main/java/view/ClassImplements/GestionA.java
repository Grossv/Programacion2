/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ClassImplements;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import view.views.panel.pnlTextEditor;

/**
 *
 * @author Usuario
 */
public class GestionA {

    FileInputStream entrada;
    FileOutputStream salida;

    public GestionA() {

    }

    //PARA ABRIR UN ARCHIVO DE TEXTO
    public String abrirTexto(File archivo) {
        String contenido = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascii;
            while ((ascii = entrada.read()) != -1) {
                char caracter = (char) ascii;
                contenido += caracter;
            }
        } catch (Exception e) {

        }
        return contenido;
    }

    //PARA GUARDAR ARCHIVO DE TEXTOS
    public String guardarTexto(File archivo, String contenido) {
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Save";
        } catch (Exception e) {

        }
        return respuesta;
    }

//    private void save() {
//        JFileChooser file = new JFileChooser();
//        TextFilter filter = new TextFilter();
//        file.setFileFilter(filter);
//        String fileName = "";
//// show save file dialog
//        if (file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//// get full path of selected file
//            fileName = file.getSelectedFile().getAbsolutePath();
//// get meta of text
//            StyledDocument doc = (StyledDocument) pnlTextEditor.getDocument();
//// convert to richtext format
//            RTFEditorKit kit = new RTFEditorKit();
//            BufferedOutputStream out;
//            try {
//                out = new BufferedOutputStream(new FileOutputStream(fileName));
//// save content to file
//                kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
//                out.flush();
//                out.close();
//            } catch (Exception e) {
//                System.out.println("Err:" + e.toString());
//            }
//
//        } else {
//            return;
//        }
//    }
}
