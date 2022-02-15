
package Tetris;

import java.awt.Color;
import javax.swing.*;


public class I extends Figura {
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    int x, y;
    boolean estaHorizontal;

    public I(JButton[][] matriz) {
        super(matriz);
        estaHorizontal = false;
        estaDetenida = false;
        b1 = matriz[dimx / 2][0];
        b2 = matriz[dimx / 2][1];
        b3 = matriz[dimx / 2][2];
        b4 = matriz[dimx / 2][3];
        x = dimx / 2;
        y = 3;
    }
    
    @Override
    public void dibujar(){
        b1.setBackground(Color.red);
        b2.setBackground(Color.red);
        b3.setBackground(Color.red);
        b4.setBackground(Color.red);
    }
    
    @Override
    public void bajar() {

        if (estaDetenida) {
            return;
        }else if (y >= dimy - 1) {
            estaDetenida = true;
            return;
        }else if (!estaHorizontal && !matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))) {
            estaDetenida = true;
            return;
        }else if (estaHorizontal
                && (!matrix[x + 1][y + 1].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))
                || ((x - 1 > 0) && !matrix[x - 1][y + 1].getBackground().equals(new Color(240, 240, 240)))
                || ((x - 2 > 0) && !matrix[x - 2][y + 1].getBackground().equals(new Color(240, 240, 240))))) {
            estaDetenida = true;
            return;
        }else if (estaHorizontal) {

            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));
            y++;
            b1 = matrix[x + 1][y];
            b2 = matrix[x][y];
            b3 = matrix[x - 1][y];
            b4 = matrix[x - 2][y];

            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);

        } else {
            b1.setBackground(new Color(240, 240, 240));
            b1 = b2;
            b2 = b3;
            b3 = b4;
            b4 = matrix[x][++y];
            b4.setBackground(Color.red);
        }
    }

    @Override
    public void moverDerecha() {
        if (estaDetenida) {
            return;
        }
        if (x >= dimx - 1) {
            return;
        }
        if (!estaHorizontal
                && !matrix[x + 1][y].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x + 1][y - 1].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x + 1][y - 2].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x + 1][y - 3].getBackground().equals(new Color(240, 240, 240))) {
            return;
        } else if (estaHorizontal
                && (x + 1 >= dimx - 1)) {
            return;
        }
        if (estaHorizontal) {
            b1.setBackground(new Color(240, 240, 240));
            b1 = b2;
            b2 = b3;
            b3 = b4;
            b4 = matrix[++x][y];
            b4.setBackground(Color.red);

        } else {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            x++;

            b4 = matrix[x][y];
            b3 = matrix[x][y - 1];
            b2 = matrix[x][y - 2];
            b1 = matrix[x][y - 3];
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);

        }

    }

    @Override
    public void moverIzquierda() {
        if (estaDetenida) {
            return;
        }
        if (x - 1 < 0) {
            return;
        }
        if (!estaHorizontal
                && !matrix[x - 1][y].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 1].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 2].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 3].getBackground().equals(new Color(240, 240, 240))) {
            return;
        } else if (estaHorizontal
                && (x - 1 <= 1)) {
            return;
        }
        if (estaHorizontal) {
            b4.setBackground(new Color(240, 240, 240));
            b4 = b3;
            b3 = b2;
            b2 = b1;
            x--;
            b1 = matrix[x][y];
            b1.setBackground(Color.red);
        } else {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            x--;
            b4 = matrix[x][y];
            b3 = matrix[x][y - 1];
            b2 = matrix[x][y - 2];
            b1 = matrix[x][y - 3];
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);

        }

    }

    @Override
    public void rotar() {
        if (x + 1 > dimx - 1 || x - 2 < 0) {
            return;
        }

        if (!estaHorizontal && !matrix[x - 1][y].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 1].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 2].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x - 1][y - 3].getBackground().equals(new Color(240, 240, 240))) {
            return;
        } else if (estaHorizontal
                && (x - 1 <= 1)) {
            return;
        }
        if (estaHorizontal) {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b4 = matrix[x][y];
            b3 = matrix[x][y - 1];
            b2 = matrix[x][y - 2];
            b1 = matrix[x][y - 3];
            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);

        } else {
            b1.setBackground(new Color(240, 240, 240));
            b2.setBackground(new Color(240, 240, 240));
            b3.setBackground(new Color(240, 240, 240));
            b4.setBackground(new Color(240, 240, 240));

            b1 = matrix[x - 2][y];
            b2 = matrix[x - 1][y];
            b3 = matrix[x][y];
            b4 = matrix[x + 1][y];

            b1.setBackground(Color.red);
            b2.setBackground(Color.red);
            b3.setBackground(Color.red);
            b4.setBackground(Color.red);

        }

        estaHorizontal = !estaHorizontal;
    }

}
