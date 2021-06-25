package com.company;

public class GamePaint implements GamePaintInterface{
    private final int row;
    private final int col;
    private GameMapInterface map;

    public GamePaint(GameMapInterface map) {
        this.map = map;
        this.row = map.getRow();
        this.col = map.getCol();
    }

    public void paint() {

        try {
            for (int i = 10; i >= 0; i--) {
                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println("出错了!");
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map.get(i, j)) {
                    System.out.print("⬜");
                } else {
                    System.out.print("⬛");
                }
            }
            System.out.println();
        }
    }

}
