package Snail;


import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.IOException;
import javax.swing.JFrame;

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
    private boolean estado;
    //private Player jugador;
    private Escene nivel;

   
    public SnailGame(boolean estado/*Player jugador, Escene nivel*/) throws HeadlessException {
        this.estado = false;
        //this.jugador = jugador;
        nivel = new Escene();
    }

    public SnailGame(boolean estado, Player jugador, Escene nivel, GraphicsConfiguration gc) {
        super(gc);
        this.estado = estado;
        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public SnailGame(boolean estado, Player jugador, Escene nivel, String title) throws HeadlessException {
        super("Snail");
        this.estado = estado;
        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public SnailGame(boolean estado, Player jugador, Escene nivel, String title, GraphicsConfiguration gc) {
        super("Snail", gc);
        this.estado = estado;
        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public void iniciarJuego() throws InterruptedException, IOException{
        Position posicionCaracol = new Position(1, 1);
        Position posicionPlataforma1 = new Position(0, 150);
        Position posicionPlataforma2 = new Position(500, 300);

        this.setTitle("Snail");
       
        Snail caracol = new Snail(posicionCaracol, 100, 100 );
        Obstacle plataforma1 = new Obstacle(0, posicionPlataforma1, 400, 50);
        Obstacle plataforma2 = new Obstacle(0, posicionPlataforma2, 300, 50);

        
        ElementsList lista = new ElementsList();
        lista.agregarElemento(caracol);
        lista.agregarElemento(plataforma1);
        lista.agregarElemento(plataforma2);

        
        Teclado teclado = new Teclado(caracol);
        nivel = new Escene(lista, teclado);
        this.estado = true;
        this.add(nivel);
        this.setSize(800, 600);
        this.setVisible(estado);
        this.setLocation(600,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (estado) 
        {
	this.nivel.actualizar();
        this.repaint();
	Thread.sleep(10);
        
        }
        
    }
   
}
