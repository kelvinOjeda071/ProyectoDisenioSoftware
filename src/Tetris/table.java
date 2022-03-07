package Tetris;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Table {

    JButton[][] matrix;
    JPanel table;
    int ran;
    int dimx = 10;
    int dimy = 20;

    public Table(JButton[][] matrix, JPanel table) {
        this.matrix = matrix;
        this.table = table;
    }

    JButton[][] draw() {
        JButton[][] matrix = new JButton[dimx][dimy];
        for (int x = 0; x < dimx; x++) {
            for (int y = 0; y < dimy; y++) {
                matrix[x][y] = new JButton();
                matrix[x][y].setBackground(new Color(240, 240, 240));
                this.table.add(matrix[x][y], new org.netbeans.lib.awtextra.AbsoluteConstraints(x * 30, y * 30, 35, 35));//x * 30, y * 30, 35, 35
            }
        }
        return matrix;
    }

    public void di(int r) {
        //tabla.remove
        //Graphics  g = new Graphics();
        JButton b = new JButton();
        JButton c = new JButton();
        JButton d = new JButton();
        JButton e = new JButton();

        switch (r) {
            case 0://I
                table.removeAll();
                table.remove(b);
                table.remove(c);
                table.remove(d);
                table.remove(e);

                b.setBounds(5, 5, 30, 30);
                table.add(b);
                c.setBounds(5, 30, 30, 30);
                table.add(c);
                d.setBounds(5, 55, 30, 30);
                table.add(d);
                e.setBounds(5, 80, 30, 30);
                table.add(e);
                break;
            case 1://0
                table.removeAll();
                table.remove(b);
                table.remove(c);
                table.remove(d);
                table.remove(e);
                b.setBounds(5, 5, 30, 30);
                table.add(b);
                c.setBounds(30, 5, 30, 30);
                table.add(c);
                d.setBounds(5, 30, 30, 30);
                table.add(d);
                e.setBounds(30, 30, 30, 30);
                table.add(e);
                break;
            case 2://Z
                table.removeAll();
                table.remove(b);
                table.remove(c);
                table.remove(d);
                table.remove(e);
                b.setBounds(5, 5, 30, 30);
                table.add(b);
                c.setBounds(30, 5, 30, 30);
                table.add(c);
                d.setBounds(30, 30, 30, 30);
                table.add(d);
                e.setBounds(55, 30, 30, 30);
                table.add(e);
                break;
            case 3://L
                table.removeAll();
                table.remove(b);
                table.remove(c);
                table.remove(d);
                table.remove(e);
                b.setBounds(5, 5, 30, 30);
                table.add(b);
                c.setBounds(30, 5, 30, 30);
                table.add(c);
                d.setBounds(55, 5, 30, 30);
                table.add(d);
                e.setBounds(5, 30, 30, 30);
                table.add(e);
                break;
            case 4://T
                table.removeAll();
                table.remove(b);
                table.remove(c);
                table.remove(d);
                table.remove(e);
                b.setBounds(5, 5, 30, 30);
                table.add(b);
                c.setBounds(30, 5, 30, 30);
                table.add(c);
                d.setBounds(55, 5, 30, 30);
                table.add(d);
                e.setBounds(30, 30, 30, 30);
                table.add(e);
                break;
            case 5://S
                table.removeAll();
                table.remove(b);
                table.remove(c);
                table.remove(d);
                table.remove(e);
                b.setBounds(30, 5, 30, 30);
                table.add(b);
                c.setBounds(55, 5, 30, 30);
                table.add(c);
                d.setBounds(5, 30, 30, 30);
                table.add(d);
                e.setBounds(30, 30, 30, 30);
                table.add(e);
                break;
            default:
                break;
        }

    }
}
