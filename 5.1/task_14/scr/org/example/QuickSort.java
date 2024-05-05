package task_14.scr.org.example;

import java.util.Arrays;

public class QuickSort {

    /**
     * Сортирует массив ключей, представляющих собой массивы целых чисел,
     * с использованием трехчастной быстрой сортировки.
     *
     * @param keys массив ключей для сортировки
     */
    public static void quickSort(int[][] keys) {
        quickSort(keys, 0, keys.length - 1);
    }

    private static void quickSort(int[][] keys, int low, int high) {
        if (low < high) {
            int[] pivot = keys[low];
            int i = low + 1;
            int lt = low;
            int gt = high;

            while (i <= gt) {
                int cmp = compare(keys[i], pivot);
                if (cmp < 0) {
                    swap(keys, i, lt);
                    i++;
                    lt++;
                } else if (cmp > 0) {
                    swap(keys, i, gt);
                    gt--;
                } else {
                    i++;
                }
            }

            quickSort(keys, low, lt - 1);
            quickSort(keys, gt + 1, high);
        }
    }

    /**
     * Сравнивает два ключа, представленных массивами целых чисел.
     *
     * @param key1 первый ключ для сравнения
     * @param key2 второй ключ для сравнения
     * @return отрицательное число, если key1 меньше key2;
     *         положительное число, если key1 больше key2;
     *         ноль, если ключи равны
     */
    private static int compare(int[] key1, int[] key2) {
        int minLength = Math.min(key1.length, key2.length);
        for (int i = 0; i < minLength; i++) {
            if (key1[i] < key2[i]) {
                return -1;
            } else if (key1[i] > key2[i]) {
                return 1;
            }
        }
        return Integer.compare(key1.length, key2.length);
    }

    /**
     * Обменивает два элемента массива ключей.
     *
     * @param keys массив ключей
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private static void swap(int[][] keys, int i, int j) {
        int[] temp = keys[i];
        keys[i] = keys[j];
        keys[j] = temp;
    }

    public static void main(String[] args) {
        int[][] keys = {{32, 1, 4}, {2, 5, 1}, {0, 9, 8}, {7, 6, 2}};

        quickSort(keys);

        System.out.println("Отсортированный массив: ");
        for (int[] key : keys) {
            System.out.println(Arrays.toString(key));
        }
    }
}