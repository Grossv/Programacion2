/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.ClassImplements;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author Usuario
 */
public class GestionA {
    FileInputStream entrada;
    FileOutputStream salida;
    
    public GestionA(){
        
    }
    
    //PARA ABRIR UN ARCHIVO DE TEXTO
    public String abrirTexto(File archivo){
        String contenido = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascii;
            while((ascii = entrada.read())!= -1){
                char caracter = (char)ascii;
                contenido += caracter;
            }
        } catch (Exception e){
            
        }
        return contenido;
    }
    
    //PARA GUARDAR ARCHIVO DE TEXTOS
    public String guardarTexto(File archivo, String contenido){
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytesTxt = contenido.getBytes();
            salida.write(bytesTxt);
            respuesta = "Guardado!";
        } catch (Exception e) {
            
        }
        return respuesta;
    }
}
