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
public class GestorIterativo {

    private ElementoEstructurante elemento;
    
    public GestorIterativo() {
    }
    
    public int[][] ejecutarOpcion(String opcion, String opcion2, int[][] matriz) throws InterruptedException{
        if(opcion.equals("Guion")){
            elemento = new ElementoEstructuranteGuion(matriz);
        }
        if(opcion.equals("I")){
            elemento = new ElementoEstructuranteI(matriz);
        }
        if(opcion.equals("L")){
            elemento = new ElementoEstructuranteL(matriz);
        }
        if(opcion.equals("InversaDeL")){
            elemento = new ElementoEstructuranteInversaDeL(matriz);
        }
        if(opcion.equals("X")){
            elemento = new ElementoEstructuranteX(matriz);
        }
        if(opcion2.equals("Dilatacion")){
            return elemento.dilatacion();
        }else{
            return elemento.erosion();
        }
    }
}
