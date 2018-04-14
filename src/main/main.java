/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sopadeletras.objects.EscritorDeArchivo;
import sopadeletras.objects.LectorDeArchivos;
import sopadeletras.objects.SopaDeLetras;

/**
 *
 * @author House
 */
public class main {
    public static void main(String[] args) {
        SopaDeLetras sopita;
        LectorDeArchivos lector = new LectorDeArchivos();
        EscritorDeArchivo escritor = new EscritorDeArchivo();
        try {
            sopita = lector.lee("prueba.txt");
            for(int i=0; i< sopita.getListaPalabras().length; i++){
                sopita.getListaPalabras()[i].setEstado(sopita.detectarPalabra(sopita.getListaPalabras()[i]));
                System.out.println(sopita.getListaPalabras()[i].getEstado());
            }
            escritor.escribirOutput(sopita);
            
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
