package Tetris;

import javax.swing.JButton;

/**
 *
 * @author abel
 */
public abstract class Figura {

    JButton[][] matrix;
    int dimx, dimy;
    boolean estaDetenida;

    public Figura(JButton[][] matrix) {
        this.matrix = matrix;
        dimx = matrix.length;
        dimy = matrix[0].length;
        estaDetenida = false;
    }
    
    public abstract void dibujar();

    public abstract void bajar();

    public abstract void moverDerecha();

    public abstract void moverIzquierda();

    public abstract void rotar();

}
