package task_19.scr.org.example;
/**
 * Главный класс для демонстрации работы NFA.
 */
public class Main {
    public static void main(String[] args) {
        NFA nfa = new NFA();
        int s0 = nfa.addState();
        int s1 = nfa.addState();
        int s2 = nfa.addState();
        nfa.setStartState(s0);
        nfa.setAcceptingState(s2);
        nfa.addTransition(s0, 'a', s1);
        nfa.addTransition(s1, 'c', s2);

        System.out.println(nfa.getInputAlphabet(s0)); // [a]
        System.out.println(nfa.getInputAlphabet(s1)); // [c]
        System.out.println(nfa.getInputAlphabet(s2)); // []
    }
}