package Snail;


import java.awt.Color;
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
public class Button extends GameElement {
    
    private Obstacle obstaculo;

    public Button(Position posicion, int height, int width) {
        super(posicion, height, width, 2);
    }
    
    private void activar(){
        
    }
    
    private void desactivar(){
        
    }


    @Override
    public void draw(Graphics grafico, int ancho, int largo) {
        height = this.height;
        width = this.width;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        height = this.height;
        width = this.width;
        grafico.setColor(Color.red);
        grafico.setColor(Color.red);
        grafico.fillRect(posicionX, posicionY, width, height);
    }

    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
