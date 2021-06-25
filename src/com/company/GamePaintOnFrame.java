package com.company;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GamePaintOnFrame extends JFrame implements GamePaintInterface{

    private final int row;
    private final int col;
    private final GameMapInterface map;
    private final JButton[][] buttons;
    public GamePaintOnFrame(GameMapInterface map) {
        this.map = map;
        this.row = map.getRow();
        this.col = map.getCol();

        buttons = new JButton[row][];
        for(int i =0; i < row; i++) {
            JButton[] but = new JButton[col];
            for (int j = 0; j < col; j++) {
                but[j] = new JButton();
                but[j].setBackground(Color.BLACK);
            }
            buttons[i] = but;
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(row,col,0,0));

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                panel.add(buttons[i][j]);
            }
        }
        this.add(panel);
        this.setSize(1000,1000);
        this.setTitle("LifeGame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void paint() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Color c1 = buttons[i][j].getBackground();
                Color c2 = map.get(i, j) ? Color.BLACK : Color.WHITE;
                if(!c1.equals(c2)){
                    buttons[i][j].setBackground(c2);
                }

            }
        }
    }
}
