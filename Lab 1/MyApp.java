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
    private JTextField screen;   // pole tektowe pełniące rolę wyświetlacza
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

    public MyApp() {
      JPanel panel = new JPanel(new BorderLayout());
      screen = new JTextField(10);
      panel.add("North", screen);
      JPanel panelButtons = new JPanel(new GridLayout(5, 4)); 
        // menadżer rozkładu z 5 wierszami i czterema kolumnami
      button_9.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            screen.setText( screen.getText() + "9"); // dodajemy 9 do aktualnego testu z wyświetlacza
        }
        
      });  
      panelButtons.add(button_9); 

      panelButtons.add(button_8);
      button_8.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = screen.getText();  // odczytujemy tekst z wyświetlacza
            screen.setText( text + "8   "); // dodajemy 8 do aktualnego testu z wyświetlacza

        }
      });  
      panelButtons.add(button_7);
      button_divide.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = screen.getText();  // odczytujemy tekst z wyświetlacza
            if (!text.equals("")){
               int valueOne = Integer.parseInt(text);
            }
        }
        
      });  
      panelButtons.add(button_divide);
      panelButtons.add(button_6);
      panelButtons.add(button_5);
      panelButtons.add(button_4);
      panelButtons.add(button_multiply);
      panelButtons.add(button_3);
      panelButtons.add(button_2);
      panelButtons.add(button_1);
      panelButtons.add(button_substract);
      panelButtons.add(button_C);
      panelButtons.add(button_0);
      panelButtons.add(button_backspace);
      panelButtons.add(button_add);
      panelButtons.add(new JLabel());
      panelButtons.add(new JLabel());
      panelButtons.add(new JLabel());
      panelButtons.add(button_equal);
      panel.add("Center", panelButtons); // wstawienie panelu z przyciskami na panel
      setContentPane(panel); // ustawienie głównego panelu aplikacji
      pack();   // dopasowanie rozmiaru okienka aplikacji do zawartości
      setVisible(true);
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