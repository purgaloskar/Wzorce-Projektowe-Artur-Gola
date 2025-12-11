public class Model {
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isStartNewNumber() {
        return startNewNumber;
    }

    public void setStartNewNumber(boolean startNewNumber) {
        this.startNewNumber = startNewNumber;
    }

    public double calculate(double a, double b, String op) {
        switch(op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b != 0 ? a / b : 0;
            default: return b;
        }
    }
}
