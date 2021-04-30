/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Engine.Handler;
import javafx.scene.canvas.GraphicsContext;

/**
 * metodo do tiro do invasor 
 * @author beatr
 */
public class TiroInvasor {
    
    /**
     * instancia o handler.
     */
    private Handler handler; 
    
    /**
     * armazena a posição X do tiro do invasor.
     */
    public int tiroX; 
    /**
     * armazena a posição Y do tiro do invasor. 
     */
    public int tiroY; 
    /**
     * determina a velocidade do tiro do invasor. 
     */
    public int velocidadeTiro; 
    /**
     * armazena a informação se atingiu a nave ou nao.
     */
    public boolean atingiuNave = false; 
    /**
     * armazena a informação se atingiu a barreira ou não. 
     */
    public boolean atingiuBarreira = false; 
    
    /**
     * construtor do tiro 
     * define a velocidade do tiro 
     * @param inicioX
     * @param inicioY
     * @param handler 
     */
    public TiroInvasor (int inicioX, int inicioY, Handler handler){
        this.handler = handler; 
        handler.setTiroInvasor(this);
        
        this.tiroX = inicioX; 
        this.tiroY = inicioY; 
        velocidadeTiro = 8;
    }
    
    /**
     * altera a posição do tiro no eixo Y .
     */
    public void descer(){
        tiroY += velocidadeTiro; 
    }
    
    /**
     * é chamada para conferir se o tiro do invasor atingiu a nave.
     * caso tenha atingido, é retornado um valor verdadeiro e a nave perde uma vida. 
     * @param elemento
     * @return 
     */
    public boolean atingirNave(Nave elemento){
        if((getTiroX() >= elemento.getX()) && (getTiroX() <= elemento.getX() + 50)){
            if(elemento.getY() < getTiroY() + 4 && elemento.getY() + 50 > getTiroY() + 4){
                atingiuNave = true; 
            }
        }
        return atingiuNave; 
    }
    
    /**
     * é chamada para conferir se o tiro do invasor atingiu uma barreira. 
     * caso tenha atingido é retornado um valor verdadeiro e a a barreira é removida do array. 
     * @param barreira
     * @return 
     */
    public boolean atingirBarreira(Barreira barreira){
        if((getTiroX() >= barreira.getX()) && (getTiroX() <= barreira.getX() + 16)){
            if(barreira.getY() < getTiroY() + 4 && barreira.getY() + 16 > getTiroY() + 4){
                atingiuBarreira = true; 
            }
        }
        return atingiuBarreira; 
    }
    
    /**
     * atualiza o tiro 
     */
    public void update(){
        
        descer();
        getTiroY();
        getTiroX();
        
    }
    /**
     * destroi os tiros quando sair da tela
     * @return 
     */
    public boolean destroy(){
        return getTiroY() <= 0; 
    }
    
    /**
     * retorna o valor do tiro do invasor no eixo X
     * @return 
     */
    public int getTiroX(){
        //System.out.print(tiroX);
        return tiroX;
    }
    
    /**
     * retorna o valor do tiro do invasor no eixo Y 
     * @return 
     */
    public int getTiroY(){
        //System.out.print(tiroY);
        return tiroY;
    }
    
   
    /**
     * renderiza o tiro 
     * @param gc 
     */
    public void render(GraphicsContext gc){
        gc.drawImage(handler.getAnexos().tiroInvasor, tiroX, tiroY);
    }
    
}

