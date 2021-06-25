package com.company;

public class GameTimer {
    private final GameMapInterface map;
    private final GamePaintInterface paint;
    private final LifeGameInterface game;
    public GameTimer(GameMapInterface map,GamePaintInterface paint,LifeGameInterface game) {
        this.map=map;
        this.paint=paint;
        this.game=game;
    }

    public void start() {
        //死循环反复调用
        while (true) {
            game.game_cycle();
            paint.paint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
