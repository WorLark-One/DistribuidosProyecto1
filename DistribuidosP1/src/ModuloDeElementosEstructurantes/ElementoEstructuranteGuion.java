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
public class ElementoEstructuranteGuion extends ElementoEstructurante{

    public ElementoEstructuranteGuion(int[][] matriz) {
        super(matriz, 1, (matriz[0].length-1));
    }

    public ElementoEstructuranteGuion(int i, int f, int limite, int[][] matriz, GestorParalelo monitor, String opcion) {
        super(i, matriz, monitor, opcion, f, limite);
    }

    @Override
    public int[][] erosion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
        for (int i = 1; i < matriz.length-1; i++) {
            int p=f+1;
            while(p<limite){
                ArrayList<Integer> lista = new ArrayList<>();
                lista.add(matriz[i][p+1]);
                lista.add(matriz[i][p-1]);
                lista.add(matriz[i][p]);
                Collections.sort(lista);
                nuevaMatriz[i][p]=lista.get(0);
                p++;
            }
        }
        return nuevaMatriz;
    }

    @Override
    public int[][] dilatacion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
        for (int i = 1; i < matriz.length-1; i++) {
            int p=f+1;
            while(p<limite){
                ArrayList<Integer> lista = new ArrayList<>();
                lista.add(matriz[i][p+1]);
                lista.add(matriz[i][p-1]);
                lista.add(matriz[i][p]);
                Collections.sort(lista);
                nuevaMatriz[i][p]=lista.get(lista.size()-1);
                p++;
            }
        }
        return nuevaMatriz;
    }
    
}
