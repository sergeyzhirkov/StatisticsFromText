import java.util.ArrayList;

public class TaskSolution {

    private static ArrayList<String> arrayOfStrings;
    private static Statistics statistics = new Statistics();

    public static void main(String[] args) {
        FileParse fileParse = new FileParse("file.txt");
        try {
            arrayOfStrings = fileParse.arrayStringsFromFile();
        } catch (ProjectException e) {
            System.out.println("Аварийное завершение программы");
            System.exit(0);
        }
        for (String s : arrayOfStrings
                ) {
            StringParse sp = new StringParse(s);
            Statistics sFromString = sp.getStatisticsFromString();
            statistics.setSymbol(
                    statistics.getSymbol() + sFromString.getSymbol()
            );
            statistics.setSymbolWithoutProbel(
                    statistics.getSymbolWithoutProbel() + sFromString.getSymbolWithoutProbel()
            );
            statistics.setWords(
                    statistics.getWords() + sFromString.getWords()
            );
        }
        OutputInformation.write(statistics);
    }

}
