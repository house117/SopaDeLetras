/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author House
 */
public class LectorDeArchivos {
    
    public SopaDeLetras lee (String ruta) throws FileNotFoundException, IOException{
        
        File file = new File(ruta);
        FileReader lector = new FileReader(file);
        BufferedReader lectorLinea = new BufferedReader(lector);
        Boolean enterosLeidos = false;
        String linea =  lectorLinea.readLine();
        Scanner sc = new Scanner(linea);
        int columnas, filas, p;
        columnas = sc.nextInt();
        filas = sc.nextInt();
        p = sc.nextInt();
        SopaDeLetras sopita = new SopaDeLetras(filas, columnas, p);
        for(int i=0; i<p; i++){
            sopita.getListaPalabras()[i] = new Palabra();
            sopita.getListaPalabras()[i].addPalabra(lectorLinea.readLine());
            System.out.println(sopita.getListaPalabras()[i].toString());
        }
        for(int i=0; i<filas; i++){
            char[] c = lectorLinea.readLine().toCharArray();
            for(int j = 0; j< columnas; j++){
                sopita.getMatriz()[i][j] = c[j];
                System.out.printf("%c ",sopita.getMatriz()[i][j]);
            }
            System.out.println("");
        }
       
        lector.close();
        lectorLinea.close();
        
        
        return sopita;
        
    }
   
   


    
}
