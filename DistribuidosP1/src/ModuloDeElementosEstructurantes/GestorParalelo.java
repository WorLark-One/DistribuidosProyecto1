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

    /**
     * Ingrese la cantidad de hilos
     * @param hilos 
     */
    public GestorParalelo() {
        this.elementos = new ArrayList<>();
    }
    
    public void ejecutarOpcion(int hilos, String opcion, int[][] matriz) throws InterruptedException{
        if(opcion.equals("Guion")){
            for (int i = 0; i < hilos; i++) {
                this.elementos.add(new ElementoEstructuranteGuion(matriz));
            }
        }
        if(opcion.equals("I")){
            for (int i = 0; i < hilos; i++) {
                this.elementos.add(new ElementoEstructuranteI(matriz));
            }
        }
        if(opcion.equals("L")){
            for (int i = 0; i < hilos; i++) {
                this.elementos.add(new ElementoEstructuranteL(matriz));
            }
        }
        if(opcion.equals("InversaDeL")){
            for (int i = 0; i < hilos; i++) {
                this.elementos.add(new ElementoEstructuranteInversaDeL(matriz));
            }
        }
        if(opcion.equals("X")){
            for (int i = 0; i < hilos; i++) {
                this.elementos.add(new ElementoEstructuranteX(matriz));
            }
        }
        for (int i = 0; i < this.elementos.size(); i++) {
            this.elementos.get(i).start();
        }
        for (int i = 0; i < this.elementos.size(); i++) {
            this.elementos.get(i).join();
        }
    }
}
