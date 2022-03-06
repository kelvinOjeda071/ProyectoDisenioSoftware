
package Tetris;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Tablero {
    JButton[][] matrix;
    JPanel tablero;
    int dimx = 10;
    int dimy = 20;

    public Tablero(JButton[][] matrix, JPanel tablero) {
        this.matrix = matrix;
        this.tablero = tablero;
    }
    
    JButton[][] dibujar(){
        JButton[][] matriz = new JButton[dimx][dimy];
        for (int x = 0; x < dimx; x++) {
            for (int y = 0; y < dimy; y++) {
                matriz[x][y] = new JButton();
                matriz[x][y].setBackground(new Color(240, 240, 240));
                this.tablero.add(matriz[x][y], new org.netbeans.lib.awtextra.AbsoluteConstraints(x * 30, y * 30, 35, 35));
            }
        }
        return matriz;
    }
    
}
