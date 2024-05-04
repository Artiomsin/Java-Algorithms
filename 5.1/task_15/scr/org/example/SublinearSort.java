package task_15.scr.org.example;

import java.util.Arrays;

public class SublinearSort {

    /**
     * Сортирует массив целочисленных значений, выполняя два прохода по массиву: LSD-сортировка
     * по старшим 16 битам ключей, а затем сортировка вставками.
     *
     * @param array сортируемый массив
     */
    public static void sublinearSort(int[] array) {
        lsdSort(array);
        insertionSort(array);
    }

    // LSD-сортировка по старшим 16 битам ключей
    private static void lsdSort(int[] array) {
        final int BITS_PER_BYTE = 8;
        final int R = 1 << BITS_PER_BYTE;
        final int MASK = R - 1;
        final int w = 16; // Количество битов для сортировки

        int n = array.length;
        int[] aux = new int[n];

        for (int d = 0; d < 4; d++) {
            int[] count = new int[R + 1];
            int[] countSum = new int[R + 1];

            // Вычисление частот каждого значения
            for (int i = 0; i < n; i++) {
                int c = (array[i] >> (d * w)) & MASK;
                count[c + 1]++;
            }

            // Преобразование частот в накопленные суммы
            for (int r = 0; r < R; r++) {
                countSum[r + 1] = countSum[r] + count[r];
            }

            // Распределение значений по вспомогательному массиву
            for (int i = 0; i < n; i++) {
                int c = (array[i] >> (d * w)) & MASK;
                aux[countSum[c]++] = array[i];
            }

            // Копирование обратно в исходный массив
            System.arraycopy(aux, 0, array, 0, n);
        }
    }

    // Сортировка вставками
    private static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {123456, 987654, 345678, 567890, 234567};

        sublinearSort(array);

        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(array));
    }
}
