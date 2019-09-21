/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloDeElementosEstructurantes;

import java.util.ArrayList;

/**
 *
 * @author xebae
 */
public class GestorParalelo {
    
    private ArrayList<ElementoEstructurante> elementos;
    private int[][] matrizFinal;
    
    /**
     * Ingrese la cantidad de hilos
     */
    public GestorParalelo() {
        this.elementos = new ArrayList<>();
    }
    
    public int[][] ejecutarOpcion(int hilos, String opcion, String opcion2, int[][] matriz) throws InterruptedException{
        this.matrizFinal=new int[matriz.length][matriz[0].length];
        ArrayList<int[][]> lista= this.separarMatriz(hilos);
        if(opcion.equals("Guion")){
            for (int i = 0; i < lista.size(); i++) {
                this.elementos.add(new ElementoEstructuranteGuion(i,lista.get(i), this, opcion2));
            }
        }
        if(opcion.equals("I")){
            for (int i = 0; i < lista.size(); i++) {
                this.elementos.add(new ElementoEstructuranteI(i, lista.get(i), this, opcion2));
            }
        }
        if(opcion.equals("L")){
            for (int i = 0; i < lista.size(); i++) {
                this.elementos.add(new ElementoEstructuranteL(i, lista.get(i), this, opcion2));
            }
        }
        if(opcion.equals("InversaDeL")){
            for (int i = 0; i < lista.size(); i++) {
                this.elementos.add(new ElementoEstructuranteInversaDeL(i, lista.get(i), this, opcion2));
            }
        }
        if(opcion.equals("X")){
            for (int i = 0; i < lista.size(); i++) {
                this.elementos.add(new ElementoEstructuranteX(i, lista.get(i), this, opcion2));
            }
        }
        for (int i = 0; i < this.elementos.size(); i++) {
            this.elementos.get(i).start();
        }
        for (int i = 0; i < this.elementos.size(); i++) {
            this.elementos.get(i).join();
        }
        return this.matrizFinal;
    }
    
    public synchronized void uniendoPedasosAMatriz(int i, int[][] matriz){
        
    }
    
    public ArrayList<int[][]> separarMatriz(int hilos){
        ArrayList<int[][]> lista = new ArrayList<>();
        
        //metodo para separar   
        
        return lista;
    } 
}
