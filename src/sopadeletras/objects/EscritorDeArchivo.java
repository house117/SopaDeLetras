/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras.objects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author House
 */
public class EscritorDeArchivo {
    
    public void escribirOutput(SopaDeLetras sopita) throws IOException{
        File output = new File("output.txt");
        FileWriter salida = new FileWriter(output);
        BufferedWriter escritor = new BufferedWriter(salida);
        for(int i=0; i<sopita.getListaPalabras().length; i++){
            System.out.println("\nA escribir:");
            System.out.printf("%s %d %d %s",
                    sopita.getListaPalabras()[i].getPalabraString(),
                    sopita.getListaPalabras()[i].getFila(),
                    sopita.getListaPalabras()[i].getColumna(),
                    sopita.getListaPalabras()[i].getEstado());
            escritor.write(String.format("%s %d %d %s", 
                    sopita.getListaPalabras()[i].getPalabraString(),
                    sopita.getListaPalabras()[i].getColumna(),
                    sopita.getListaPalabras()[i].getFila(),
                    sopita.getListaPalabras()[i].getEstado()));
            escritor.newLine();
        }
        escritor.close();
        
    }
}
