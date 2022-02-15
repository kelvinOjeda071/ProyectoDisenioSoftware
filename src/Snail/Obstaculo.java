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
public class Obstaculo extends ElementoDeJuego {
    private int tipoObstaculo;

    public Obstaculo(int tipoObstaculo, Posicion posicion, int ancho, int largo) {
        super(posicion, ancho, largo);
        this.tipoObstaculo = tipoObstaculo;
    }

    

    @Override
    public void dibujar(Graphics grafico, int ancho, int largo) {
        
        ancho = this.ancho;
        largo = this.largo;
        int posicionX = this.posicion.getX();
        int posicionY = this.posicion.getY();
        
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
    public void mover() {
        //System.out.print("Moviendo\n");
    }

 

   

    
    
    
}
