package org.example;

import java.awt.*;

public class Room extends MapSite {
    private MapSite[] sides = new MapSite[4];

    public Room() {
        for (int i = 0; i < 4; i++)
            sides[i] = null;
    }

    public void setSide(Directions dir, MapSite site) {
        sides[dir.ordinal()] = site;
    }

    public MapSite getSide(Directions dir) {
        return sides[dir.ordinal()];
    }

    @Override
    public void draw(Image image) {
        int x = getX();
        int y = getY();
        for (int i = 0; i < 4; i++) {
            MapSite side = sides[i];
            if (side != null) {
                side.setX(x);
                side.setY(y);
                side.draw(image);
            }
        }
    }
}
