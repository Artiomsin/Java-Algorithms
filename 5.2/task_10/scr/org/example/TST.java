package task_10.scr.org.example;
/**
 * Класс TST представляет тернарное дерево поиска (TST) для хранения ключей и значений.
 *
 * @param <Value> тип значения, связанного с ключом
 */
public class TST<Value> {
    private Node root; // Корневой узел

    /**
     * Внутренний класс, представляющий узел TST.
     */
    private class Node {
        private char c;
        private Node left, mid, right;
        private Value value;
        private int size; // Количество ключей в поддереве этого узла
    }

    /**
     * Возвращает размер TST.
     *
     * @return размер TST
     */
    public int size() {
        return size(root);
    }

    /**
     * Рекурсивно вычисляет размер поддерева, начиная с указанного узла.
     *
     * @param node узел, с которого начинается подсчет размера
     * @return размер поддерева
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    /**
     * Вставляет ключ и значение в TST.
     *
     * @param key   ключ
     * @param value значение
     * @throws IllegalArgumentException если ключ или значение равны null
     */
    public void put(String key, Value value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null.");
        }
        root = put(root, key, value, 0);
    }

    /**
     * Рекурсивно вставляет ключ и значение в TST, начиная с указанного узла.
     *
     * @param node узел, с которого начинается вставка
     * @param key   ключ
     * @param value значение
     * @param d     текущий индекс символа в ключе
     * @return обновленный узел
     */
    private Node put(Node node, String key, Value value, int d) {
        char c = key.charAt(d);
        if (node == null) {
            node = new Node();
            node.c = c;
        }
        if (c < node.c) {
            node.left = put(node.left, key, value, d);
        } else if (c > node.c) {
            node.right = put(node.right, key, value, d);
        } else if (d < key.length() - 1) {
            node.mid = put(node.mid, key, value, d + 1);
        } else {
            if (node.value == null) {
                node.size++; // Увеличиваем размер только при добавлении нового ключа
            }
            node.value = value;
        }
        node.size++; // Увеличиваем размер в каждом узле при проходе по пути добавления ключа
        return node;
    }
}