package task_20.scr.org.example;
/**
 * Главный класс для демонстрации работы NFA.
 */
public class MainNFA {
    public static void main(String[] args) {
        NFA nfa = new NFA();
        int s0 = nfa.addState();
        int s1 = nfa.addState();
        int s2 = nfa.addState();
        nfa.setStartState(s0);
        nfa.setAcceptingState(s2);
        nfa.addRangeTransition(s0, 'a', 'c', s1);
        nfa.addTransition(s1, 'x', s2);

        System.out.println(nfa.accepts("ax")); // true
        System.out.println(nfa.accepts("bx")); // true
        System.out.println(nfa.accepts("cx")); // true
        System.out.println(nfa.accepts("dx")); // false
    }
}