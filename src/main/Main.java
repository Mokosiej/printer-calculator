package main;

import calculator.MathCalculator;
import parser.StringParser;
import printer.ConsolePrinter;
import printer.FilePrinter;
import printer.Printer;
import history.History;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип вывода результата: 1 - Консоль, 2 - Файл");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        Printer printer;
        if (choice == 1) {
            printer = new ConsolePrinter();
        } else if (choice == 2) {
            printer = new FilePrinter();
        } else {
            System.out.println("Некорректный выбор. Используется вывод в консоль по умолчанию.");
            printer = new ConsolePrinter();
        }

        History history = new History();
        MathCalculator mathCalculator = new MathCalculator(printer, history);
        StringParser stringParser = new StringParser(mathCalculator, scanner);

        stringParser.parse();
        scanner.close();

        // Display the history of operations
        mathCalculator.getHistory().forEach(System.out::println);
    }
}
