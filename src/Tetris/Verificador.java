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


public class Verificador {
    //JButton[][] matrixes;
    Timer paso;
    TimerTask baja;
    Figura figura;
    Figura figura1;
    Random random = new Random();
    int dimx = 10;
    int dimy = 20;
    int cont = 0;
    //Clip clip;
    
    public void Verificador(JButton[][] matrix, JButton[][] matrix1) {
        
        figura = new L(matrix);
        figura.dibujar();
        figura.bajar();
        
        figura1 = new L(matrix1);
        figura1.dibujar();
        
        paso = new Timer();
        baja = new TimerTask() {
            @Override
            public void run() {
                /*if (!clip.isActive()) try {
                    clip.start();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }*/

                for (int x = 0; x < dimx; x++) {
                    if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                        cont++;
                    }
                }
                // Funcion para saber si se perdió en el juego
                if (cont > 5) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Has perdido\n"
                            + "Fin.\n", "Fin del juego", javax.swing.JOptionPane.OK_OPTION);
                    paso.cancel();
                    
                    cont = 0;
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
                
                // Función que genera la siguiente figura al azar
                int r = (int) (random.nextFloat() * 6);
                if (figura.estaDetenida) {
                    if (r == 0) {
                        figura = new I(matrix);
                        figura.dibujar();
                    }
                    if (r == 1) {
                        figura = new O(matrix);
                        figura.dibujar();
                    }
                    if (r == 2) {
                        figura = new Z(matrix);
                        figura.dibujar();
                    }
                    if (r == 3) {
                        figura = new L(matrix);
                        figura.dibujar();
                        
                        figura1 = new L(matrix);
                        figura1.dibujar();
                    }
                    if (r == 4) {
                        figura = new T(matrix);
                        figura.dibujar();
                    }
                    if (r == 5) {
                        figura = new S(matrix);
                        figura.dibujar();
                    }
                } else {
                    figura.dibujar();
                    figura.bajar();
                    cont = 0;
                }
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
        paso.schedule(baja, 0, 500);
    }
    /*public void bajarB(){
        figura.bajar();
    }
    public void moverDerechaB(){
        figura.moverDerecha();
    }
    public void moverIzquierdaB(){
        figura.moverIzquierda();
    }
    public void rotarB(){
        figura.rotar();
    }*/
    
    public void movimientoControles(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode() == KeyEvent.VK_S) {
            figura.bajar();
        }
        if (evt.getKeyCode() == KeyEvent.VK_D) {
            figura.moverDerecha();
        }
        if (evt.getKeyCode() == KeyEvent.VK_A) {
            figura.moverIzquierda();
        }
        if (evt.getKeyCode() == KeyEvent.VK_W) {
            figura.rotar();
        }
    }
    
    public void comenzar(java.awt.event.ActionEvent evt, JButton[][] matrix, JButton[][] matrix1){
        figura = new L(matrix);
        figura.bajar();
        
        figura1 = new L(matrix1);
        
        paso = new Timer();

        baja = new TimerTask() {
            @Override
            public void run() {
                for (int x = 0; x < dimx; x++) {
                    if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                        cont++;
                    }
                }

                if (cont > 5) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Has perdido\n"
                            + "Fin.\n", "Fin del juego", javax.swing.JOptionPane.OK_OPTION);
                    paso.cancel();
                    cont = 0;
                    return;
                }

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

                int r = (int) (random.nextFloat() * 6);

                if (figura.estaDetenida) {
                    if (r == 0) {
                        figura = new I(matrix);
                        figura.dibujar();
                    }
                    if (r == 1) {
                        figura = new O(matrix);
                        figura.dibujar();
                    }
                    if (r == 2) {
                        figura = new Z(matrix);
                        figura.dibujar();
                    }
                    if (r == 3) {
                        figura = new L(matrix);
                        figura.dibujar();
                        
                        figura1 = new L(matrix1);
                        figura1.dibujar();
                    }
                    if (r == 4) {
                        figura = new T(matrix);
                        figura.dibujar();
                    }
                    if (r == 5) {
                        figura = new S(matrix);
                        figura.dibujar();
                    }
                } else {
                    figura.bajar();
                    figura.dibujar();
                    cont = 0;
                }

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
        paso.schedule(baja, 0, 500);
    }
    
    public static void comerzarAccion(JPanel Tablero){
    
    }
    
    Verificador() {
    }
}
