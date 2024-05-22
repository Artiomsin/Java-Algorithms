package task_6.scr.org.example;
/**
 * Главный класс программы, содержащий метод `main`.
 */
public class Maintask_6 {
    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Создание объекта StringSET
        StringSET stringSet = new StringSET();

        // Добавление строк в набор
        stringSet.add("apple");
        stringSet.add("banana");
        stringSet.add("orange");

        // Вывод информации о наборе
        System.out.println("Set: " + stringSet.toString());
        System.out.println("Size: " + stringSet.size());
        System.out.println("Contains 'banana': " + stringSet.contains("banana"));

        // Удаление строки из набора
        stringSet.delete("banana");

        // Вывод информации о наборе после удаления
        System.out.println("Set after deleting 'banana': " + stringSet.toString());
        System.out.println("Is empty? " + stringSet.isEmpty());
    }
}