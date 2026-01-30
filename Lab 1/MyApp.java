import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyApp extends JFrame {

    private JTextField screen;
    private double firstValue = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public MyApp() {
        setTitle("Kalkulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== WYŚWIETLACZ =====
        screen = new JTextField("0");
        screen.setFont(new Font("Arial", Font.BOLD, 24));
        screen.setHorizontalAlignment(JTextField.RIGHT);
        screen.setEditable(false);
        screen.setBackground(new Color(30, 30, 30));
        screen.setForeground(Color.WHITE);
        screen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== PANEL PRZYCISKÓW =====
        JPanel panelButtons = new JPanel(new GridLayout(5, 4, 5, 5));
        panelButtons.setBackground(new Color(45, 45, 45));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== PRZYCISKI =====
        addButton(panelButtons, "7", e -> addDigit("7"));
        addButton(panelButtons, "8", e -> addDigit("8"));
        addButton(panelButtons, "9", e -> addDigit("9"));
        addOperatorButton(panelButtons, "/");

        addButton(panelButtons, "4", e -> addDigit("4"));
        addButton(panelButtons, "5", e -> addDigit("5"));
        addButton(panelButtons, "6", e -> addDigit("6"));
        addOperatorButton(panelButtons, "*");

        addButton(panelButtons, "1", e -> addDigit("1"));
        addButton(panelButtons, "2", e -> addDigit("2"));
        addButton(panelButtons, "3", e -> addDigit("3"));
        addOperatorButton(panelButtons, "-");

        addButton(panelButtons, "C", e -> clear(), new Color(200, 80, 80));
        addButton(panelButtons, "0", e -> addDigit("0"));
        addButton(panelButtons, "<-", e -> backspace());
        addOperatorButton(panelButtons, "+");

        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        addButton(panelButtons, "=", e -> calculate(), new Color(80, 160, 220));

        // ===== UKŁAD OKNA =====
        setLayout(new BorderLayout());
        add(screen, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ===== METODY LOGIKI =====
    private void addDigit(String digit) {
        if (startNewNumber) {
            screen.setText(digit);
            startNewNumber = false;
        } else {
            screen.setText(screen.getText() + digit);
        }
    }

    private void addOperator(String op) {
        firstValue = Double.parseDouble(screen.getText());
        operator = op;
        startNewNumber = true;
    }

    private void calculate() {
        double secondValue = Double.parseDouble(screen.getText());
        double result = 0;

        switch (operator) {
            case "+": result = firstValue + secondValue; break;
            case "-": result = firstValue - secondValue; break;
            case "*": result = firstValue * secondValue; break;
            case "/": result = secondValue != 0 ? firstValue / secondValue : 0; break;
        }

        screen.setText(String.valueOf(result));
        startNewNumber = true;
    }

    private void clear() {
        screen.setText("0");
        firstValue = 0;
        operator = "";
        startNewNumber = true;
    }

    private void backspace() {
        String text = screen.getText();
        if (text.length() > 1) {
            screen.setText(text.substring(0, text.length() - 1));
        } else {
            screen.setText("0");
            startNewNumber = true;
        }
    }

    // ===== METODY POMOCNICZE DO PRZYCISKÓW =====
    private void addButton(JPanel panel, String text, ActionListener action) {
        addButton(panel, text, action, new Color(70, 70, 70));
    }

    private void addButton(JPanel panel, String text, ActionListener action, Color bg) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(bg);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(action);
        panel.add(button);
    }

    private void addOperatorButton(JPanel panel, String op) {
        addButton(panel, op, e -> addOperator(op), new Color(100, 100, 160));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(MyApp::new);
    }
}
