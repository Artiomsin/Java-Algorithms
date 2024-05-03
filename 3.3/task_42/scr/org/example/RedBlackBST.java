package task_42.scr.org.example;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс представляет красно-черное двоичное дерево поиска.
 * @param <Key>   тип ключа
 * @param <Value> тип значения
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    /**
     * Узел красно-черного дерева.
     */
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color;
        private int size;

        /**
         * Конструктор узла.
         * @param key   ключ узла
         * @param value значение узла
         * @param color цвет узла
         * @param size  размер поддерева, корнем которого является данный узел
         */
        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    /**
     * Вставляет ключ-значение в красно-черное дерево.
     * @param key   ключ
     * @param value значение
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    /**
     * Вспомогательный метод для вставки ключа-значения в поддерево с корнем в указанном узле.
     * @param node  корень поддерева
     * @param key   ключ
     * @param value значение
     * @return корень поддерева с вставленным ключом-значением
     */
    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, RED, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;

        // Исправление дерева
        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        // Обновление размера
        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    /**
     * Поворот узла влево.
     * @param node узел
     * @return новый корень поддерева
     */
    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;

        // Обновление размеров
        x.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;

        return x;
    }

    /**
     * Поворот узла вправо.
     * @param node узел
     * @return новый корень поддерева
     */
    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;

        // Обновление размеров
        x.size = node.size;
        node.size = size(node.left) + size(node.right) + 1;

        return x;
    }

    /**
     * Изменяет цвет узла и его дочерних узлов.
     * @param node узел
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * Проверяет, является ли узел красным.
     * @param node узел
     * @return true, если узел красный, иначе false
     */
    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color == RED;
    }

    /**
     * Возвращает размер поддерева с корнем в указанном узле.
     * @param node корень поддерева
     * @return размер поддерева
     */
    private int size(Node node) {
        if (node == null)
            return 0;
        return node.size;
    }

    /**
     * Вычисляет процент красных узлов в дереве.
     * @return процент красных узлов
     */
    public double calculateRedNodePercentage() {
        int totalNodes = size(root);
        int redNodes = countRedNodes(root);
        return (double) redNodes / totalNodes * 100;
    }

    /**
     * Рекурсивно подсчитывает количество красных узлов в поддереве с корнем в указанном узле.
     * @param node корень поддерева
     * @return количество красных узлов
     */
    private int countRedNodes(Node node) {
        if (node == null)
            return 0;
        int count = countRedNodes(node.left) + countRedNodes(node.right);
        if (node.color == RED)
            count++;
        return count;
    }

    /**
     * Возвращает общее количество узлов в дереве.
     * @return количество узлов в дереве
     */
    public int size() {
        return size(root);
    }

    /**
     * Метод main для тестирования.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        int[] N_values = {10000,100000,1000000};

        for (int N : N_values) {
            System.out.println("Тестирование для N = " + N + ":");
            long startTime = System.currentTimeMillis();

            double totalRedPercentage = 0.0;

            for (int i = 0; i < 20; i++) { // Уменьшено количество итераций
                RedBlackBST<Integer, String> bst = new RedBlackBST<>();

                for (int j = 0; j < N; j++) {
                    int key = ThreadLocalRandom.current().nextInt(N); // Использование ThreadLocalRandom
                    String value = "Значение " + key;
                    bst.put(key, value);
                }

                double redPercentage = bst.calculateRedNodePercentage();
                totalRedPercentage += redPercentage;
            }

            double averageRedPercentage = totalRedPercentage / 20; // Деление на количество итераций
            System.out.println("Средний процент красных узлов: " + averageRedPercentage + "%");

            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;

            System.out.println("Затраченное время: " + elapsedTime + " мс");

            System.out.println();
        }
    }
}
