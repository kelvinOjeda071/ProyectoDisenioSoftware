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
    //private Jugador jugador;
    private Nivel nivel;

   
    public SnailGame(boolean estado/*Jugador jugador, Nivel nivel*/) throws HeadlessException {
        this.estado = false;
        //this.jugador = jugador;
        nivel = new Nivel();
    }

    public SnailGame(boolean estado, Jugador jugador, Nivel nivel, GraphicsConfiguration gc) {
        super(gc);
        this.estado = estado;
        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public SnailGame(boolean estado, Jugador jugador, Nivel nivel, String title) throws HeadlessException {
        super("Snail");
        this.estado = estado;
        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public SnailGame(boolean estado, Jugador jugador, Nivel nivel, String title, GraphicsConfiguration gc) {
        super("Snail", gc);
        this.estado = estado;
        //this.jugador = jugador;
        this.nivel = nivel;
    }

    public void iniciarJuego() throws InterruptedException, IOException{
        Posicion posicionCaracol = new Posicion(1, 1);
        Posicion posicionPlataforma1 = new Posicion(0, 150);
        Posicion posicionPlataforma2 = new Posicion(500, 300);

        this.setTitle("Snail");
       
        Caracol caracol = new Caracol(posicionCaracol, 100, 100 );
        Obstaculo plataforma1 = new Obstaculo(0, posicionPlataforma1, 400, 50);
        Obstaculo plataforma2 = new Obstaculo(0, posicionPlataforma2, 300, 50);

        
        ListaElementos lista = new ListaElementos();
        lista.agregarElemento(caracol);
        lista.agregarElemento(plataforma1);
        lista.agregarElemento(plataforma2);

        
        Teclado teclado = new Teclado(caracol);
        nivel = new Nivel(lista, teclado);
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
