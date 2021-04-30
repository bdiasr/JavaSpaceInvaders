/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameElements;

import Engine.Handler;
import GraphicInterface.Anexos;
import static GraphicInterface.Main.X;
import static GraphicInterface.Main.Y;
import javafx.scene.canvas.GraphicsContext;

/**
 * metodo nave 
 * @author beatr
 */
public class Nave {
    /**
     * handler que gerencia as informações 
     */
    Handler handler; 
    /**
     * classe anexos, responsável por gerenciar os anexos 
     */
    Anexos anexos; 
    /**
     * classe tiro da nave 
     */
    Tiro novoTiro; 
    
    /**
     * posição no eixo x em que se encontra a nave.
     */
    public static int x; 
    /**
     * posição no eixo Y em que se encontra a nave.
     */
    public static int y; 
    /**
     * velocidade que a nave se movimenta e seu movimento é atualizado. 
     */
    public static int velocidadeNave; 
    
    /**
     * variavel que guarda se o tiro foi atirado.
     * tiro pode ser disparado: true. 
     * tiro acabou de sair e precisa esperar pra ser disparado: false. 
     */
    public boolean checkTiro; 
    /**
     * variavel que verifica se a nave esta viva ou nao. 
     */
    public boolean vivo; 
    /**
     * variavel booleana que armazena as vidas restantes da nave. 
     * comeca com 3 unidades de vida 
     */
    public int vidaNave;
    /**
     * armazena o tempo de recarga da nave 
     */
    public int tempo; 
    /**
     * velocidade auxliar que armazena a troca da velocidade da nave 
     */
    int velAux; 
    
    /**
     * Construtor da nave 
     * @param handler 
     */
    public Nave(Handler handler){
         
        this.handler = handler; 
        handler.setNave(this);
        
        checkTiro = true; 
        tempo = 0;
        velocidadeNave = 9; 
        x = (X/5) - 50; 
        y = Y - 100; 
        vidaNave = 3;
        vivo = true; 
        
    }
    
    /**
     * quando a nave é atingida por um tiro do invaasor ela recebe dano e perde uma vida.
     * se sua vida total chegar a 0, ela morre 
     */
    public void levarDano(){
        vidaNave --; 
        if(vidaNave == 0){
            vivo = false; 
        }
    }
    
    /**
     * verifica se a nave está viva 
     * @return 
     */
    public boolean getVivo(){
        if(vidaNave == 0){
            vivo = false;
            return vivo;
        }
        return vivo; 
    }
    
    /**
     * se for pressionado o espaço ele vai criar um novo tiro e retorna-lo 
     * @return 
     */
    public Tiro atirar(){
        checkTiro = false;
        Tiro novoTiroNave = new Tiro(getX() + 33,   getY() ,  handler);
        return novoTiroNave;
    }
    
    /**
     * define o movimento da nave com base das teclas pressionadas. 
     */
    public void naveKeyboard(){
        
        if(handler.getKeyboard().getAtirou()){
            atirar(); 
        }
        
        if (handler.getKeyboard().getDireita()){
            x += velocidadeNave; 
        }
        if (handler.getKeyboard().getEsquerda()){
            x -= velocidadeNave;
        }
        if( tempo >= 50){
            checkTiro = true; 
            tempo = 0; 
        }
        if(getX() >= X){
            velAux = velocidadeNave; 
            velocidadeNave = 0; 
            setX(1740);
            velocidadeNave = velAux;
        }
        if(getX() <= 0){
            velAux = velocidadeNave; 
            velocidadeNave = 0; 
            setX(80);
            velocidadeNave = velAux;
        }
    }
    
    /**
     * define o valor de X dado como parametro 
     * @param value 
     */
    public void setX(int value){
        x = value; 
    }
    
    /**
     * retorna a posição Y ATUAL da nave
     * @return 
     */
    public int getY(){
        return y;
    }
    
    /**
     * retorna a posição X ATUAL da nave 
     * @return 
     */
    public int getX(){
        return x; 
    }
    
    /**
     * atualiza a todo instante a nave. 
     */
    public void update(){
        getY();
        getX();
        naveKeyboard();
        atirar();
        tempo ++; 
        
    }
    
    /**
     * metodo que renderiza a nave 
     * @param gc 
     */
    public void render(GraphicsContext gc){
        if(vivo){
            gc.drawImage(handler.getAnexos().nave, x, y);
        }
        
    }
    
}
