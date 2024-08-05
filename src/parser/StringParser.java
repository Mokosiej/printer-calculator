package parser;

import calculator.Calculator;
import operator.Operator;

import java.util.Scanner;

public class StringParser implements Parser {

    private final Calculator calculator;
    private final Scanner scanner;

    public StringParser(Calculator calculator, Scanner scanner) {
        this.calculator = calculator;
        this.scanner = scanner;
    }

    @Override
    public void parse() {
        System.out.println("Введите выражение (например, 5 + 3):");
        String stringToCalculate = scanner.nextLine();
        String[] operands = stringToCalculate.split(" ");

        String firstOperand = operands[0];
        String secondOperand = operands[2];
        String operatorString = operands[1];

        Operator operator = Operator.findByString(operatorString);
        double first = Double.parseDouble(firstOperand);
        double second = Double.parseDouble(secondOperand);

        calculator.calculate(first, second, operator);
    }
}
