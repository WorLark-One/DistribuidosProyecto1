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
    private int[][] matriz;
    private ArrayList<int[][]> lista;
    /**
     * Ingrese la cantidad de hilos
     */
    public GestorParalelo() {
        this.elementos = new ArrayList<>();
    }
    
    public int[][] ejecutarOpcion(int hilos, String opcion, String opcion2, int[][] matriz) throws InterruptedException{
        this.lista = new ArrayList<>();
        this.matrizFinal=new int[matriz.length][matriz[0].length];
        this.elementos = new ArrayList<>();
        this.matriz=matriz;
        lista= this.separarMatriz(hilos);
        //imprimirMatricesSeparadas();
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
    
    public synchronized void uniendoPedasosAMatriz(int id, int[][] matriz){
        int anchoReal = (this.matriz[0].length-2)/this.lista.size();
        int largo= (this.matriz.length);
        int a=(anchoReal*(id));
        int b=(anchoReal*(id+1));
        System.out.println("a:" + a + "  b:" + b);
        for(int i=0; i<matriz.length; i++){
            int p=a;
            int f=1;
            while(p<b){
                this.matrizFinal[i][p]=matriz[i][f];
                p+=1;
                f+=1;
            }
        }
    }
    
    public ArrayList<int[][]> separarMatriz(int hilos){
        this.lista = new ArrayList<>();
        int anchoReal = (this.matriz[0].length-2);
        while(anchoReal%hilos!=0){
            hilos-=1;
        }
        anchoReal= (anchoReal/hilos);
        int largo= (this.matriz.length);
        int a=0;
        int p=a;
        int b=anchoReal+1;
        int f;
        for(int k=0; k<hilos; k++){
            int[][] pedazo = new int[this.matriz.length][anchoReal+2];
            p=a;
            for(int i=0; i<matriz.length; i++){
                p=a; 
                f=0;
                while(p<=b){
                    pedazo[i][f]=matriz[i][p];
                    p+=1;
                    f++;
                }
            }
            a=b-1;
            b=b+anchoReal;
            lista.add(pedazo);
        }
        return lista;
    } 
    
    private void imprimirMatricesSeparadas(){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Lita: "+i);
            for (int j = 0; j < lista.get(i).length; j++) {
                for (int k = 0; k < lista.get(i)[j].length; k++) {
                    System.out.print(lista.get(i)[j][k]+" ");
                }
                System.out.println(" ");
            }
        }
    }
    
    private void imprimirMatriz(int[][] matriz){
        for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz[j].length; k++) {
                    System.out.print(matriz[j][k]+" ");
                }
                System.out.println(" ");
            }
    }

    public ArrayList<int[][]> getLista() {
        return lista;
    }

    public void setLista(ArrayList<int[][]> lista) {
        this.lista = lista;
    }
    
    
    
    
}
