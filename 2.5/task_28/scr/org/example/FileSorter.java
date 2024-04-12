package task_28.scr.org.example;

import java.io.File;
import java.util.Arrays;

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
        Arrays.sort(files);

        // Вывод отсортированных файлов
        System.out.println("Файлы после сортировки:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
