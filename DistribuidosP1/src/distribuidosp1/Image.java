/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidosp1;


import java.awt.image.BufferedImage;

/**
 *
 * @author Caldeirão
 */
public abstract class Image implements Cloneable {

    protected String type;    //Formato. 
    protected int largo;      //Largura/Eixo X.    
    protected int altura;     //Altura/eixo Y.
    protected int tonalidad;  //Intensidade == Nº de tonalidades de cinza.    

    /**
     * Construtor vazio.
     *
     * @author Caldeirão
     */
    public Image() {

    }

    /**
     * Construtor com parametros.
     *
     * @author Caldeirão
     * @param type
     * @param width
     * @param height
     * @param intensity
     */
    public Image(String type, int width, int height, int intensity) {
        this.type = type;
        this.largo = width;
        this.altura = height;
        this.tonalidad = intensity;
    }

    /**
     * Inicializa a matriz com o tamanho indicado.
     *
     * @author Caldeirão
     * @param width
     * @param height
     */
    public void setImageSize(int width, int height) {
        this.largo = width;
        this.altura = height;
    }

    /**
     * Retorna o tipo de imagem (PGM,PBM,PPM). Por hora tra\balhamos apenas com
     * PGM.
     *
     * @author Caldeirão
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Altera o tipo de image..
     *
     * @author Caldeirão
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retorna a largura da imagem.
     *
     * @author Caldeirão
     * @return
     */
    public int getWidth() {
        return largo;
    }

    /**
     * Retorna a altura da imagem..
     *
     * @author Caldeirão
     * @return
     */
    public int getHeight() {
        return altura;
    }

    /**
     * Retorna o nº de tonalidades de cinza da imagem.
     *
     * @author Caldeirão
     * @return
     */
    public int getIntensity() {
        return tonalidad;
    }

    /**
     * Altera o nº de tonalidades de cinza.
     *
     * @author Caldeirão
     * @param intensity
     */
    public void setIntensity(int tonalidad) {
        this.tonalidad = tonalidad;
    }

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract int[][] getMatrix();

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract int[][] getMatrixR();

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract int[][] getMatrixG();

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract int[][] getMatrixB();

    /**
     * Altera a matriz de imagem.
     *
     * @author Caldeirão
     * @param matrix
     */
    public abstract void setMatrix(int[][] matrix);

    /**
     * Altera a matriz de imagem RED.
     *
     * @author Caldeirão
     * @param matrix
     */
    public abstract void setMatrixR(int[][] matrix);

    /**
     * Altera a matriz de imagem GREEN.
     *
     * @author Caldeirão
     * @param matrix
     */
    public abstract void setMatrixG(int[][] matrix);

    /**
     * Altera a matriz de imagem BLUE.
     *
     * @author Caldeirão
     * @param matrix
     */
    public abstract void setMatrixB(int[][] matrix);

    /**
     * Método que desenha a imagem deve ser implementado em subclasses.
     *
     * @author Caldeirão
     * @return
     */
    public abstract BufferedImage draw();
    
    /**
     * Método que clona a imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract Image getClone();
}