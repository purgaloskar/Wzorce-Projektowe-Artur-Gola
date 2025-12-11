package org.example;

import java.awt.*;

public class Wall extends MapSite {
    private Directions direction;

    public Wall(Directions d) {
        this.direction = d;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        g.setColor(Color.BLUE);
        int x = getX();
        int y = getY();

        switch (direction) {
            case North:
                g.drawLine(x, y, x + MapSite.LENGTH, y);
                break;
            case South:
                g.drawLine(x, y + MapSite.LENGTH, x + MapSite.LENGTH, y + MapSite.LENGTH);
                break;
            case West:
                g.drawLine(x, y, x, y + MapSite.LENGTH);
                break;
            case East:
                g.drawLine(x + MapSite.LENGTH, y, x + MapSite.LENGTH, y + MapSite.LENGTH);
                break;
        }
    }
}
