package task_17.scr.org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Класс SpellChecker представляет простой проверяет орфографии на основе словаря.
 */
public class SpellChecker {
    private Set<String> dictionary;

    /**
     * Конструктор класса SpellChecker.
     *
     * @param dictionaryFile путь к файлу словаря
     */
    public SpellChecker(String dictionaryFile) {
        dictionary = new HashSet<>();
        loadDictionary(dictionaryFile);
    }

    /**
     * Загружает словарь из файла.
     *
     * @param dictionaryFile путь к файлу словаря
     */
    private void loadDictionary(String dictionaryFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dictionary.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении словаря: " + e.getMessage());
        }
    }

    /**
     * Проверяет орфографию во введенной строке.
     */
    public void checkSpelling() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для проверки орфографии:");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+");

        System.out.println("Слова, отсутствующие в словаре:");
        for (String word : words) {
            if (!dictionary.contains(word)) {
                System.out.println(word);
            }
        }
    }

    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла словаря:");
        String dictionaryFile = scanner.nextLine();

        SpellChecker spellChecker = new SpellChecker(dictionaryFile);
        spellChecker.checkSpelling();
    }
}