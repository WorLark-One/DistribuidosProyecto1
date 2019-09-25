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
    private ArrayList<Integer> f;
    private ArrayList<Integer> limite;
    /**
     * Ingrese la cantidad de hilos
     */
    public GestorParalelo() {
        this.elementos = new ArrayList<>();
    }
    
    public int[][] ejecutarOpcion(int hilos, String opcion, String opcion2, int[][] matriz) throws InterruptedException{
        this.matrizFinal=new int[matriz.length][matriz[0].length];
        this.elementos = new ArrayList<>();
        this.matriz=matriz;
        this.separarMatriz(hilos);
        if(opcion.equals("Guion")){
            for (int i = 0; i < f.size(); i++) {
                this.elementos.add(new ElementoEstructuranteGuion(i, f.get(i), limite.get(i), this.matriz, this, opcion2));
            }
        }
        if(opcion.equals("I")){
            for (int i = 0; i < f.size(); i++) {
                this.elementos.add(new ElementoEstructuranteI(i, f.get(i), limite.get(i), this.matriz, this, opcion2));
            }
        }
        if(opcion.equals("L")){
            for (int i = 0; i < f.size(); i++) {
                this.elementos.add(new ElementoEstructuranteL(i, f.get(i), limite.get(i), this.matriz, this, opcion2));
            }
        }
        if(opcion.equals("InversaDeL")){
            for (int i = 0; i < f.size(); i++) {
                this.elementos.add(new ElementoEstructuranteInversaDeL(i, f.get(i), limite.get(i), this.matriz, this, opcion2));
            }
        }
        if(opcion.equals("X")){
            for (int i = 0; i < f.size(); i++) {
                this.elementos.add(new ElementoEstructuranteX(i, f.get(i), limite.get(i), this.matriz, this, opcion2));
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
    
    public synchronized void uniendoPedasosAMatriz(int id, int inicio, int limite, int[][] matriz){
        for(int i=0; i<matriz.length; i++){
            int p=inicio+1;
            while(p<limite){
                this.matrizFinal[i][p]=matriz[i][p];
                p+=1;
            }
        }
        
    }
    
    public void separarMatriz(int hilos){
        this.f = new ArrayList<>();
        this.limite = new ArrayList<>();
        int anchoReal = (this.matriz[0].length-2);
        while(anchoReal%hilos!=0){
            hilos-=1;
        }
        anchoReal= (anchoReal/hilos);
        int a=0;
        int b=anchoReal+1;
        for(int k=0; k<hilos; k++){
            this.f.add(a);
            this.limite.add(b);
            a=b-1;
            b=b+anchoReal;
        }
    }
}
