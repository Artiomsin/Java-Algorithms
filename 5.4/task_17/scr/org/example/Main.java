package task_17.scr.org.example;
import java.util.*;
/**
 * Главный класс для демонстрации работы NFA.
 */
public class Main {
    public static void main(String[] args) {
        // Пример 1: Простой NFA с обобщенными символами
        NFA nfa1 = new NFA(new HashSet<>(Arrays.asList(0)), new HashSet<>(Arrays.asList(1)));
        nfa1.addGeneralizedTransition(0, new HashSet<>(Arrays.asList('a', 'b')), 1);

        System.out.println("Пример 1:");
        System.out.println("NFA принимает 'a'? " + nfa1.accepts("a"));
        System.out.println("NFA принимает 'b'? " + nfa1.accepts("b"));
        System.out.println("NFA принимает 'c'? " + nfa1.accepts("c"));
        System.out.println();

        // Пример 2: NFA с обобщенными символами и путями разной длины
        NFA nfa2 = new NFA(new HashSet<>(Arrays.asList(0)), new HashSet<>(Arrays.asList(2)));
        nfa2.addGeneralizedTransition(0, new HashSet<>(Arrays.asList('a', 'b')), 1);
        nfa2.addTransition(1, 'c', 2);

        System.out.println("Пример 2:");
        System.out.println("NFA принимает 'abc'? " + nfa2.accepts("abc"));
        System.out.println("NFA принимает 'ac'? " + nfa2.accepts("ac"));
        System.out.println("NFA принимает 'bc'? " + nfa2.accepts("bc"));
        System.out.println();

        // Пример 3: NFA с вложенными обобщенными символами
        NFA nfa3 = new NFA(new HashSet<>(Arrays.asList(0)), new HashSet<>(Arrays.asList(2)));
        nfa3.addGeneralizedTransition(0, new HashSet<>(Arrays.asList('a', 'b')), 1);
        nfa3.addGeneralizedTransition(1, new HashSet<>(Arrays.asList('x', 'y')), 2);

        System.out.println("Пример 3:");
        System.out.println("NFA принимает 'ax'? " + nfa3.accepts("ax"));
        System.out.println("NFA принимает 'by'? " + nfa3.accepts("by"));
        System.out.println("NFA принимает 'az'? " + nfa3.accepts("az"));
    }
}