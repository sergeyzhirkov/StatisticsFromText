import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParse {
    private String filename;

    public FileParse(String filename) {
        this.filename = filename;
    }

    public ArrayList<String> arrayStringsFromFile() throws ProjectException {
        ArrayList<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (reader.ready()) {
                result.add(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файла не существует, проверьте файловую систему");
            throw new ProjectException();
        } catch (IOException e) {
            System.out.println("Проблема ввода-ввывода");
            throw new ProjectException();
        }
        return result;
    }
}
