public class StringParse {
    private String stroka;

    public StringParse(String stroka) {
        this.stroka = stroka;
    }

    public Statistics getStatisticsFromString() {
        Statistics stat = new Statistics();
        int countSymbol = stroka.length();
        int countProbel = 0;
        int countWords = 0;

        for (int i = 0; i < stroka.length(); i++) { // подсчёт пробелов
            if (stroka.charAt(i) == ' ') {
                countProbel++;
            }
        }
        stroka = " " + stroka + " ";
        String[] massiveSlov = stroka.split(" ");
        // разбиваем строку на предполагаемые слова регулярным выражением
        // и проверяем каждое - является ли словом (есть ли буквы)
        for (String str : massiveSlov
                ) {
            if (!str.equals("") && containsBukva(str)) {
                countWords++;
            }
        }
        stat.setSymbol(countSymbol);
        stat.setSymbolWithoutProbel(countSymbol - countProbel);
        stat.setWords(countWords);
        return stat;
    }

    private boolean containsBukva(String s) { //проверка строки - является ли словом
        boolean result = false;
        s = s.toLowerCase();

        for (int i = 'a'; i < 'z'; i++) {
            result = result || (s.indexOf(i) != -1);
            if (result) {
                return result;
            }
        }

        for (int i = 'а'; i < 'я'; i++) {
            result = result || (s.indexOf(i) != -1);
            if (result) {
                return result;
            }
        }
        return result;

    }
}
