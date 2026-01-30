package org.example;

public class Room extends MapSite {

    private MapSite[] sides = new MapSite[4];
    private Bomb bomb;

    public void setSide(Directions dir, MapSite site) {
        sides[dir.ordinal()] = site;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    public boolean hasBomb() {
        return bomb != null;
    }

    @Override
    public void draw(java.awt.Image image) {
        int x = getX();
        int y = getY();

        for (MapSite side : sides) {
            if (side != null) {
                side.setX(x);
                side.setY(y);
                side.draw(image);
            }
        }

        if (bomb != null) {
            bomb.setX(x);
            bomb.setY(y);
            bomb.draw(image);
        }
    }
}
