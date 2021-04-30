/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import javafx.scene.image.Image;
import Engine.Handler;
import static GraphicInterface.Main.X;
import static GraphicInterface.Main.Y;
/**
 *
 * @author beatr
 */
public class Anexos {
    
    /**
     * imagem da nave.
     */
    public Image nave;
    
    /**
     * imagem do invasor. 
     */
    public Image invasor;
    
    /**
     * imagem do tiro da nave. 
     */
    public Image tiroNave; 
    
    /**
     * imagem do fundo. 
     */
    public Image fundo; 
    
    /**
     * imagem da barreira. 
     */
    public Image barreira; 
    
    /**
     * imagem do quadrado da barreira.
     */
    public Image quadrado; 
    
    /**
     * imagem do tiro do invasor.
     */
    public Image tiroInvasor;
    
    /**
     * tela de game over. 
     */
    public Image gameOver;
    
    /**
     * tela de jogo ganho. 
     */
    public Image youWin; 
    
    public Anexos(Handler handler){
        
        handler.setAnexos(this);
        
        nave = new Image("images/nave.png", 70, 70, false, false);
        invasor = new Image("images/invasorAmarelo.png", 50, 50, false, false);
        tiroNave = new Image("images/tiro.png", 4, 12, false, false);
        fundo = new Image("images/fundoMaior.png", X, Y, false, false);
        barreira = new Image("images/barreiraVerde.png", 300, 150, false, false);
        tiroInvasor = new Image("images/tiroVerde.png", 4, 12, false, false);
        quadrado = new Image("images/quadrado.png", 16, 16, false, false);
        youWin = new Image("images/youWin.png", X, Y, false, false);
        gameOver = new Image("images/gameOver.png", X, Y, false, false);
    }
    
}
