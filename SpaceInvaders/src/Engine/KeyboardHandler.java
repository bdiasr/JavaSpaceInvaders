/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author beatr
 */
    
/**
 * essa classe é responsável por manipular e instanciar todos os inputs de teclado e retornar um valor determinado para cada ação.
 * @author beatr
 */
public class KeyboardHandler {
    /**
     * instancia a janela 
     */
    private Scene janela; 
    
    /**
     * instancia a direção. 
     */
    public int direcao; 
    
    /**
     * armazena o estado da esquerda. 
     */
    public boolean esquerda; 
    
    /**
     * armazena o estado da direita. 
     */
    public boolean direita; 
    
    /**
     * armazena o estado do atirou. 
     */
    public boolean atirou; 
    
    /**
     * construtor do keyBoard Handler
     * @param handler 
     */
    public KeyboardHandler(Handler handler){
        
        janela = handler.getJanela();
        handler.setKeyboardHandler(this);
    }
    
    /**
     * le e interpreta quais teclas do teclado foram ativadas.
     */
    public void getKeyboard(){
        janela.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
           switch(e.getCode()) {
                case A:
                   esquerda = true;
                   break;
                case LEFT:
                    esquerda = true; 
                    break; 
                case D:
                    direita = true;
                    break;
                case RIGHT:
                    direita = true; 
                    break; 
                case SPACE:
                    atirou = true; 
                    break; 
           } 
        });
        janela.addEventHandler(KeyEvent.KEY_RELEASED, e -> {
           switch(e.getCode()) {
                case A:
                   esquerda = false; 
                   break;
                case LEFT:
                    esquerda = false; 
                    break;
                case RIGHT:
                    direita = false;
                    break;
                case D:
                    direita = false;
                    break;
                case SPACE:
                    atirou = false; 
                    break;
           } 
        });
    }
    
    /**
     * atualiza o teclado e seus inputs 
     */
    public void update(){
        getKeyboard();
    }
    
    /**
     * metodo que retorna o estado da variavel direita 
     * @return 
     */
    public boolean getDireita(){
        return direita; 
    }
    
    /**
     * metodo que retorna o estado da variavel esquerda
     * @return 
     */
    public boolean getEsquerda(){
        return esquerda; 
    }
    
    /**
     * metodo que retorna o estado da variavel atirou 
     * @return 
     */
    public boolean getAtirou(){
        return atirou; 
    }
}
