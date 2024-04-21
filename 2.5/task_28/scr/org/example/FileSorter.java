package task_28.scr.org.example;

import java.io.File;
import java.util.Comparator;

/**
 * Программа для сортировки файлов в заданной директории по алфавиту.
 */

public class FileSorter {
    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args){
        // Путь к директории, которую нужно отсортировать
        String directoryPath="C:\\Users\\andre\\Desktop\\Java-Algorithms\\2.5\\test";
        File directory=new File(directoryPath);

        // Проверка, является ли указанный путь директорией
        if (!directory.isDirectory()) {
            System.out.println(directoryPath + " не является директорией");
            return;
        }

        // Получение списка файлов в директории
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Не удалось получить список файлов");
            return;
        }


        // Сортировка файлов по алфавиту
        CustomCollections.arraySort(files, Comparator.comparing(File::getName));

        // Вывод отсортированных файлов
        System.out.println("Файлы после сортировки:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
    public static class CustomCollections {
        /**
         * Сортирует массив с использованием заданного компаратора.
         *
         * @param array      Массив, который нужно отсортировать.
         * @param comparator Компаратор для сравнения элементов массива.
         * @param <T>        Тип элементов массива.
         */
        public static <T> void arraySort(T[] array, Comparator<? super T> comparator) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (comparator.compare(array[j], array[j + 1]) > 0) {
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }
}
