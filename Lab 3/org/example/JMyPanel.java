package org.example;

import java.awt.*;
import javax.swing.*;

public class JMyPanel extends JPanel {
    private Image image;

    public Image getImage() { return image; }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (image == null)
            image = createImage(getWidth(), getHeight());
        else
            g.drawImage(image, 0, 0, this);
    }
}
