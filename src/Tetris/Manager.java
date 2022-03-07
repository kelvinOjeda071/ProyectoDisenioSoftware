package Tetris;

import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JPanel;


public class Manager {
    //JButton[][] matrixes;
    Timer step;
    TimerTask down;
    Figure figure;
    Figure figure1;
    Random random = new Random();
    Random random1 = new Random();
    int dimx = 10;
    int dimy = 20;
    int counter = 0;
    JPanel table;
    int r=0;
    //Clip clip;
    Manager() {
        //this.table = table;
    }
    
    public void Manager(JButton[][] matrix, JPanel table) {
        figure = new L(matrix);
        figure.draw();
        figure.goDown();
        
        Table ta = new Table(matrix,table);
        r=(int) (random.nextFloat() * 6);
        //figura1 = new L(matrix1);
        //figura1.draw();
        
        step = new Timer();
        down = new TimerTask() {
            @Override
            public void run() {
                /*if (!clip.isActive()) try {
                    clip.start();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }*/

                for (int x = 0; x < dimx; x++) {
                    if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                        counter++;
                    }
                }
                // Funcion para saber si se perdió en el juego
                if (counter > 5) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Has perdido\n"
                            + "Fin.\n", "Fin del juego", javax.swing.JOptionPane.OK_OPTION);
                    step.cancel();
                    
                    counter = 0;
                    return;
                }
                // Función para saber si 
                for (int y = 0; y < dimy; y++) {
                    boolean completo = true;
                    for (int x = 0; x < dimx; x++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            completo = false;
                        }
                    }
                    if (completo) {

                        for (int z = y; z > 0; z--) {
                            for (int j = 0; j < dimx; j++) {
                                matrix[j][z].setBackground(matrix[j][z - 1].getBackground());
                            }
                        }

                    }

                }
                
                // Función que genera la siguiente figure al azar
                
                /*if(i==0){
                    r = (int) (random.nextFloat() * 6);
                }
                i++;*/
                int ra = (int) (random1.nextFloat() * 6);
                //int uno=r;
                if (figure.isStopped) {
                    if (r == 0) {
                        ta.di(ra);
                        figure = new I(matrix);
                        figure.draw();
                    }
                    if (r == 1) {
                        ta.di(ra);
                        figure = new O(matrix);
                        figure.draw();
                    }
                    if (r == 2) {
                        ta.di(ra);
                        figure = new Z(matrix);
                        figure.draw();
                        
                    }
                    if (r == 3) {
                        ta.di(ra);
                        figure = new L(matrix);
                        figure.draw();
                        //ta.di(r);
                        //figura1 = new L(matrix);
                        //figura1.draw();
                    }
                    if (r == 4) {
                        ta.di(ra);
                        figure = new T(matrix);
                        figure.draw();
                    }
                    if (r == 5) {
                        ta.di(ra);
                        figure = new S(matrix);
                        figure.draw();
                    }
                } else {
                    figure.draw();
                    figure.goDown();
                    counter = 0;
                }
                r=ra;
                // Las celdas del tablero ya no son visibles una vez se rellenan
                // con un objeto
                for (int x = 0; x < dimx; x++) {
                    for (int y = 0; y < dimy; y++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            matrix[x][y].setVisible(false);
                        } else {
                            matrix[x][y].setVisible(true);
                        }
                    }
                }

            }
        };
        step.schedule(down, 0, 500);
    }
    /*public void bajarB(){
        figure.goDown();
    }
    public void moverDerechaB(){
        figure.moveRight();
    }
    public void moverIzquierdaB(){
        figure.moveLeft();
    }
    public void rotarB(){
        figure.rotate();
    }*/
    
    public void movementsControl(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode() == KeyEvent.VK_S) {
            figure.goDown();
        }
        if (evt.getKeyCode() == KeyEvent.VK_D) {
            figure.moveRight();
        }
        if (evt.getKeyCode() == KeyEvent.VK_A) {
            figure.moveLeft();
        }
        if (evt.getKeyCode() == KeyEvent.VK_W) {
            figure.rotate();
        }
    }
    
    public void begin(JButton[][] matrix, JPanel table){
        step.cancel();
        //Tablero.removeAll();
        //cont = 0;
        
        figure = new L(matrix);
        figure.goDown();
        
        Table ta = new Table(matrix,table);
        r=(int) (random.nextFloat() * 6);
        //figura1 = new L(matrix1);
        //Tabla ta = new Table(matrix,table);
        step = new Timer();

        down = new TimerTask() {
            @Override
            public void run() {
                for (int x = 0; x < dimx; x++) {
                    if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                        counter++;
                    }
                }

                if (counter > 5) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Has perdido\n"
                            + "Fin.\n", "Fin del juego", javax.swing.JOptionPane.OK_OPTION);
                    step.cancel();
                    counter = 0;
                    return;
                }

                for (int y = 0; y < dimy; y++) {
                    boolean isComplete = true;
                    for (int x = 0; x < dimx; x++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            isComplete = false;
                        }
                    }
                    if (isComplete) {
                        for (int z = y; z > 0; z--) {
                            for (int j = 0; j < dimx; j++) {
                                matrix[j][z].setBackground(matrix[j][z - 1].getBackground());
                            }
                        }
                        
                    }

                }

                int ra = (int) (random1.nextFloat() * 6);

                if (figure.isStopped) {
                    if (r == 0) {
                        ta.di(ra);
                        figure = new I(matrix);
                        figure.draw();
                    }
                    if (r == 1) {
                        ta.di(ra);
                        figure = new O(matrix);
                        figure.draw();
                    }
                    if (r == 2) {
                        ta.di(ra);
                        figure = new Z(matrix);
                        figure.draw();
                    }
                    if (r == 3) {
                        ta.di(ra);
                        figure = new L(matrix);
                        figure.draw();
                        
                    }
                    if (r == 4) {
                        ta.di(ra);
                        figure = new T(matrix);
                        figure.draw();
                    }
                    if (r == 5) {
                        ta.di(ra);
                        figure = new S(matrix);
                        figure.draw();
                    }
                } else {
                    figure.goDown();
                    figure.draw();
                    counter = 0;
                }
                r=ra;
                for (int x = 0; x < dimx; x++) {
                    for (int y = 0; y < dimy; y++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            matrix[x][y].setVisible(false);
                        } else {
                            matrix[x][y].setVisible(true);
                        }
                    }
                }

            }
        };
        step.schedule(down, 0, 500);
    }
    
    public static void beginAction(JPanel Tablero){
    
    }
    
   
}