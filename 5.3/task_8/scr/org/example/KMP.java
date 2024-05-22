package task_8.scr.org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс KMP реализует алгоритм Кнута-Мориса-Пратта для поиска шаблона в заданном тексте.
 */
public class KMP {
    private final String text;
    private final String pattern;
    private final int[] table;

    /**
     * Конструктор, создающий новый объект KMP с заданным текстом и шаблоном.
     *
     * @param text    текст, в котором будет осуществляться поиск
     * @param pattern шаблон, который нужно найти в тексте
     */
    public KMP(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.table = buildTable(pattern);
    }

    /**
     * Строит таблицу KMP для заданного шаблона.
     *
     * @param pattern шаблон, для которого нужно построить таблицу
     * @return таблица KMP
     */
    private int[] buildTable(String pattern) {
        int[] table = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }

    /**
     * Подсчитывает количество вхождений шаблона в текст.
     *
     * @return количество вхождений
     */
    public int count() {
        int count = 0;
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                count++;
                j = table[j - 1];
            }
        }
        return count;
    }

    /**
     * Находит все вхождения шаблона в текст.
     *
     * @return список индексов, где был найден шаблон
     */
    public List<Integer> searchAll() {
        List<Integer> indices = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                indices.add(i - j + 1);
                j = table[j - 1];
            }
        }
        return indices;
    }
}