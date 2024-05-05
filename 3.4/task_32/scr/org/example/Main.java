package task_32.scr.org.example;

public class Main {
    public static void main(String[] args) {
        int N = 2; // Длина строки

        // Генерируем первую строку
        StringBuilder stringA = new StringBuilder();
        for (int i = 0; i < N * N; i++) {
            stringA.append('A');
        }

        // Генерируем вторую строку
        StringBuilder stringB = new StringBuilder();
        for (int i = 0; i < N * N; i++) {
            stringB.append('B');
        }

        // Вычисляем хеш-код для каждой строки
        int hashCodeA = calculateHashCode(stringA.toString());
        int hashCodeB = calculateHashCode(stringB.toString());

        // Печатаем результаты
        System.out.println("String A: " + stringA.toString());
        System.out.println("Hash Code A: " + hashCodeA);
        System.out.println();
        System.out.println("String B: " + stringB.toString());
        System.out.println("Hash Code B: " + hashCodeB);
    }
    /**
     * Вычисляет хеш-код строки с использованием заданной реализации.
     * @param str строка
     * @return хеш-код строки
     */
    private static int calculateHashCode(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * 31) + str.charAt(i);
        }
        return hash;
    }
}