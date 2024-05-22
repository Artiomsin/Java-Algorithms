package task_15.scr.org.example;
/**
 * Класс для поиска подстроки в строке с помощью правого-левого подхода.
 */
public class SubstringSearchRightToLeft {
    /**
     * Выполняет поиск подстроки в строке, начиная с конца строки.
     *
     * @param pattern образец для поиска
     * @param text    текст, в котором производится поиск
     * @return индекс первого вхождения образца в текст или -1, если образец не найден
     */
    public static int search(String pattern, String text) {
        int n = text.length();
        int m = pattern.length();

        for (int i = n - m; i >= 0; i--) {
            int j = m - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(i + j)) {
                j--;
            }
            if (j < 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String pattern = "задач";
        String text = " Алгоритм это совокупность точно заданных правил" +
                " решения некоторого класса задач или набор инструкций, " +
                "описывающих порядок действий исполнителя для решения определённой задачи.";
        int index = search(pattern, text);
        if (index == -1) {
            System.out.println("Образец не найден в тексте.");
        } else {
            System.out.println("Образец найден в тексте на позиции " + index);
        }
    }
}
