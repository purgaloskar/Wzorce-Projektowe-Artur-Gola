package org.example;

import java.awt.*;

public class Bomb extends MapSite {

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        g.setColor(Color.RED);

        int r = MapSite.LENGTH / 3;

        g.fillOval(
                getX() + MapSite.LENGTH / 2 - r / 2,
                getY() + MapSite.LENGTH / 2 - r / 2,
                r,
                r
        );
    }
}
