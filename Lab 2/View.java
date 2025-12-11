import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame {
    private JTextField screen = new JTextField(10);
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

    public JButton[] getButtons() {
        return new JButton[] {
            button_7, button_8, button_9, button_divide,
            button_4, button_5, button_6, button_multiply,
            button_1, button_2, button_3, button_substract,
            button_0, button_C, button_backspace, button_add,
            button_equal
        };
    }

    public View() {
        JPanel panel = new JPanel(new BorderLayout());
        screen.setHorizontalAlignment(JTextField.RIGHT);
        panel.add("North", screen);

        JPanel panelButtons = new JPanel(new GridLayout(5, 4, 5, 5));
        JButton[] buttons = getButtons();
        for (JButton b : buttons) {
            panelButtons.add(b);
        }
        // uzupełnienie pustych miejsc w siatce 5x4
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());

        panel.add("Center", panelButtons);
        setContentPane(panel);
        setTitle("Kalkulator MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void addButtonListener(ActionListener listener) {
        for (JButton b : getButtons()) {
            b.addActionListener(listener);
        }
    }

    public void setScreenText(String text) {
        screen.setText(text);
    }

    public String getScreenText() {
        return screen.getText();
    }
}
