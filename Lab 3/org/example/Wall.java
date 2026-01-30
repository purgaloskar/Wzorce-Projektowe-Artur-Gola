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
            case North -> g.drawLine(x, y, x + LENGTH, y);
            case South -> g.drawLine(x, y + LENGTH, x + LENGTH, y + LENGTH);
            case West -> g.drawLine(x, y, x, y + LENGTH);
            case East -> g.drawLine(x + LENGTH, y, x + LENGTH, y + LENGTH);
        }
    }
}
