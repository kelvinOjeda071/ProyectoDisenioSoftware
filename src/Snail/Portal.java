package Snail;


import java.awt.Graphics;
import java.awt.event.KeyEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Portal extends GameElement {
    private String tipo;

    public Portal(String tipo, Position posicion, int ancho, int largo) {
        super(posicion, ancho, largo);
        this.tipo = tipo;
    }


    @Override
    public void draw(Graphics grafico, int ancho, int largo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
