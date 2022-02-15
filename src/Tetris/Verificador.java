/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;

import java.awt.Color;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

/**
 *
 * @author Cris
 */
public class Verificador {

    JButton[][] matrixes;
    Timer paso;
    TimerTask baja;
    Random random = new Random();
    int contador;
    Figura figura;
    int dimx = 10;
    int dimy = 20;

    public Verificador(Figura figura, int contador) {
        this.figura = figura;
        this.contador = contador;
    }

    public int perder(int contador, JButton[][] matrix, Timer paso) {
        for (int x = 0; x < dimx; x++) {
            if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                contador++;
            }
        }
        if (contador > 5) {
            javax.swing.JOptionPane.showMessageDialog(null, "Has perdido\n"
                    + "Fin.\n", "Fin del juego", javax.swing.JOptionPane.OK_OPTION);
            paso.cancel();
            contador = 0;
            return contador;
        } else {
            return contador;
        }
    }

    public void estaCompleto(JButton[][] matrix) {
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
    }

    public void generarFigura(int contador, Figura figura, JButton[][] matrix) {
        int r = (int) (random.nextFloat() * 6);
        if (figura.estaDetenida) {
            switch (r) {
                case 0:
                    figura = new I(matrix);
                    figura.dibujar();
                    figura.bajar();
                    break;
                case 1:
                    figura = new O(matrix);
                    figura.dibujar();
                    figura.bajar();
                    break;
                case 2:
                    figura = new Z(matrix);
                    figura.dibujar();
                    figura.bajar();
                    break;
                case 3:
                    figura = new L(matrix);
                    figura.dibujar();
                    figura.bajar();
                    break;
                case 4:
                    figura = new T(matrix);
                    figura.dibujar();
                    figura.bajar();
                    break;
                case 5:
                    figura = new S(matrix);
                    figura.dibujar();
                    figura.bajar();
                    break;
                default:
                    break;
            }
        } else {
            figura.bajar();
            contador = 0;
        }
        
    }

    public void rellenar(JButton[][] matrix) {
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

    public void verificar(JButton[][] matrix, Timer paso) {
        baja = new TimerTask() {
            @Override
            public void run() {
                for (int x = 0; x < dimx; x++) {
                    if (!matrix[x][0].getBackground().equals(new Color(240, 240, 240))) {
                        contador++;
                    }
                }

                if (contador > 5) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Has perdido\n"
                            + "Fin.\n", "Fin del juego", javax.swing.JOptionPane.OK_OPTION);
                    paso.cancel();
                    contador = 0;
                    return;
                }

                for (int y = 0; y < dimy; y++) {
                    boolean estaCompleto = true;
                    for (int x = 0; x < dimx; x++) {
                        if (matrix[x][y].getBackground().equals(new Color(240, 240, 240))) {
                            estaCompleto = false;
                        }
                    }
                    if (estaCompleto) {
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
                    contador = 0;
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

    }

}
