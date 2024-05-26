package task_17.scr.org.example;
import java.util.*;

/**
 * Класс, реализующий недетерминированный конечный автомат (NFA).
 */
class NFA {
    private Set<Integer> startState; // начальные состояния
    private Set<Integer> acceptingStates; // конечные состояния
    private Map<Integer, Map<Character, Set<Integer>>> transitions; // переходы

    /**
     * Конструктор для создания NFA с заданными начальными и конечными состояниями.
     *
     * @param startState      начальные состояния.
     * @param acceptingStates конечные состояния.
     */
    public NFA(Set<Integer> startState, Set<Integer> acceptingStates) {
        this.startState = startState;
        this.acceptingStates = acceptingStates;
        this.transitions = new HashMap<>();
    }

    /**
     * Добавляет переход для данного состояния и символа.
     *
     * @param state     текущее состояние.
     * @param c         символ.
     * @param nextState следующее состояние.
     */
    public void addTransition(int state, Character c, int nextState) {
        addTransitionHelper(state, c, nextState);
    }

    /**
     * Вспомогательный метод для добавления перехода.
     *
     * @param state     текущее состояние.
     * @param c         символ.
     * @param nextState следующее состояние.
     */
    private void addTransitionHelper(int state, Character c, int nextState) {
        if (!transitions.containsKey(state)) {
            transitions.put(state, new HashMap<>());
        }
        if (!transitions.get(state).containsKey(c)) {
            transitions.get(state).put(c, new HashSet<>());
        }
        transitions.get(state).get(c).add(nextState);
    }

    /**
     * Добавляет обобщенный переход для данного состояния и множества символов.
     *
     * @param state     текущее состояние.
     * @param chars     множество символов.
     * @param nextState следующее состояние.
     */
    public void addGeneralizedTransition(int state, Set<Character> chars, int nextState) {
        for (Character c : chars) {
            addTransitionHelper(state, c, nextState);
        }
        addTransitionHelper(state, '.', nextState);
    }

    /**
     * Проверяет, принимает ли NFA данную строку.
     *
     * @param s строка для проверки.
     * @return true, если строка принимается, иначе false.
     */
    public boolean accepts(String s) {
        Set<Integer> currentStates = new HashSet<>(startState);
        for (int i = 0; i < s.length(); i++) {
            Set<Integer> nextStates = new HashSet<>();
            for (int state : currentStates) {
                if (transitions.containsKey(state) && transitions.get(state).containsKey(s.charAt(i))) {
                    nextStates.addAll(transitions.get(state).get(s.charAt(i)));
                }
                if (transitions.containsKey(state) && transitions.get(state).containsKey('.')) {
                    nextStates.addAll(transitions.get(state).get('.'));
                }
            }
            currentStates = nextStates;
        }
        return !Collections.disjoint(currentStates, acceptingStates);
    }
}
