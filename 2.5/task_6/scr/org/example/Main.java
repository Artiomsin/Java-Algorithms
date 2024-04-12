package task_6.scr.org.example;
/**
 * Программа для сортировки массива методом выбора (selection sort).
 * Реализуйте рекурсивную версию метода select().
 */
public class Main {
    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11,57577575,56,-90,0,112};
        selectSort(arr, 0);
        System.out.println("Отсортированный массив: ");
        printArray(arr);
        }
    /**
     * Рекурсивная функция для сортировки массива методом выбора (selection sort).
     *
     * @param arr         Сортируемый массив.
     * @param startIndex Индекс элемента, с которого начинается сортировка.
     */
    public static void selectSort(int[] arr, int startIndex) {
        if (startIndex >= arr.length - 1) {
            return; // Базовый случай: если startIndex достиг конца массива, завершаем рекурсию
        }

        int minIndex = findMinIndex(arr, startIndex);
        swap(arr, startIndex, minIndex);

        // Рекурсивно вызываем selectSort для следующего элемента
        selectSort(arr, startIndex + 1);
    }
    /**
     * Находит индекс минимального элемента в подмассиве с заданным startIndex.
     *
     * @param arr         Массив, в котором выполняется поиск.
     * @param startIndex Индекс элемента, с которого начинается поиск.
     * @return Индекс минимального элемента в подмассиве.
     */
    public static int findMinIndex(int[] arr, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i; // Находим индекс минимального элемента в подмассиве
            }
        }
        return minIndex;
    }
    /**
     * Обменивает два элемента массива местами.
     *
     * @param arr Массив, в котором выполняется обмен.
     * @param i   Индекс первого элемента для обмена.
     * @param j   Индекс второго элемента для обмена.
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Выводит элементы массива на экран.
     *
     * @param arr Массив, элементы которого нужно вывести.
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    }
