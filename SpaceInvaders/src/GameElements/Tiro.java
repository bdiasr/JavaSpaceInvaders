/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Engine.Handler;
import GraphicInterface.Anexos;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author beatr
 */
public class Tiro {
    /**
     * instancia o handler.
     */
    private Handler handler; 
    /**
     * instancia os anexos. 
     */
    private Anexos anexos; 
    /**
     * define a posição X do tiro. 
     */
    public int tiroX; 
    /**
     * define a posição Y do tiro.
     */
    public int tiroY; 
    /**
     * define a velocidade do tiro. 
     */
    public int velocidadeTiro; 
    /**
     * guarda a informação se o tiro atingiu alguem ou nao.
     */
    public boolean atingiu = false; 
    /**
     * guarda a informação se o tiro atingiu a barreira ou não. 
     */
    public boolean atingiuBarreira = false;
    
    public Tiro (int inicioX, int inicioY, Handler handler){
        this.handler = handler; 
        handler.setTiro(this);
        
        this.tiroX = inicioX; 
        this.tiroY = inicioY; 
        velocidadeTiro = 15;
    }
    /**
     * aumenta a coordenada Y do tiro.
     */
    public void subir(){
        tiroY -= velocidadeTiro; 
    }
    
    /**
     * é chamada para verificar se o tiro da nave atingiu algum invasor ou não.
     * se atingir um invasor ela retorna verdadeiro e ele eh removido do array.
     * @param elemento
     * @return 
     */
    public boolean atingir(Invasor elemento){
       
        if((getTiroX() >= elemento.getX()) && (getTiroX() <= elemento.getX() + 50)){
            if(elemento.getY() < getTiroY() && elemento.getY() + 50 > getTiroY()){
                atingiu = true; 
            }
        }
        return atingiu; 
    }
    /**
     * é chamada para verificar se o tiro da nave atingiu algum tijolo da barreira ou não.
     * se atingir um invasor ela retorna verdadeiro e ele eh removido do array.
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
        
        subir();
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
     * retorna a posição X do tiro 
     * @return 
     */
    public int getTiroX(){
        //System.out.print(tiroX);
        return tiroX;
    }
    
    /**
     * retorna a posição Y do tiro 
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
        gc.drawImage(handler.getAnexos().tiroNave, tiroX, tiroY);
    }
    
}
