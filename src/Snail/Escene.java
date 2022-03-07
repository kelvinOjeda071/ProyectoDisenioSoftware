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
public class Escene extends JPanel {

    ElementsList list;
    GameElement element;

    public Escene() {
    }
   
    public Escene(ElementsList lista) {
        this.list = lista;
        setFocusable(true);
        
    }
    
    void actualizar(){
       GameElement elemento;
        for(int i = 0; i<list.getLista().size(); i++){
            elemento =list.getLista().get(i);
            elemento.move();
        }
    
    }
    public void paint(Graphics g) {
        super.paint(g);
        GameElement elemento;
        for(int i = 0; i<list.getLista().size(); i++){
            elemento =list.getLista().get(i);
            elemento.draw(g, elemento.getHeight(), elemento.getWidth());
            elemento = null;
        }
    }

}
