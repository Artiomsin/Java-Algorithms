package task_26.scr.org.example;
import java.util.Arrays;

/**
 * Класс для проверки, являются ли две строки циклическими перестановками друг друга.
 */
public class CyclicPermutation {
    /**
     * Проверяет, являются ли две строки циклическими перестановками друг друга.
     *
     * @param s1 первая строка
     * @param s2 вторая строка
     * @return true, если строки являются циклическими перестановками друг друга, иначе false
     */
    public static boolean areCyclicPermutations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    public static void main(String[] args) {
        String s1 = "пальто";
        String s2 = "топаль";

        if (areCyclicPermutations(s1, s2)) {
            System.out.println("Строки являются циклическими перестановками друг друга.");
        } else {
            System.out.println("Строки не являются циклическими перестановками друг друга.");
        }
    }
}
