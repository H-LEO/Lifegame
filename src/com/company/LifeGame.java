package com.company;

public class LifeGame implements LifeGameInterface{
    private GameMapInterface map;
    private int row;
    private int col;

    public LifeGame(long life_init_ratio, GameMapInterface map) {
        this.row = map.getRow();
        this.col = map.getCol();
        this.map = map;
        this.map.reset(life_init_ratio);
    }

    public void game_cycle() {
        GameMap new_map = new GameMap(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean now = map.get(i, j);
                int cnt = map.get_neighbor_count(i, j);
                switch (cnt) {
                    case 2:
                        break;
                    case 3:
                        now = true;
                        break;
                    default:
                        now = false;
                }
                new_map.set(i, j, now);
            }
        }
        map.copy(new_map);
    }
}
