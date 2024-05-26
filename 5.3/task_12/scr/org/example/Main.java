package task_12.scr.org.example;
/**
 * Основной класс для демонстрации алгоритма Рабина-Карпа.
 */
public class Main {
    public static void main(String[] args) {
        String pattern = "needle";
        String text = "This is a haystack with a needle in it.";
        int R = 256; // размер алфавита
        long Q = longRandomPrime(); // большое простое число

        RabinKarp rk = new RabinKarp(pattern.length(), R, Q);
        int index = rk.search(pattern, text);

        if (index == -1) {
            System.out.println("Ошибка: Образец не найден в тексте.");
        } else {
            System.out.println("Образец найден в тексте на позиции " + index);
        }

        // Проверка метода check()
        System.out.println("Проверка метода check():");
        if (index != -1) {
            System.out.println("Образец найден на позиции " + index + "? " + rk.check(pattern, text, index));
        }
    }

    /**
     * Генерирует случайное большое простое число.
     *
     * @return случайное большое простое число
     */
    private static long longRandomPrime() {
        long p;
        do {
            p = nextLong(Long.MAX_VALUE - 1) + 1;
        } while (!isPrime(p));
        return p;
    }

    /**
     * Проверяет, является ли число простым.
     *
     * @param n число для проверки
     * @return true, если число простое, иначе false
     */
    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        long i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }

    /**
     * Генерирует случайное число в пределах от 0 до bound.
     *
     * @param bound верхняя граница для генерации случайного числа
     * @return случайное число в пределах от 0 до bound
     */
    private static long nextLong(long bound) {
        // Используем стандартный генератор случайных чисел
        return (long) (Math.random() * bound);
    }
}
