/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GraphicInterface;

import Engine.Engine;
import Engine.Handler;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author beatr
 */
public class Main extends Application {
    
    /**
     * valor do tamanho do eixo X.
     */
    public static final int X = 1820; 
    
    /**
     * valor do tamanho do eixo Y.
     */
    public static final int Y = 920; 
    
    /**
     * instancia do handler
     */
    Handler handler; 
    
    /**
     * instancia da engine do jogo 
     */
    Engine engine; 
    
    /**
     * instancia dos anexos do jogo
     */
    Anexos anexos; 
   
    /**
     * definição do canvas, janela e cena.
     * definção do inicio da thread do jogo e inicio da thread. 
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        
        Canvas canvas = new Canvas(X,Y);
        
        StackPane root = new StackPane(); 
        Scene janela = new Scene(root, X, Y);
        
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Space Invaders");
        
        primaryStage.setScene(janela);
        primaryStage.show();
        
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        /**
         * gerenciador de pacotes e classes do jogo 
         */
        handler = new Handler(root, gc, janela);
        
        /**
         * classe reservada para a organização e manipulação dos anexos imagens 
         */
        anexos = new Anexos(handler);
        
        /**
         * inicio da thread do jogo. 
         */
        Engine jogo = new Engine(handler, gc);
        Thread t = new Thread(engine);
        t.start();
        
         primaryStage.setOnCloseRequest((WindowEvent event) -> {
             Platform.exit();
             System.exit(0);
        });
    }
    
    /**
     * @param args the command line arguments
     * função main()
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
