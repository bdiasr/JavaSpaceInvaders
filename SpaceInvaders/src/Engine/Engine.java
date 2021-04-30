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

import static GraphicInterface.Main.X;
import static GraphicInterface.Main.Y;
import GraphicInterface.PlanoDeFundo;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * a Engine do jogo implementa a classe Runnable para a thread
 * existem 3 metodos principais: run, update e render
 * o run() roda a thread e da sleep nos intervalos
 * update() atualiza todas as classes e a logica do jogo esta implementada lá 
 * o metodo render(gc) renderiza todos os elementos do jogo 
 * @author beatr
 */
public class Engine implements Runnable{
    /**
     * definicao do stack pane.
     */
    private StackPane root;
    
    /**
     * definição do graphics contex gc. 
     */
    private GraphicsContext gc;
    
    /**
     * definição da nova cena. 
     */
    private Scene scene;
    
    /**
     * Engine:
     * definição do handler.
     */
    private Handler handler;
    
    /**
     * Engine: 
     * definição do gerenciador de teclado. 
     */
    private KeyboardHandler keyboard; 
    
    /**
     * Elemento de jogo: 
     * definição da nave. 
     */
    private Nave nave; 
    
    /**
     * elemento de jogo:
     * definição do array de tiros da nave. 
     */
    private ArrayList<Tiro> tiros; 
    
    /**
     * elemento de jogo: 
     * definição do array de tiros de invasor. 
     */
    private ArrayList<TiroInvasor> tiroInvasor; 
    
    /**
     * elemento do jogo:
     * definição do array de invasores. 
     */
    private ArrayList<Invasor> invasores; 
    
    /**
     * interface grafica:
     * definição do plano de fundo.
     */
    private PlanoDeFundo fundo; 
    
    /**
     * elemento de jogo: 
     * definição da barreira.
     */
    private ArrayList<Barreira> barreiras;
    
    /**
     * definição da variavel que guarda se o jogo foi ganhou ou nao. 
     */
    public boolean youWin; 
    
    /**
     * definição da variavel que recebe true quando o jogo foi perdido. 
     */
    public boolean gameIsOver; 
    
    /**
     * definição da variavel que armazena se o jogo continua rodando ou nao . 
     */
    public boolean gameOn; 
    
    /**
     * definicao da direção do invasor. 
     */
    public int direcao; 
    
    /**
     * variaveis auxiliares. 
     */
    int i, k, j; 
    
    /**
     * aarmazena a pontuação. 
     */
    public int pontuacao = 0; 
    
    /**
     * armazena a quantidade de barreiras destruidas para o calulo da pontuação. 
     */
    public int barreirasDestruidas = 0; 
    
    /**
     * Construtor da engine do jogo 
     * elementos que compoem:
     * @param handler
     */
    public Engine(Handler handler, GraphicsContext gc){
        
        Thread game = new Thread(this);
        gameOn = true; 
        
        this.gc = gc; 
        this.handler = handler;
        
        nave = new Nave(handler);
        
        tiros = new ArrayList<>();
        tiroInvasor = new ArrayList<>();
        
        invasores = new ArrayList<>();
    
        for(i = 0; i < 55; i++){
            invasores.add(new Invasor( 50 + i%11*60  , 50 + i/11*60, 1, handler));
        }
        
        fundo = new PlanoDeFundo(handler); 
        
        barreiras = new ArrayList<>();
       
        
        for(i = 1; i<= 5; i++){
            for( j = 0; j<3; j++){
                for (k = 0; k<8; k++){
                    barreiras.add(new Barreira(((i*273) - 64 + 16*k), (Y - 200) + 16*j, handler));
                }
            }
        }
        
        gameIsOver = false; 
        youWin = false; 
        
        keyboard = new KeyboardHandler(handler);
        game.start();
    }
    
    /**
     * o metodo Run roda todos os componentes do jogo, assim que o jogo comeca gameRun rece true e o jogo começa a rodar.
     * 
     */
    @Override
    public void run() {
        
        while(gameOn){
            long tempoInicial = System.currentTimeMillis();
            update();
            render(gc);
            long tempoFinal = System.currentTimeMillis();
            long dif = 16 - (tempoFinal - tempoInicial); 
            
            if(dif > 0){
                sleep(dif);
            }
        }
        
        gc.clearRect(0, 0, X, Y);
        if(gameIsOver){
            gc.drawImage(handler.getAnexos().gameOver, 0, 0, X, Y);
            gc.setFont(Font.font (35));
            gc.strokeText("PONTOS: " + ((pontuacao*10) - barreirasDestruidas) + " ", X/2 - 100 , Y - 200);
        }
        if(youWin){
            gc.drawImage(handler.getAnexos().youWin, 0, 0, X, Y);
            gc.setFont(Font.font (35));
            gc.strokeText("PONTOS: " + ((pontuacao*10) - barreirasDestruidas) + " ", X/2 - 100, Y - 200);
        }
            
    }
    
