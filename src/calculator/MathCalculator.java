package calculator;

import operator.Operator;
import printer.Printer;
import history.Operation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MathCalculator implements Calculator {

    private final Printer printer;
    private final List<Operation> history;

    public MathCalculator(Printer printer) {
        this.printer = printer;
        this.history = new ArrayList<>();
    }

    @Override
    public void calculate(double first, double second, Operator operator) {
        cleanOldHistory();

        double result;

        switch (operator) {
            case SUM -> result = first + second;
            case SUBTRACTION -> result = first - second;
            case DIVIDE -> result = first / second;
            case MULTIPLY -> result = first * second;
            default -> throw new IllegalArgumentException("Неподдерживаемая операция: " + operator);
        }

        Operation operation = new Operation(first, second, operator.getValue(), result);
        history.add(operation);
        printer.print(result);
    }

    public List<Operation> getHistory() {
        return new ArrayList<>(history);
    }

    private void cleanOldHistory() {
        LocalDateTime now = LocalDateTime.now();
        history.removeIf(operation -> operation.getTimestamp().isBefore(now.minusHours(24)));
    }
}
