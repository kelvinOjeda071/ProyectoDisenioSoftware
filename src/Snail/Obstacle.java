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
public class Obstacle extends GameElement {
    private int tipoObstaculo;

    public Obstacle(int tipoObstaculo, Position posicion, int ancho, int largo) {
        super(posicion, ancho, largo);
        this.tipoObstaculo = tipoObstaculo;
    }

    

    @Override
    public void draw(Graphics grafico, int ancho, int largo) {
        
        ancho = this.width;
        largo = this.height;
        int posicionX = this.position.getX();
        int posicionY = this.position.getY();
        
        if(tipoObstaculo == 0){ //Plataforma
            grafico.setColor(Color.black);
            grafico.fillRect(posicionX, posicionY, ancho, largo);
            
            
        }
        
        if(tipoObstaculo == 1){ //Cajas
            grafico.setColor(Color.red);
            grafico.drawLine(posicionX, posicionY, ancho, largo);
        }
    }

    @Override
    public void move() {
        //System.out.print("Moviendo\n");
    }

 

   

    
    
    
}
