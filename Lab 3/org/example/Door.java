package org.example;

import java.awt.*;

public class Door extends MapSite {
    private Directions direction;
    private boolean open;

    public Door(Directions d, boolean open) {
        this.direction = d;
        this.open = open;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        g.setColor(open ? Color.GREEN : Color.RED);

        int x = getX();
        int y = getY();

        switch (direction) {
            case North:
            case South:
                g.drawLine(x + 5, y, x + MapSite.LENGTH - 5, y);
                break;
            case East:
            case West:
                g.drawLine(x, y + 5, x, y + MapSite.LENGTH - 5);
                break;
        }
    }
}