    /**
     * define um intervalo para o jogo. 
     * @param duracao 
     */
    public void sleep(long duracao){
        try{
            Thread.sleep(duracao);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    /**
     * atualiza os elementos do jogo constantemente 
     * Ao pressionar SPACE, o tiro deve ser executado, renderizado e atualizado. 
     * 
     */
    public void update(){
            
            //atualiza o teclado 
            handler.getKeyboard().update();
            
            //atualiza a nave 
            handler.getNave().update();
            
            //atualiza as barreiras
            for(i = 0; i<barreiras.size(); i++){
                barreiras.get(i).update();
            }
            
            //atualiza o tiro do invasor 
            for(i = 0; i<tiroInvasor.size(); i++){
                tiroInvasor.get(i).update();   
            }

            for(i = 0; i < invasores.size(); i++){
                invasores.get(i).update();
                if(handler.getInvasor().tempoInvasor == 50){
                    tiroInvasor.add(invasores.get(new Random().nextInt(invasores.size())).invasorAtirar());
                    tiroInvasor.add(invasores.get(new Random().nextInt(invasores.size())).invasorAtirar());
                    tiroInvasor.add(invasores.get(new Random().nextInt(invasores.size())).invasorAtirar());
                    tiroInvasor.add(invasores.get(new Random().nextInt(invasores.size())).invasorAtirar());
                    i--;
                    handler.getInvasor().tempoInvasor = 0;
                }
            }


            // troca direção nos limites 
            for(i = 0; i< invasores.size(); i++){
                if(invasores.get(i).getX() <= 0 || invasores.get(i).getX() >=  X - 50){
                    for(int j = 0; j<invasores.size(); j++){
                        invasores.get(j).trocaDirecao();
                    }
                    break; 
                }
            }
            //verifica a posição de Y dos aliens, se passarem da barreira o jogo é perdido 
            for(i = 0; i < invasores.size(); i++){
                if(invasores.get(i).getY() >= Y - 200){
                    for(j = 0; j<invasores.size(); j++){
                        gameOn = false; 
                        gameIsOver = true;
                        break; 
                    }
                    break; 
                }
            }

            //ao pressionar a tecla de espaço 
            if(handler.getKeyboard().getAtirou()){
               tiros.add(handler.getNave().atirar());
            }

            //colisão entre tiros da nave e aliens 
            for(i = 0; i <tiros.size(); i++){
               tiros.get(i).update();
                if (tiros.get(i).destroy()){
                    tiros.remove(i);
                    i--; 
                }
                else{
                    for(int j = 0; j< invasores.size(); j++){
                        if(tiros.get(i).atingir(invasores.get(j))){
                            invasores.get(j).vivo = false; 
                            invasores.remove(j);
                            pontuacao ++; //aumenta a pontuação ao destruir um alien 
                            if(invasores.isEmpty()){
                                youWin = true; 
                                gameOn = false;
                                break; 
                            }
                            tiros.remove(i);
                            j--; 
                            break;
                        } 
                    }   
                }
            }
            //verifica se o tiro da nave atingiu a barreira 
            for(i = 0; i<tiros.size(); i++){
                for(j = 0; j< barreiras.size(); j++){
                    if(tiros.get(i).atingirBarreira(barreiras.get(j))){
                        barreiras.remove(j);
                        barreirasDestruidas++; 
                        tiros.remove(i);
                        j--; 
                        break; 
                    }
                }
            }
            
            //colisão entre tiros e nave
            for(i = 0; i <tiroInvasor.size(); i++){
               tiroInvasor.get(i).update();
                if (tiroInvasor.get(i).destroy()){
                    tiroInvasor.remove(i);
                    i--; 
                }
                else{
                    if(tiroInvasor.get(i).atingirNave(nave)){
                        nave.levarDano();
                        tiroInvasor.remove(i);
                        if(!nave.getVivo()){
                            gameOn = false; 
                            gameIsOver = true;
                        }
                        break;
                    }
                    for(j = 0; j < barreiras.size(); j++){
                        if(tiroInvasor.get(i).atingirBarreira(barreiras.get(j))){
                            barreiras.remove(j);
                            tiroInvasor.remove(i);
                            i--;
                            break; 
                        }
                    }
                }
            } 
    }
    
    /**
     * renderiza os elementos do jogo
     * @param gc 
     */
    public void render(GraphicsContext gc){
        
            handler.getFundo().render(gc);

            handler.getNave().render(gc);

            for(i = 0; i<tiros.size(); i++){
                tiros.get(i).render(gc);
            }

            for(i = 0; i<tiroInvasor.size(); i++){
                tiroInvasor.get(i).render(gc);
            }

             for(i = 0; i <invasores.size(); i++){
                invasores.get(i).render(gc);
            }
            
            for(i = 0; i<barreiras.size(); i++){
                barreiras.get(i).render(gc);
            }
           gc.setStroke(Color.RED);
           gc.setFont(Font.font (25));
           gc.strokeText("VIDAS: " + handler.getNave().vidaNave + " ", X - 250, Y - 800);
           gc.strokeText("PONTOS: " + ((pontuacao*10) - barreirasDestruidas) + " ", X - 450, Y - 800);
            
    }
 
}
