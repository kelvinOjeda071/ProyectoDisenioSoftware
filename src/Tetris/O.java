
package Tetris;

import java.awt.Color;
import javax.swing.JButton;

public class O extends Figura {

    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    int x, y;

    public O(JButton[][] matriz) {
        super(matriz);
        estaDetenida = false;
        b1 = matriz[dimx / 2][0];
        b2 = matriz[dimx / 2][1];
        b3 = matriz[dimx / 2 + 1][0];
        b4 = matriz[dimx / 2 + 1][1];
        x = dimx / 2;
        y = 1;
    }
    
    @Override
    public void dibujar(){
        b1.setBackground(Color.BLUE);
        b2.setBackground(Color.BLUE);
        b3.setBackground(Color.BLUE);
        b4.setBackground(Color.BLUE);
    }
    
    @Override
    public void bajar() {

        if (estaDetenida) {
            return;
        }

        if (y >= dimy - 1) {
            estaDetenida = true;
            return;
        }

        if (!matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))) {
            estaDetenida = true;
            return;
        }
        if (!matrix[x + 1][y + 1].getBackground().equals(new Color(240, 240, 240))
                || !matrix[x][y + 1].getBackground().equals(new Color(240, 240, 240))) {
            estaDetenida = true;
            return;
        }

        b1.setBackground(new Color(240, 240, 240));
        b2.setBackground(new Color(240, 240, 240));
        b3.setBackground(new Color(240, 240, 240));
        b4.setBackground(new Color(240, 240, 240));

        y++;
        b1 = matrix[x][y - 1];
        b2 = matrix[x][y];
        b3 = matrix[x + 1][y - 1];
        b4 = matrix[x + 1][y];

        b1.setBackground(Color.BLUE);
        b2.setBackground(Color.BLUE);
        b3.setBackground(Color.BLUE);
        b4.setBackground(Color.BLUE);

    }

    @Override
    public void moverDerecha() {
        if (estaDetenida) {
            return;
        }
        if (x >= dimx - 1) {
            return;
        }

        if ((x + 1 >= dimx - 1)) {
            return;
        }

        b1.setBackground(new Color(240, 240, 240));
        b2.setBackground(new Color(240, 240, 240));
        b3.setBackground(new Color(240, 240, 240));
        b4.setBackground(new Color(240, 240, 240));

        x++;
        b1 = matrix[x][y - 1];
        b2 = matrix[x][y];
        b3 = matrix[x + 1][y - 1];
        b4 = matrix[x + 1][y];

        b1.setBackground(Color.BLUE);
        b2.setBackground(Color.BLUE);
        b3.setBackground(Color.BLUE);
        b4.setBackground(Color.BLUE);

    }

    @Override
    public void moverIzquierda() {
        if (estaDetenida) {
            return;
        }
        if (x - 1 < 0) {
            return;
        }
        if (x <= 0) {
            return;
        }

        b1.setBackground(new Color(240, 240, 240));
        b2.setBackground(new Color(240, 240, 240));
        b3.setBackground(new Color(240, 240, 240));
        b4.setBackground(new Color(240, 240, 240));

        x--;
        b4 = matrix[x][y - 1];
        b3 = matrix[x][y];
        b2 = matrix[x + 1][y - 1];
        b1 = matrix[x + 1][y];
        b1.setBackground(Color.BLUE);
        b2.setBackground(Color.BLUE);
        b3.setBackground(Color.BLUE);
        b4.setBackground(Color.BLUE);

    }

    @Override
    public void rotar() {;
    }

}
