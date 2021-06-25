package com.company;

public class Main {
    public static void main(String[] arg) {
        int row = 100;
        int col = 100;

        GameMapInterface map = new GameMap(row, col);
        GamePaintInterface paint = new GamePaintOnFrame(map);
        LifeGameInterface game =new LifeGame(System.currentTimeMillis(),map);
        GameTimer timer = new GameTimer(map, paint, game);

        timer.start();
    }
}
