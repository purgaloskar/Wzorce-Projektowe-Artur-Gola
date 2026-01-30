package org.example;

import java.awt.*;

public class Player {

    private int row;
    private int col;

    public Player(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(int dr, int dc, int maxRows, int maxCols) {
        int nr = row + dr;
        int nc = col + dc;

        if (nr >= 0 && nr < maxRows && nc >= 0 && nc < maxCols) {
            row = nr;
            col = nc;
        }
    }

    public void draw(Image image, Room room) {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK);

        int x = room.getX();
        int y = room.getY();
        int s = MapSite.LENGTH / 3;

        g.fillRect(
                x + MapSite.LENGTH / 2 - s / 2,
                y + MapSite.LENGTH / 2 - s / 2,
                s,
                s
        );
    }
}
