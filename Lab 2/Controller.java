import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;

        view.addButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();

                if ("0123456789".contains(cmd)) {
                    if (model.isStartNewNumber()) {
                        view.setScreenText(cmd);
                        model.setStartNewNumber(false);
                    } else {
                        view.setScreenText(view.getScreenText() + cmd);
                    }
                } else if ("+-*/".contains(cmd)) {
                    try {
                        model.setFirstNumber(Double.parseDouble(view.getScreenText()));
                    } catch(Exception ex) {
                        model.setFirstNumber(0);
                    }
                    model.setOperator(cmd);
                    model.setStartNewNumber(true);
                } else if (cmd.equals("=")) {
                    try {
                        double secondNumber = Double.parseDouble(view.getScreenText());
                        double result = model.calculate(model.getFirstNumber(), secondNumber, model.getOperator());
                        view.setScreenText("" + result);
                    } catch(Exception ex) {
                        view.setScreenText("Error");
                    }
                    model.setStartNewNumber(true);
                } else if (cmd.equals("C")) {
                    view.setScreenText("");
                    model.setFirstNumber(0);
                    model.setOperator("");
                    model.setStartNewNumber(true);
                } else if (cmd.equals("<-")) {
                    String text = view.getScreenText();
                    if (text.length() > 0) {
                        view.setScreenText(text.substring(0, text.length() - 1));
                    }
                }
            }
        });
    }
}
