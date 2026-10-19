import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рядок зі словами:");
        String text = scanner.nextLine();

        String[] result = WordAnalyzer.findWord(text);

        System.out.println("Результат: " + Arrays.toString(result));
    }
}