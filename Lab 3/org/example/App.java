package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JMyPanel panel;
    private Image image;

    public App() {
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JMyPanel();

        JButton button = new JButton("Draw maze");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image = panel.getImage();
                drawMaze();
                panel.repaint();
            }
        });

        setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel(new GridLayout(1, 1));
        menuPanel.add(button);
        add(menuPanel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    private void drawMaze() {
        int rows = 3;
        int cols = 5;

        Room[][] rooms = new Room[rows][cols];

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

        // drzwi między pokojami
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                Door door = new Door(Directions.East, true);
                rooms[i][j].setSide(Directions.East, door);
                rooms[i][j + 1].setSide(Directions.West, door);
            }
        }

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                Door door = new Door(Directions.South, true);
                rooms[i][j].setSide(Directions.South, door);
                rooms[i + 1][j].setSide(Directions.North, door);
            }
        }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                rooms[i][j].draw(image);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new App().setVisible(true));
    }
}
