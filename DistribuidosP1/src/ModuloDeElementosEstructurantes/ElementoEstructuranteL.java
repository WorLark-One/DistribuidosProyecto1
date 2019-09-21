/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloDeElementosEstructurantes;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author xebae
 */
public class ElementoEstructuranteL extends ElementoEstructurante{
    
    /**
     * 
     * @param matriz 
     */
    public ElementoEstructuranteL(int[][] matriz) {
        super(matriz);
    }

    /**
     * 
     * @param i
     * @param matriz
     * @param monitor
     * @param opcion 
     */
    public ElementoEstructuranteL(int i, int[][] matriz, GestorParalelo monitor, String opcion) {
        super(i, matriz, monitor, opcion);
    }

    /**
     * 
     * @return 
     */
    @Override
    public int[][] erosion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
        for (int i = 1; i < matriz.length-1; i++) {
            for (int f = 1; f < matriz[i].length-1; f++) {
                ArrayList<Integer> lista = new ArrayList<>();
                lista.add(matriz[i-1][f]);
                lista.add(matriz[i][f+1]);
                lista.add(matriz[i][f]);
                Collections.sort(lista);
                nuevaMatriz[i][f]=lista.get(0);
            }
        }
        if(super.getMonitor()!=null){
            super.getMonitor().uniendoPedasosAMatriz(super.getIdd(), nuevaMatriz);
        }
        return nuevaMatriz;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int[][] dilatacion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
        for (int i = 1; i < matriz.length-1; i++) {
            for (int f = 1; f < matriz[i].length-1; f++) {
                ArrayList<Integer> lista = new ArrayList<>();
                lista.add(matriz[i-1][f]);
                lista.add(matriz[i][f+1]);
                lista.add(matriz[i][f]);
                Collections.sort(lista);
                nuevaMatriz[i][f]=lista.get(lista.size()-1);
            }
        }
        if(super.getMonitor()!=null){
            super.getMonitor().uniendoPedasosAMatriz(super.getIdd(), nuevaMatriz);
        }
        return nuevaMatriz;
    }
}
