/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Engine.Handler;
import javafx.scene.canvas.GraphicsContext;

/**
 * instancia o Handler
 * variavel vivo, determina se está vivo ou não 
 * x, determina sua coordenada no eixo x
 * y, determina sua coordenada no eixo y
 * 
 *
 * @author beatr
 */
public class Barreira {
    
    Handler handler; 
    public boolean vivo = true; 
    int x; 
    int y;  
    
    public Barreira(int inicioX, int inicioY, Handler handler){
        this.handler = handler; 
        handler.setBarreira(this); 
        this.x = inicioX; 
        this.y = inicioY; 
    }
    
    /**
     * retorna a posição x da barreira
     * @return 
     */
    public int getX(){
        return x; 
    }
    
    /**
     * retorna a posição y da barreira
     * @return 
     */
    public int getY(){
        return y; 
    }
    
    
    /**
     * atualiza as posições nos eixos x e y de cada barreira
     */
    public void update(){
        getX();
        getY();
    }
    
    /**
     * renderiza a barreira
     * @param gc 
     */
    public void render(GraphicsContext gc){
        gc.drawImage(handler.getAnexos().quadrado, x, y);
    }
}
