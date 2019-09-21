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
public abstract class ElementoEstructurante extends Thread{
    
    private int[][] matriz;
    private int opcion=0;

    public ElementoEstructurante(int[][] matriz) {
        this.matriz = matriz;
    }
    
    /**
     * 
     */
    @Override
    public void run(){
        if(this.opcion==1){
            this.erosion();
            return;
        }
        if(this.opcion==2){
            this.dilatacion();
            return;
        }
        if(this.opcion==0){
            System.out.println("no elegiste la opcion aweonao");
        }
    }

    public int[][] getMatriz() {
        return this.matriz;
    }
    
    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    
    public abstract void erosion();
    public abstract void dilatacion();
}
