
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class OutputInformation {
    public static void write(Statistics stat) {
        String resultString =
                "count symbols = " + stat.getSymbol() + "\n" +
                 "count symbols without whitespace = " + stat.getSymbolWithoutProbel() + "\n" +
                 "count words = " + stat.getWords();
        try (PrintStream writer = new PrintStream(new FileOutputStream("Statistics.txt"))) {
            writer.println(resultString);
        } catch (FileNotFoundException e) {
            // формальное проверяемое исключение при "кривом пути файла",
            // в нашем случае всё создаётся в корневой папке
        }
        System.out.println(resultString);
    }
}
