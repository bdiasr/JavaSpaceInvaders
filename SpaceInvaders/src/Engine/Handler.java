/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import GameElements.Barreira;
import GameElements.Invasor;
import GameElements.Nave;
import GameElements.Tiro;
import GameElements.TiroInvasor;
import GraphicInterface.Anexos;

import GraphicInterface.PlanoDeFundo;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;

/**
 *
 * @author beatr
 */
public class Handler {
    
    private StackPane root;
    private GraphicsContext gc;
    private Scene janela;
    private PlanoDeFundo fundo; 
    
    private Anexos anexos; 
    private Engine engine; 
    private KeyboardHandler keyboard; 
    /**
     * elementos do jogo 
     */
    private Nave nave; 
    private Tiro tiroNave; 
    private TiroInvasor tiroInvasor; 
    private Invasor invasor; 
    private Barreira barreira;
    /**
     * 
     * @param root
     * @param gc
     * @param janela 
     */
    public Handler(StackPane root, GraphicsContext gc, Scene janela){
        
        this.janela = janela; 
        this.root = root; 
        this.gc = gc; 
        
    }
    /**
     * 
     * @return 
     */
    public Scene getJanela(){
        return janela;
    }
    /**
     * 
     * @param janela 
     */
    public void setJanela(Scene janela){
        this.janela = janela; 
    }
    
    /**
     * 
     * @return 
     */
    public Anexos getAnexos(){
        return anexos; 
    }
    /**
     * 
     * @param anexos 
     */
    public void setAnexos(Anexos anexos){
        this.anexos = anexos; 
    }
    
    /**
     * 
     * @return 
     */
    public Engine getEngine(){
        return engine; 
    }
    
    /**
     * 
     * @param engine 
     */
    public void setEngine(Engine engine){
        this.engine = engine; 
    }
    
    /**
     * 
     * @return 
     */
    public KeyboardHandler getKeyboard(){
        return keyboard; 
    }
    /**
     * 
     * @param keyboard 
     */
    public void setKeyboardHandler(KeyboardHandler keyboard){
        this.keyboard = keyboard; 
    }
    /**
     * 
     * @return 
     */
    public Nave getNave(){
        return nave; 
    }
    
    /**
     * 
     * @param nave 
     */
    public void setNave(Nave nave){
        this.nave = nave; 
    }
    
    /**
     * 
     * @return 
     */
    public Tiro getTiro(){
        return tiroNave; 
    }
    /**
     * 
     * @param tiroNave 
     */
    public void setTiro(Tiro tiroNave){
        this.tiroNave = tiroNave;
    }
    /**
     * 
     * @return 
     */
    public Invasor getInvasor(){
        return invasor; 
    }
    
    /**
     * 
     * @param invasor 
     */
    public void setInvasor(Invasor invasor){
        this.invasor = invasor; 
    }
    /**
     * 
     * @return 
     */
    public Barreira getBarreira(){
        return barreira; 
    }
    
    /**
     * 
     * @param barreira 
     */
    public void setBarreira(Barreira barreira){
        this.barreira = barreira; 
    }
    
    /**
     * 
     * @return 
     */
    public PlanoDeFundo getFundo(){
        return fundo;
    }
    
    /**
     * 
     * @param fundo
     */
    public void setFundo(PlanoDeFundo fundo){
        this.fundo = fundo; 
    }
    
    /**
     * 
     * @return 
     */
    public TiroInvasor getTiroInvasor(){
        return tiroInvasor; 
    }
    
    /**
     * 
     * @param tiroInvasor 
     */
    public void setTiroInvasor(TiroInvasor tiroInvasor){
        this.tiroInvasor = tiroInvasor; 
    }
  
}
