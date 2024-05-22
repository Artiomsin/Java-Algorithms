package task_10.scr.org.example;
/**
 * Класс TrieST представляет префиксное дерево (Trie) для хранения ключей и значений.
 *
 * @param <Value> тип значения, связанного с ключом
 */
public class TrieST<Value> {
    private static final int R = 256; // Размер алфавита (ASCII)

    private Node root; // Корневой узел

    /**
     * Внутренний класс, представляющий узел TrieST.
     */
    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
        private int size; // Количество ключей в поддереве этого узла
    }

    /**
     * Вставляет ключ и значение в TrieST.
     *
     * @param key   ключ
     * @param value значение
     */
    public void insert(String key, Value value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null.");
        }
        root = insert(root, key, value, 0);
    }

    private Node insert(Node node, String key, Value value, int d) {
        if (node == null) {
            node = new Node();
        }
        if (d == key.length()) {
            if (node.value == null) {
                node.size++; // Увеличиваем размер только при добавлении нового ключа
            }
            node.value = value;
            return node;
        }
        char c = key.charAt(d);
        node.next[c] = insert(node.next[c], key, value, d + 1);
        node.size++; // Увеличиваем размер в каждом узле при проходе по пути добавления ключа
        return node;
    }

    /**
     * Возвращает размер TrieST.
     *
     * @return размер TrieST
     */
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }
}