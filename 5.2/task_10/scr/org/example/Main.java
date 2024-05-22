package task_10.scr.org.example;
/**
 * Главный класс программы, содержащий метод `main`.
 */
public class Main {
    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Пример использования TrieST
        TrieST<Integer> trieST = new TrieST<>();
        trieST.insert("apple", 1);
        trieST.insert("banana", 2);
        trieST.insert("orange", 3);

        System.out.println("TrieST size: " + trieST.size());

        // Пример использования TST
        TST<Integer> tst = new TST<>();
        tst.put("apple", 1);
        tst.put("banana", 2);
        tst.put("orange", 3);

        System.out.println("TST size: " + tst.size());
    }
}