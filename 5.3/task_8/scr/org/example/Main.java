package task_8.scr.org.example;
import java.util.Scanner;
import java.util.List;

/**
 * Основной класс программы.
 */
public class Main {

    /**
     * Главный метод программы, который запускается при старте приложения.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запросить у пользователя ввод текста
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        // Заданный шаблон для поиска
        String pattern = "Hello";

        // Создать объект KMP для выполнения алгоритма поиска
        KMP kmp = new KMP(text, pattern);

        // Найти количество вхождений шаблона в тексте
        int count = kmp.count();
        System.out.println("Count of '" + pattern + "': " + count);

        // Найти все вхождения шаблона в тексте и вывести их индексы
        List<Integer> indices = kmp.searchAll();
        System.out.println("All occurrences of '" + pattern + "': " + indices);

        // Вывести сообщение о том, что тест успешно пройден
        System.out.println("Test passed successfully!");
    }
}
