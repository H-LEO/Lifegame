package com.company;

public interface GameMapInterface {

    void reset(long Life_ratio) ;

    Integer get_neighbor_count(int row, int col);

    void set(int row, int col, boolean val);

    Boolean get(int row, int col);

    void copy(GameMap neww);

    int getRow();

    int getCol();
}
