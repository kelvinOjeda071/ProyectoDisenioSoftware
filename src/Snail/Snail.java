package Snail;


import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import Input.Keyboard;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Snail extends ElementoDeJuego {

    private final ImageIcon imagen;
    int xFinal = 1;
    int yFinal = 1;


    public int getxFinal() {
        return xFinal;
    }

    public int getyFinal() {
        return yFinal;
    }

    
    public void setxFinal(int xFinal) {
        this.xFinal = xFinal;
    }

    public void setyFinal(int yFinal) {
        this.yFinal = yFinal;
    }
    

    
    public Snail(Posicion posicion, int ancho, int largo) throws IOException {
        super(posicion, ancho, largo);
        this.posicion.x = 1;
        this.posicion.y=1;
        this.imagen = new ImageIcon(getClass().getResource("/Snail/Imagenes/caracol.png"));
    }
    
    @Override
    public void dibujar(Graphics grafico, int ancho, int largo) {
        ancho = this.ancho;
        largo = this.largo;
        int posicionX = this.posicion.getX();
        int posicionY = this.posicion.getY();
        grafico.setColor(Color.red);
        grafico.drawImage(this.imagen.getImage(), posicionX, posicionY, ancho, largo, null);
        
    }

    public void girar() {

    }

    public void acelerar() {

    }

    @Override
    public void mover() {
                   
        int x0 = this.position.getX();
        int y0 = this.position.getY();
        
        
        if((0< y0) && (y0< 800)){
        this.position.setY(y0 + this.speedY);
        }
        
        
        
        
        if((x0>=0) && (x0<=1200)){
        if(Keyboard.RIGHT)
        {
            
            this.position.setX(x0 + this.speedX);
            }
            //this.position.setX(x0+2);
        }
  
        if((x0>=0) && (x0<=1200)){
        if(Keyboard.LEFT)
        {
            //girar();
            this.position.setX(x0-this.speedX);
            }
        } 
   
    }

}
