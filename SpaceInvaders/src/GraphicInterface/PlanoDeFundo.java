/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import Engine.Handler;
import static GraphicInterface.Main.X;
import static GraphicInterface.Main.Y;
import javafx.scene.canvas.GraphicsContext;

/**
 * responsavel por gerenciar o plano de fundo do jogo 
 * @author beatr
 */


public class PlanoDeFundo {
    
    private Handler handler; 
    
    private int y = 0; 
    
    public PlanoDeFundo(Handler handler){
        this.handler = handler; 
        handler.setFundo( this);
    }
    
    public void render(GraphicsContext gc){
        gc.drawImage(handler.getAnexos().fundo, 0 , y);
    }
}
