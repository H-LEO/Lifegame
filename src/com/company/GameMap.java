package com.company;

import java.util.Random;

public class GameMap implements GameMapInterface{
    private boolean[][] cell;
    private int row;
    private int col;

    // private ArrayList<ArrayList<Boolean>> cell;
    public GameMap(int row, int col) {
        cell = new boolean[row][col];
        this.row = row;
        this.col = col;
    }

    public boolean[][] getCell() {
        return cell;
    }

    public void setCell(boolean[][] cell){
        this.cell = cell;
        row = cell.length;
        col = cell[0].length;
    }

    public void reset(long Life_ratio) {
        Random r = new Random(Life_ratio);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cell[i][j] = r.nextBoolean();
            }
        }
    }

    public Integer get_neighbor_count(int row, int col) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            System.err.println("Point at (" + row + "," + col + ") out of range!");
            return null;
        }
        int ans = 0;
        ans += get(row - 1, col - 1) ? 1 : 0;
        ans += get(row - 1, col) ? 1 : 0;
        ans += get(row - 1, col + 1) ? 1 : 0;
        ans += get(row, col - 1)   ? 1 : 0;
        ans += get(row, col + 1)   ? 1 : 0;
        ans += get(row + 1, col - 1)  ? 1 : 0;
        ans += get(row + 1, col)  ? 1 : 0;
        ans += get(row + 1, col + 1)  ? 1 : 0;
        return ans;
    }

    public void set(int row, int col, boolean val) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            System.err.println("Point at (" + row + "," + col + ") out of range!");
            return;
        }
        cell[row][col] = val;
    }

    public Boolean get(int row, int col) {
        if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
            return false;
        }
        return cell[row][col];
    }

    public void copy(GameMap neww) {
        this.cell = neww.cell.clone();
        this.col = neww.col;
        this.row = neww.row;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }
}
