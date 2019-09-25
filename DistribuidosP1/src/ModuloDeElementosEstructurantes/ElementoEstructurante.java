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
    protected int f;
    protected int limite;

    public ElementoEstructurante(int id, int[][] matriz, GestorParalelo monitor, String opcion, int f, int limite) {
        this.id=id;
        this.matriz = matriz;
        this.monitor=monitor;
        this.opcion=opcion;
        this.f=f;
        this.limite=limite;
    }
    
    public ElementoEstructurante(int[][] matriz, int f, int limite) {
        this.matriz = matriz;
        this.monitor=null;
        this.f=f;
        this.limite=limite;
        this.id=0;
    }
    
    /**
     * 
     */
    @Override
    public void run(){
        if("Erosion".equals(this.opcion)){
            matriz=this.erosion();
            this.getMonitor().uniendoPedasosAMatriz(id, f, limite, matriz);
            return;
        }
        if("Dilatacion".equals(this.opcion)){
            matriz=this.dilatacion();
            this.getMonitor().uniendoPedasosAMatriz(id, f , limite, matriz);
            return;
        }
  
    }

    public int[][] getMatriz() {
        return this.matriz;
    }

    public GestorParalelo getMonitor() {
        return monitor;
    }

    public int getF() {
        return f;
    }

    public int getLimite() {
        return limite;
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
