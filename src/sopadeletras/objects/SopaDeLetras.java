/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopadeletras.objects;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author House
 */
public class SopaDeLetras {
    private Integer m; //filas
    private Integer n; //columnas
    private Integer p;
    private Character[][] matriz;
    private Estatus estado;
    private Palabra[] listaPalabras;
    public SopaDeLetras(Integer filas, Integer columnas, Integer p){
        matriz = new Character[filas][columnas];
        this.m = filas;
        this.n = columnas;
        this.p = p;
        listaPalabras = new Palabra[p];
    }
    

    SopaDeLetras() {
    }
    public Estatus detectarPalabra(Palabra vector){
        Boolean encontrada = false;
        int i = 0;
        int j;
        
        while(!encontrada && i<m){
            j=0;
            
            while(!encontrada && j<n){
                
                if(getMatriz()[i][j] == vector.getVectorPalabra().get(0)){ //verifico si la letra inicial es =
                    if(vertical(vector, i , j)){ //envio el tamanio del vector
                        return Estatus.VERTICAL;
                    }else{
                        if(horizontal(vector, i , j)){
                        return Estatus.HORIZONTAL;
                        }else{
                           if(diagonal(vector, i , j)){
                            return Estatus.DIAGONAL;
                            } 
                        }
                    }
                    
                    
                }
                j++;
            }
            i++;
        }
            vector.setColumna(0);
            vector.setFila(0);
        return Estatus.ERROR;
    }
    public Boolean horizontal(Palabra tamanio, Integer i, Integer j){
        int x = i;
        int y = j;
        int tamanioVector = tamanio.getVectorPalabra().size()-1;
        Integer coincidencias = 0;
        tamanio.setFila(i+1);
        tamanio.setColumna(j+1);
        //verificamos a la derecha
        for(int k=0; k<tamanioVector; k++){
            if(celdaOK(x, y)){
                //System.out.println(getMatriz()[x][y]+ " | " + tamanio.getVectorPalabra().get(k));
                if(Objects.equals(getMatriz()[x][y], tamanio.getVectorPalabra().get(k))){
                    coincidencias ++;
                    if(coincidencias == tamanioVector){
                        return true;
                    }
                }
            }
            y++;
        }
        x=i;
        y=j;
        coincidencias = 0;
        for(int k=0; k<tamanioVector; k++){
            if(celdaOK(x, y)){
                //System.out.println(getMatriz()[x][y]+ " | " + tamanio.getVectorPalabra().get(k));
                if(Objects.equals(getMatriz()[x][y], tamanio.getVectorPalabra().get(k))){
                    coincidencias ++;
                    if(coincidencias == tamanioVector){
                        return true;
                    }
                }
            }
            y--;
        }
        return false;
    }
    public Boolean vertical(Palabra tamanio, Integer i, Integer j){

        //verificamos abajo
        int x = i;
        int y = j;
        tamanio.setFila(i+1);
        tamanio.setColumna(j+1);
        int tamanioVector = tamanio.getVectorPalabra().size()-1;
        Integer coincidencias = 0;
        for(int k=0; k<tamanioVector; k++){
            if(celdaOK(x, y)){
               // System.out.println(getMatriz()[x][y]+ " | " + tamanio.getVectorPalabra().get(k));
                if(Objects.equals(getMatriz()[x][y], tamanio.getVectorPalabra().get(k))){
                    coincidencias ++;
                    if(coincidencias == tamanioVector){
                        return true;
                    }
                }
            }
            x++;
        }
        x=i;
        y=j;
        coincidencias = 0;
        //verificamos arriba
        for(int k=0; k<tamanioVector; k++){
            if(celdaOK(x, y)){
                //System.out.println(getMatriz()[x][y]+ " | " + tamanio.getVectorPalabra().get(k));
                if(Objects.equals(getMatriz()[x][y], tamanio.getVectorPalabra().get(k))){
                    coincidencias ++;
                    if(coincidencias == tamanioVector){
                        return true;
                    }
                }
            }
            x--;
        }
        return false;
    }
    public Boolean diagonal(Palabra tamanio, Integer i, Integer j){
        //verificamos abajo derecha
        tamanio.setFila(i+1);
        tamanio.setColumna(j+1);
        int x = i;
        int y = j;
        int tamanioVector = tamanio.getVectorPalabra().size()-1;
        Integer coincidencias = 0;
        for(int k=0; k<tamanioVector; k++){
            if(celdaOK(x, y)){
                //System.out.println(getMatriz()[x][y]+ " | " + tamanio.getVectorPalabra().get(k));
                if(Objects.equals(getMatriz()[x][y], tamanio.getVectorPalabra().get(k))){
                    coincidencias ++;
                    if(coincidencias == tamanioVector){
                        return true;
                    }
                }
            }
            x++;
            y++;
        }
        x=i;
        y=j;
        coincidencias = 0;
        //verificamos abajo izquierda
        for(int k=0; k<tamanioVector; k++){
            if(celdaOK(x, y)){
               // System.out.println(getMatriz()[x][y]+ " | " + tamanio.getVectorPalabra().get(k));
                if(Objects.equals(getMatriz()[x][y], tamanio.getVectorPalabra().get(k))){
                    coincidencias ++;
                    if(coincidencias == tamanioVector){
                        return true;
                    }
                }
            }
            x++;
            y--;
        }
        coincidencias = 0;
        x=i;
        y=j;
        //arriba derecha
        for(int k=0; k<tamanioVector; k++){
            if(celdaOK(x, y)){
                //System.out.println(getMatriz()[x][y]+ " | " + tamanio.getVectorPalabra().get(k));
                if(Objects.equals(getMatriz()[x][y], tamanio.getVectorPalabra().get(k))){
                    coincidencias ++;
                    if(coincidencias == tamanioVector){
                        return true;
                    }
                }
            }
            x--;
            y++;
        }
        coincidencias = 0;
        x=i;
        y=j;
        //arriba izquierda
        for(int k=0; k<tamanioVector; k++){
            if(celdaOK(x, y)){
               // System.out.println(getMatriz()[x][y]+ " | " + tamanio.getVectorPalabra().get(k));
                if(getMatriz()[x][y] == tamanio.getVectorPalabra().get(k)){
                    coincidencias ++;
                    if(coincidencias == tamanioVector){
                        return true;
                    }
                }
            }
            x--;
            y--;
        }
        return false;
    }
    /*
    public void abrirCelda(Integer x, Integer y){
        if(celdaOK(x,y)){
            if((!tablero[x][y].isMina())){
                if(tablero[x][y].getEstado()==Estado.CERRADO){
                    tablero[x][y].setEstado(Estado.ABIERTO);
                }
                int mina = cantMinas(x,y);
                tablero[x][y].setNumero(mina);
                if(mina == 0){
                    for (int i = x-1; i <=x+1; i++) {
                        for (int j = y-1; j <= y+1; j++) {
                            if(celdaOK(i,j) && tablero[i][j].getEstado()== Estado.CERRADO){
                                abrirCelda(i,j);                           
                            }
                        }
                    }
                }
            }else if(tablero[x][y].getEstado() == Estado.CERRADO){
                looser(x, y);

            }
            if(winner()){
                System.out.println("GANASTE!");
            }
        }
    }
    */
    private boolean celdaOK(int i, int j) {
        return (((i >= 0) && (i <= m)) && ((j >= 0) && (j <= n))) && ((i != m) && (j != n));
    }

    /**
     * @return the listaPalabras
     */
    public Palabra[] getListaPalabras() {
        return listaPalabras;
    }

    /**
     * @param listaPalabras the listaPalabras to set
     */
    public void setListaPalabras(Palabra[] listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    /**
     * @return the matriz
     */
    public Character[][] getMatriz() {
        return matriz;
    }

    /**
     * @param matriz the matriz to set
     */
    public void setMatriz(Character[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * @return the p
     */
    public Integer getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Integer p) {
        this.p = p;
    }
}
