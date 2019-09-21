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
    
    private int id;
    private int[][] matriz;
    private GestorParalelo monitor;
    private String opcion;

    public ElementoEstructurante(int id, int[][] matriz, GestorParalelo monitor, String opcion) {
        this.id=id;
        this.matriz = matriz;
        this.monitor=monitor;
        this.opcion=opcion;
    }
    
    public ElementoEstructurante(int[][] matriz) {
        this.matriz = matriz;
        this.monitor=null;
        this.id=0;
    }
    
    /**
     * 
     */
    @Override
    public void run(){
        if("Erosion".equals(this.opcion)){
            this.erosion();
            return;
        }
        if("Dilatacion".equals(this.opcion)){
            this.dilatacion();
            return;
        }
        System.out.println("no elegiste la opcion aweonao");
  
    }

    public int[][] getMatriz() {
        return this.matriz;
    }

    public GestorParalelo getMonitor() {
        return monitor;
    }

    /**
     * 
     * @return 
     */
    public int getIdd() {
        return id;
    }
    
    public abstract int[][] erosion();
    public abstract int[][] dilatacion();
}
