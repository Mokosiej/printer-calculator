package history;

import java.time.LocalDateTime;

public class Operation {
    private final double firstOperand;
    private final double secondOperand;
    private final String operator;
    private final double result;
    private final LocalDateTime timestamp;

    public Operation(double firstOperand, double secondOperand, String operator, double result) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public String getOperator() {
        return operator;
    }

    public double getResult() {
        return result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("Operation: %.2f %s %.2f = %.2f at %s",
                firstOperand, operator, secondOperand, result, timestamp);
    }
}
