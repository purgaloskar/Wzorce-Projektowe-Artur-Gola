package org.example;

import java.awt.*;
import javax.swing.*;

public class JMyPanel extends JPanel {

    private Image image;

    public Image getImage() {
        if (image == null)
            image = createImage(getWidth(), getHeight());
        return image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null)
            g.drawImage(image, 0, 0, this);
    }
}
