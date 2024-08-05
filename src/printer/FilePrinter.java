package printer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {

    private static final String FILE_PATH = "result.txt";

    @Override
    public void print(double result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(String.format("Ваш результат равен: %.2f%n", result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
