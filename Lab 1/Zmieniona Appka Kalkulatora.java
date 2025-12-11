import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyApp extends JFrame {
    private JTextField screen;
    private JButton button_1 = new JButton("1");
    private JButton button_2 = new JButton("2");
    private JButton button_3 = new JButton("3");
    private JButton button_4 = new JButton("4");
    private JButton button_5 = new JButton("5");
    private JButton button_6 = new JButton("6");
    private JButton button_7 = new JButton("7");
    private JButton button_8 = new JButton("8");
    private JButton button_9 = new JButton("9");
    private JButton button_0 = new JButton("0");
    private JButton button_add = new JButton("+");
    private JButton button_substract = new JButton("-");
    private JButton button_divide = new JButton("/");
    private JButton button_multiply = new JButton("*");
    private JButton button_equal = new JButton("=");
    private JButton button_C = new JButton("C");
    private JButton button_backspace = new JButton("<-");

    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public MyApp() {
        JPanel panel = new JPanel(new BorderLayout());
        screen = new JTextField(10);
        screen.setHorizontalAlignment(JTextField.RIGHT);
        panel.add("North", screen);

        JPanel panelButtons = new JPanel(new GridLayout(5, 4));

        JButton[] buttons = {
            button_7, button_8, button_9, button_divide,
            button_4, button_5, button_6, button_multiply,
            button_1, button_2, button_3, button_substract,
            button_0, button_C, button_backspace, button_add,
            button_equal
        };

        for (JButton b : buttons) {
            panelButtons.add(b);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String cmd = ((JButton)e.getSource()).getText();
                    if ("0123456789".contains(cmd)) {
                        if (startNewNumber) {
                            screen.setText(cmd);
                            startNewNumber = false;
                        } else {
                            screen.setText(screen.getText() + cmd);
                        }
                    } else if ("+-*/".contains(cmd)) {
                        try {
                            firstNumber = Double.parseDouble(screen.getText());
                        } catch (Exception ex) {
                            firstNumber = 0;
                        }
                        operator = cmd;
                        startNewNumber = true;
                    } else if (cmd.equals("=")) {
                        try {
                            double secondNumber = Double.parseDouble(screen.getText());
                            double result = calculate(firstNumber, secondNumber, operator);
                            screen.setText("" + result);
                        } catch (Exception ex) {
                            screen.setText("Error");
                        }
                        startNewNumber = true;
                    } else if (cmd.equals("C")) {
                        screen.setText("");
                        firstNumber = 0;
                        operator = "";
                        startNewNumber = true;
                    } else if (cmd.equals("<-")) {
                        String text = screen.getText();
                        if (text.length() > 0) {
                            screen.setText(text.substring(0, text.length() - 1));
                        }
                    }
                }
            });
        }

        panel.add("Center", panelButtons);
        setContentPane(panel);
        pack();
        setVisible(true);
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b != 0 ? a / b : 0;
            default: return b;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyApp();
            }
        });
    }
}
