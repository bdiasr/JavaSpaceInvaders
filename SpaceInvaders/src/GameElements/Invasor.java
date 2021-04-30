/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Engine.Handler;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * instancia as variaveis para o invasor.
 * 
 * @author beatr
 */
public class Invasor {

    private final Handler handler;
    /**
     * determina a posição x do invasor
     */
    public int invasorX;
    /**
     * determina a posição Y do invasor
     */
    public int invasorY; 
    /**
     * determina a velocidade do invasor
     */
    public int velocidadeInvasor; 
    /**
     * determina a direção que o invasor se locomove no eixo x 
     */
    public int direcao = 1;
    /**
     * largura do invasor
     */
    public int larguraInvasor = 25;
    /**
     * setermina se o invasor foi atingido ou nao 
     */
    public boolean atingido = false; 
    /**
     * determina se o invasor está vivo ou nao 
     */
    public boolean vivo = true; 
    /**
     * determina se o tiro do invasor pode ser atirado 
     */
    public boolean checkTiroInvasor = true; 
    /**
     * determina o tempo de recarga do tiro do invasor 
     */
    public int tempoInvasor = 0; 
    
    /**
     * construtor do invasor 
     * @param InicioX
     * @param InicioY
     * @param direcao
     * @param handler 
     */
    public Invasor(int InicioX, int InicioY, int direcao,  Handler handler){
        this.handler = handler; 
        handler.setInvasor(this);
        
        this.invasorX = InicioX; 
        this.invasorY = InicioY; 
        this.direcao = direcao; 
        velocidadeInvasor = 6; 
        checkTiroInvasor = true; 
       
    }
    
    /**
     * retorna a posição x do invasor
     * @return 
     */
    public int getX(){
        return invasorX; 
    }
    
    /**
     * retorna a posição Y do invasor
     * @return 
     */
    public int getY(){
        return invasorY; 
    }
    
    /**
     * retorna um novo tiro do invasor e instancia seu proximo tiro como nao atiravel para sua recarga 
     * @return 
     */
    public TiroInvasor invasorAtirar(){
        checkTiroInvasor = false;
        TiroInvasor novoTiroInvasor = new TiroInvasor(getX() + 33,getY() ,  handler);
        return novoTiroInvasor;
    }
    
    /**
     * movimenta o invasor no eixo x 
     */
    public void movimenta(){
        
        invasorX += velocidadeInvasor*direcao; 
    }  
    
    /**
     * troca a diração do invasor quando chegar nos limites da tela 
     */
    public void trocaDirecao(){
        direcao *= -1;
        invasorY+= 50;
    }
    /**
     * atualiza os metodos do invasor 
     */
    public void update(){
        getX();
        getY();
        movimenta();
        invasorAtirar();
        tempoInvasor++; 
    }
    
    /**
     * renderiza o invasor 
     * @param gc 
     */
    public void render(GraphicsContext gc){
            gc.drawImage(handler.getAnexos().invasor, invasorX, invasorY);
    }
    
}
