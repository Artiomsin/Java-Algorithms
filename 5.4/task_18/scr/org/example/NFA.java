package task_18.scr.org.example;
import java.util.*;

/**
 * Класс, реализующий недетерминированный конечный автомат (NFA).
 */
public class NFA {
    private char[] re; // массив символов регулярного выражения
    private Digraph G; // граф переходов NFA
    private int M; // длина регулярного выражения

    /**
     * Конструктор NFA на основе регулярного выражения.
     *
     * @param regexp регулярное выражение.
     */
    public NFA(String regexp) {
        Stack<Integer> ops = new Stack<>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M + 1);

        for (int i = 0; i < M; i++) {
            int lp = i;
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                LinkedList<Integer> ors = new LinkedList<>();
                while (!ops.isEmpty() && re[ops.peek()] == '|') {
                    int or = ops.pop();
                    ors.add(or);
                }
                lp = ops.pop();
                for (int or : ors) {
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                }
            }
            if (i < M - 1 && re[i + 1] == '*') {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if (i < M - 1 && re[i + 1] == '+') {
                G.addEdge(i + 1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == '+' || re[i] == ')') {
                G.addEdge(i, i + 1);
            }
        }
    }

    /**
     * Проверяет, распознает ли NFA данную строку.
     *
     * @param txt строка для проверки.
     * @return true, если строка соответствует регулярному выражению, иначе false.
     */
    public boolean recognizes(String txt) {
        Bag<Integer> pc = new Bag<>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) {
                pc.add(v);
            }
        }
        for (int i = 0; i < txt.length(); i++) {
            Bag<Integer> match = new Bag<>();
            for (int v : pc) {
                if (v < M && (re[v] == txt.charAt(i) || re[v] == '.')) {
                    match.add(v + 1);
                }
            }
            pc = new Bag<>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) {
                    pc.add(v);
                }
            }
        }
        for (int v : pc) {
            if (v == M) {
                return true;
            }
        }
        return false;
    }

    /**
     * Главный метод для тестирования NFA.
     *
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        String pattern = ".*AB((C|D|E)F)+G";
        NFA nfa = new NFA(pattern);

        String[] testStrings = {"A", "AB", "ABCFG", "ABDFG", "ABEFG", "CFG", "CDFG", "DEFG", "ABCF", "ABCFFG", "ABCCDFG"};
        for (String testString : testStrings) {
            if (nfa.recognizes(testString)) {
                System.out.println("Строка \"" + testString + "\" соответствует шаблону \"" + pattern + "\".");
            } else {
                System.out.println("Строка \"" + testString + "\" не соответствует шаблону \"" + pattern + "\".");
            }
        }
    }
}

/**
 * Класс, реализующий направленный граф.
 */
class Digraph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    /**
     * Конструктор для создания направленного графа с V вершинами.
     *
     * @param V количество вершин.
     */
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    /**
     * Добавляет ребро от вершины v к вершине w.
     *
     * @param v начальная вершина.
     * @param w конечная вершина.
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    /**
     * Возвращает смежные вершины для данной вершины v.
     *
     * @param v вершина.
     * @return смежные вершины.
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Возвращает количество вершин.
     *
     * @return количество вершин.
     */
    public int V() {
        return V;
    }

    /**
     * Возвращает количество ребер.
     *
     * @return количество ребер.
     */
    public int E() {
        return E;
    }
}

/**
 * Класс для выполнения поиска в глубину на направленном графе.
 */
class DirectedDFS {
    private boolean[] marked;

    /**
     * Конструктор для выполнения поиска в глубину от начальной вершины s.
     *
     * @param G граф.
     * @param s начальная вершина.
     */
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * Конструктор для выполнения поиска в глубину от множества начальных вершин.
     *
     * @param G граф.
     * @param sources начальные вершины.
     */
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * Проверяет, достижима ли вершина v в графе.
     *
     * @param v вершина.
     * @return true, если вершина достижима, иначе false.
     */
    public boolean marked(int v) {
        return marked[v];
    }
}

/**
 * Класс, представляющий собой контейнер (bag) для хранения элементов.
 *
 * @param <Item> тип элементов в контейнере.
 */
class Bag<Item> extends LinkedList<Item> {

}
