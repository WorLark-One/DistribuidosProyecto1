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

    @Override
    public int[][] erosion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] dilatacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
