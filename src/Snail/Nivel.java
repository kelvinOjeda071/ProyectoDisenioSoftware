package Snail;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bryan
 */
public class Nivel extends JPanel {

    ListaElementos lista;
    MyKeyListener listener;
    Teclado teclado;

    public Nivel() {
    }
   
    public Nivel(ListaElementos lista, Teclado teclado) {
        this.lista = lista;
        this.teclado = teclado;
        this.listener = new MyKeyListener(teclado);
        addKeyListener(listener);
        setFocusable(true);
        
    }
    
    void actualizar(){
       ElementoDeJuego elemento;
        for(int i = 0; i<lista.getLista().size(); i++){
            elemento =lista.getLista().get(i);
            elemento.mover();
            
            //elemento = null;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        ElementoDeJuego elemento;
        for(int i = 0; i<lista.getLista().size(); i++){
            elemento =lista.getLista().get(i);
            elemento.dibujar(g, elemento.getAncho(), elemento.getLargo());
            elemento = null;
        }
    }

}
