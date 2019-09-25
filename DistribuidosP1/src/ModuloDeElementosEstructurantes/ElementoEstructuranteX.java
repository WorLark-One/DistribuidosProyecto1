package ModuloDeElementosEstructurantes;

import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xebae
 */
public class ElementoEstructuranteX extends ElementoEstructurante{

    
    public ElementoEstructuranteX(int[][] matriz) {
        super(matriz, 1, (matriz[0].length-1));
    }

    public ElementoEstructuranteX(int i, int f, int limite, int[][] matriz, GestorParalelo monitor, String opcion) {
        super(i, matriz, monitor, opcion, f, limite);
    }

    /**
     * 
     * @return 
     */
    @Override
    public int[][] erosion() {
        int[][] matriz = super.getMatriz();
        System.out.println("f:" + f + " limite:" + limite);
        int[][] nuevaMatriz = new int[matriz.length][limite];
        for (int i = 1; i < matriz.length-1; i++) {
            int p=f+1;
            while(p<limite){
                ArrayList<Integer> lista = new ArrayList<>();
                lista.add(matriz[i-1][p-1]);
                lista.add(matriz[i+1][p-1]);
                lista.add(matriz[i-1][p+1]);
                lista.add(matriz[i+1][p+1]);
                lista.add(matriz[i][p]);
                Collections.sort(lista);
                nuevaMatriz[i][p]=lista.get(0);
                p++;
            }
        }

        return nuevaMatriz;
    }

    /**
     * 
     * 
     */
    @Override
    public int[][] dilatacion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][limite];
        for (int i = 1; i < matriz.length-1; i++) {
            int p=f+1;
            while(p<limite){
                ArrayList<Integer> lista = new ArrayList<>();
                lista.add(matriz[i-1][p-1]);
                lista.add(matriz[i+1][p-1]);
                lista.add(matriz[i-1][p+1]);
                lista.add(matriz[i+1][p+1]);
                lista.add(matriz[i][p]);
                Collections.sort(lista);
                nuevaMatriz[i][p]=lista.get(lista.size()-1);
                p++;
            }
        }
        return nuevaMatriz;
    }
    
}
