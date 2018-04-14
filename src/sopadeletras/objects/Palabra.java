/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras.objects;

import java.util.ArrayList;

/**
 *
 * @author House
 */
public class Palabra {
    private Integer fila;
    private Integer columna;
    private ArrayList<Character> vectorPalabra;
    private Estatus estado;
    private char[] arrayCaracteres;
    private String palabraString;
    public Palabra(){
        vectorPalabra = new ArrayList<Character>();
    }
    public void addPalabra(String palabra){
        this.setPalabraString(palabra);
        arrayCaracteres = palabra.toCharArray();
        for(int i=0; i< arrayCaracteres.length; i++){
            vectorPalabra.add(arrayCaracteres[i]);
        }
    }

    /**
     * @return el array de caracteres que componen la palabra
     */
    public ArrayList<Character> getVectorPalabra() {
        return vectorPalabra;
    }


    /**
     * @return el estado de esta palabra
     */
    public Estatus getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estatus estado) {
        this.estado = estado;
    }
    public String toString(){
        String c = "";
        for(int i=0; i<vectorPalabra.size(); i++){
            c = c + vectorPalabra.get(i);
        }
        return c;
    }

    /**
     * @return the fila
     */
    public Integer getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(Integer fila) {
        this.fila = fila;
    }

    /**
     * @return the columna
     */
    public Integer getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(Integer columna) {
        this.columna = columna;
    }

    /**
     * @return the palabraString
     */
    public String getPalabraString() {
        return palabraString;
    }

    /**
     * @param palabraString the palabraString to set
     */
    public void setPalabraString(String palabraString) {
        this.palabraString = palabraString;
    }
    
}

