package task_9.scr.org.example;

/**
 * Реализация LSD-сортировки строк, которая способна работать со строками переменной длины
 */
public class LSDSort {

    public static void main(String[] args) {
        String[] strings = {"abc", "xyz", "defg", "pqrga", "pab", "z"};

        lsdSort(strings);

        System.out.println("Отсортированный массив: ");
        for (String str : strings) {
            System.out.println(str);
        }
    }

    /**
     * Сортирует массив строк по алгоритму LSD-сортировки.
     *
     * @param strings Массив строк, который нужно отсортировать.
     */
    public static void lsdSort(String[] strings) {
        int maxLength = getMaxStringLength(strings);
        int R = 256; // Количество возможных символов (ASCII)

        for (int d = maxLength - 1; d >= 0; d--) {
            // Используем сортировку подсчетом для каждого разряда
            int[] count = new int[R + 1];
            String[] aux = new String[strings.length];

            // Вычисление частот каждого символа
            for (int i = 0; i < strings.length; i++) {
                int charIndex = getCharIndex(strings[i], d);
                count[charIndex + 1]++;
            }

            // Преобразование частот в накопленные суммы
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // Распределение строк во вспомогательный массив
            for (int i = 0; i < strings.length; i++) {
                int charIndex = getCharIndex(strings[i], d);
                aux[count[charIndex]++] = strings[i];
            }

            // Копирование строк из вспомогательного массива обратно в исходный массив
            System.arraycopy(aux, 0, strings, 0, strings.length);
        }
    }

    /**
     * Возвращает максимальную длину строки в массиве строк.
     *
     * @param strings Массив строк.
     * @return Максимальная длина строки.
     */
    private static int getMaxStringLength(String[] strings) {
        int maxLength = 0;
        for (String str : strings) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }

    /**
     * Возвращает индекс символа в строке по заданному разряду.
     * Если разряд превышает длину строки, возвращается 0 для заполнения разрядов.
     *
     * @param str Строка.
     * @param d Разряд.
     * @return Индекс символа.
     */
    private static int getCharIndex(String str, int d) {
        if (d < str.length()) {
            return str.charAt(d);
        } else {
            return 0; // Для строк меньшей длины, возвращаем 0 для заполнения разрядов
        }
    }
}
