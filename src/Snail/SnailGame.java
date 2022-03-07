package Snail;


import Snail.Input.Keyboard;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class SnailGame extends JFrame{
    
    private boolean state;
    //private Player jugador;
    private Escene nivel;
    private Keyboard keyboard;
    private Collision colision;
    //private Enemy enemy;

   
    public SnailGame(boolean estado/*Player jugador, Nivel nivel*/) throws HeadlessException {
        this.state = false;
        keyboard = new Keyboard();
        //this.jugador = jugador;
        nivel = new Escene();
    }

    public SnailGame(boolean estado, Player jugador, Escene nivel, GraphicsConfiguration gc) {
        super(gc);
        this.state = estado;
        keyboard = new Keyboard();
        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public SnailGame(boolean estado, Player jugador, Escene nivel, String title) throws HeadlessException {
        super("Snail");
        this.state = estado;
        keyboard = new Keyboard();

        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public SnailGame(boolean estado, Player jugador, Escene nivel, String title, GraphicsConfiguration gc) {
        super("Snail", gc);
        this.state = estado;
        keyboard = new Keyboard();

        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public void startGame() throws InterruptedException, IOException{
        Position posicionCaracol = new Position(1, 1);
        Position posicionPlataforma1 = new Position(0, 150);
        Position posicionPlataforma2 = new Position(500, 400);
        Position posicionPuerta1 = new Position(400, 0);
        Position positionEnemy = new Position(180,0);
        Position positionButon = new Position(300,140);
        Position positionPortal = new Position(900,340);

        this.setTitle("Snail");
        
       
        Snail caracol = new Snail(posicionCaracol, 100, 100 );
        Obstacle plataforma1 = new Obstacle(0, posicionPlataforma1, 50, 400);
        Obstacle plataforma2 = new Obstacle(0, posicionPlataforma2, 50, 400);
        Obstacle puerta1 = new Obstacle(1, posicionPuerta1, 200, 50);
        Button boton1 = new Button(positionButon, 10, 10);
        Enemy enemy = new Enemy(positionEnemy, 60, 60);
        Portal portal = new Portal(positionPortal, 100, 100);


        
        ElementsList lista = new ElementsList();
        lista.agregarElemento(caracol);
        lista.agregarElemento(plataforma1);
        lista.agregarElemento(plataforma2);
        lista.agregarElemento(enemy);
        lista.agregarElemento(boton1);
        lista.agregarElemento(portal);
        //lista.agregarElemento(puerta1);

        
        

        
        //this.keyboard = new Keyboard();
        nivel = new Escene(lista);

        nivel.addKeyListener(keyboard);
        this.state = true;
        this.add(nivel);
        this.setSize(1200, 800);
        this.setVisible(state);
        this.setLocation(600,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        while (state) 
        {
        this.nivel.actualizar();
        keyboard.update();
        this.repaint();
        
        for(int i = 1; i<lista.getLista().size(); i++){
            GameElement element = lista.getLista().get(i);
            colision = new Collision(caracol, element);
            colision.checkCollision();
            
        }

        if((enemy.atacarCaracol(caracol) == false)||(portal.notifyEnd(caracol) == false)){
            state = false;
        } 
        
        
        checkState();
        Thread.sleep(10);

        }
        
    }
   
    public void endGame(boolean state){
        if(state == false){
            JOptionPane.showMessageDialog(null, "Game Over", "GAME OVER", 1);
            exitMenu();
        }
    }
    
    public void checkState(){
        endGame(this.state);
        
    }
    
    public void exitMenu(){
       // this.setVisible(false);
        
    }
}
