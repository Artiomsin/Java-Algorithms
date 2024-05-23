package task_19.scr.org.example;
import java.util.*;

/**
 * Класс, реализующий недетерминированный конечный автомат (NFA).
 */
class NFA {
    private Set<Integer> startState; // начальные состояния
    private Set<Integer> acceptingStates; // конечные состояния
    private Map<Integer, Map<Character, Set<Integer>>> transitions; // переходы
    private Map<Integer, Set<Character>> inputAlphabet; // входной алфавит

    /**
     * Конструктор для создания NFA.
     */
    public NFA() {
        this.startState = new HashSet<>();
        this.acceptingStates = new HashSet<>();
        this.transitions = new HashMap<>();
        this.inputAlphabet = new HashMap<>();
    }

    /**
     * Добавляет новое состояние в NFA.
     *
     * @return номер нового состояния.
     */
    public int addState() {
        int newState = transitions.size();
        transitions.put(newState, new HashMap<>());
        inputAlphabet.put(newState, new HashSet<>());
        return newState;
    }

    /**
     * Устанавливает начальное состояние для NFA.
     *
     * @param state состояние, которое должно быть начальным.
     */
    public void setStartState(int state) {
        startState.clear();
        startState.add(state);
    }

    /**
     * Устанавливает состояние как принимающее.
     *
     * @param state состояние, которое должно быть принимающим.
     */
    public void setAcceptingState(int state) {
        acceptingStates.add(state);
    }

    /**
     * Добавляет переход для данного состояния и символа.
     *
     * @param state     текущее состояние.
     * @param c         символ.
     * @param nextState следующее состояние.
     */
    public void addTransition(int state, Character c, int nextState) {
        if (!transitions.containsKey(state)) {
            transitions.put(state, new HashMap<>());
            inputAlphabet.put(state, new HashSet<>());
        }
        if (!transitions.get(state).containsKey(c)) {
            transitions.get(state).put(c, new HashSet<>());
        }
        transitions.get(state).get(c).add(nextState);
        inputAlphabet.get(state).add(c);
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
            addTransition(state, c, nextState);
        }
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
            }
            currentStates = nextStates;
        }
        return !Collections.disjoint(currentStates, acceptingStates);
    }

    /**
     * Возвращает множество символов входного алфавита для заданного состояния.
     *
     * @param state состояние, для которого нужно получить входной алфавит.
     * @return множество символов входного алфавита.
     */
    public Set<Character> getInputAlphabet(int state) {
        return inputAlphabet.get(state);
    }
}
