package calculator;

import operator.Operator;
import printer.Printer;
import history.History;
import history.Operation;

import java.util.List;

public class MathCalculator implements Calculator {

    private final Printer printer;
    private final History history;

    public MathCalculator(Printer printer, History history) {
        this.printer = printer;
        this.history = history;
    }

    @Override
    public void calculate(double first, double second, Operator operator) {
        double result;

        switch (operator) {
            case SUM -> result = first + second;
            case SUBTRACTION -> result = first - second;
            case DIVIDE -> result = first / second;
            case MULTIPLY -> result = first * second;
            default -> throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }

        Operation operation = new Operation(first, second, operator.getValue(), result);
        history.addOperation(operation);
        printer.print(result);
    }

    public List<Operation> getHistory() {
        return history.getOperations();
    }
}
