package task_20.scr.org.example;
public class Main {
    /**
     * Точка входа в программу.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        StringSET stringSet = new StringSET();

        stringSet.add("hello");
        stringSet.add("world");
        stringSet.add("java");
        stringSet.add("programming");

        System.out.println("Contains prefix 'he': " + stringSet.containsPrefix("he"));  // Output: true
        System.out.println("Contains prefix 'wor': " + stringSet.containsPrefix("wor"));  // Output: true
        System.out.println("Contains prefix 'jav': " + stringSet.containsPrefix("jav"));  // Output: true
        System.out.println("Contains prefix 'prog': " + stringSet.containsPrefix("prog"));  // Output: true
        System.out.println("Contains prefix 'test': " + stringSet.containsPrefix("test"));  // Output: false
    }
}