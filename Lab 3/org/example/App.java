package org.example;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class App extends JFrame {

    private JMyPanel panel;
    private Image image;

    private Room[][] rooms;
    private Player player;

    private final int rows = 3;
    private final int cols = 5;

    public App() {
        setTitle("Labirynt");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JMyPanel();
        add(panel);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleMove(e.getKeyCode());
            }
        });

        setFocusable(true);
        SwingUtilities.invokeLater(this::setupMaze);
    }

    private void setupMaze() {
        image = panel.getImage();
        rooms = new Room[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Room room = new Room();
                room.setX(j * MapSite.LENGTH + 50);
                room.setY(i * MapSite.LENGTH + 50);

                room.setSide(Directions.North, new Wall(Directions.North));
                room.setSide(Directions.South, new Wall(Directions.South));
                room.setSide(Directions.West, new Wall(Directions.West));
                room.setSide(Directions.East, new Wall(Directions.East));

                rooms[i][j] = room;
            }
        }

        rooms[0][1].setBomb(new Bomb());
        rooms[1][3].setBomb(new Bomb());
        rooms[2][2].setBomb(new Bomb());

        player = new Player(0, 0);
        redraw();
    }

    private void handleMove(int key) {
        switch (key) {
            case KeyEvent.VK_UP -> player.move(-1, 0, rows, cols);
            case KeyEvent.VK_DOWN -> player.move(1, 0, rows, cols);
            case KeyEvent.VK_LEFT -> player.move(0, -1, rows, cols);
            case KeyEvent.VK_RIGHT -> player.move(0, 1, rows, cols);
        }

        if (rooms[player.getRow()][player.getCol()].hasBomb()) {
            JOptionPane.showMessageDialog(this, "GAME OVER");
            System.exit(0);
        }

        redraw();
    }

    private void redraw() {
        Graphics g = image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                rooms[i][j].draw(image);

        player.draw(image, rooms[player.getRow()][player.getCol()]);
        panel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
