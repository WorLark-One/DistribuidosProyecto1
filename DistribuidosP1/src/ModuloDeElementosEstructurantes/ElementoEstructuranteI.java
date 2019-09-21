/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloDeElementosEstructurantes;

/**
 *
 * @author xebae
 */
public class ElementoEstructuranteI extends ElementoEstructurante{

    public ElementoEstructuranteI(int[][] matriz) {
        super(matriz);
    }

    public ElementoEstructuranteI(int i, int[][] matriz, GestorParalelo monitor, String opcion) {
        super(i, matriz, monitor, opcion);
    }

    @Override
    public int[][] erosion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
        for (int i = 1; i < matriz.length-1; i++) {
            for (int f = 1; f < matriz[i].length-1; f++) {
                if(matriz[i-1][f]==0 && matriz[i+1][f]==0){
                    nuevaMatriz[i][f]=0;
                }else{
                    nuevaMatriz[i][f]=255;
                }
            }
        }
        if(super.getMonitor()!=null){
            super.getMonitor().uniendoPedasosAMatriz(super.getIdd(), nuevaMatriz);
        }
        return nuevaMatriz;
    }

    @Override
    public int[][] dilatacion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
        for (int i = 1; i < matriz.length-1; i++) {
            for (int f = 1; f < matriz[i].length-1; f++) {
                if(matriz[i-1][f]==255 && matriz[i+1][f]==255){
                    nuevaMatriz[i][f]=255;
                }else{
                    nuevaMatriz[i][f]=0;
                }
            }
        }
        if(super.getMonitor()!=null){
            super.getMonitor().uniendoPedasosAMatriz(super.getIdd(), nuevaMatriz);
        }
        return nuevaMatriz;
    }
    
}
