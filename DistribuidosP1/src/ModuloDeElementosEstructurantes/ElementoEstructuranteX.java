package ModuloDeElementosEstructurantes;

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
        super(matriz);
    }

    /**
     * 
     */
    @Override
    public int[][] erosion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][matriz.length];
        for (int i = 1; i < matriz.length-1; i++) {
            for (int f = 1; f < matriz[i].length-1; f++) {
                if(matriz[i-1][f-1]==0 && matriz[i+1][f-1]==0 && matriz[i-1][f+1]==0 && matriz[i+1][f+1]==0){
                    nuevaMatriz[i][f]=0;
                }else{
                    nuevaMatriz[i][f]=255;
                }
            }
        }
        return nuevaMatriz;
    }

    /**
     * 
     */
    @Override
    public int[][] dilatacion() {
        int[][] matriz = super.getMatriz();
        int[][] nuevaMatriz = new int[matriz.length][matriz[0].length];
        for (int i = 1; i < matriz.length-1; i++) {
            for (int f = 1; f < matriz[i].length-1; f++) {
                if(matriz[i-1][f-1]==255 && matriz[i+1][f-1]==255 && matriz[i-1][f+1]==255 && matriz[i+1][f+1]==255){
                    nuevaMatriz[i][f]=255;
                }else{
                    nuevaMatriz[i][f]=0;
                }
            }
        }
        return nuevaMatriz;
    }
    
}
