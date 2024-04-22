package task_14.scr.org.example;
import java.util.NoSuchElementException;

public class Bts {
    /**
     * Метод main для демонстрации операций с БДП.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        System.out.println("Tree size: " + bst.size());
        System.out.println("Minimum value: " + bst.min());
        System.out.println("Maximum value: " + bst.max());
        System.out.println("Floor of 5: " + bst.floor(5));
        System.out.println("Ceiling of 5: " + bst.ceiling(3));
        System.out.println("Rank of 5: " + bst.rank(5));
        System.out.println("Element at rank 0: " + bst.select(0));
    }
    /**
     * Внутренний класс, представляющий Бинарное Дерево Поиска (БДП).
     * Реализуйщий нерекурсивные реализации методов min(),max(),floor(),ceiling(),rank() и select().
     */
    public static class BST {
        private Node root;
        /**
         * Проверяет, пустое ли БДП.
         * @return True, если БДП пустое, в противном случае - false.
         */
        public boolean isEmpty() {
            return root == null;
        }
        /**
         * Вычисляет размер БДП.
         * @return Размер БДП.
         */
        public int size() {
            return Size(root);
        }
        /**
         * Вставляет значение в БДП.
         * @param value Значение для вставки.
         */
        public void insert(int value) {
            root = insertNode(root, value);
        }
        /**
         * Вставляет узел с заданным значением в дерево с заданным корнем.
         * @param node Корень дерева.
         * @param value Значение для вставки.
         * @return Корень дерева с вставленным узлом.
         */
        private Node insertNode(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }

            if (value < node.value) {
                node.left = insertNode(node.left, value);
            } else if (value > node.value) {
                node.right = insertNode(node.right, value);
            } else {
                node.value = value;
            }

            node.nodeSize = 1 + Size(node.left) + Size(node.right);
            return node;
        }
        /**
         * Находит минимальное значение в БДП.
         * @return Минимальное значение.
         * @throws NoSuchElementException если БДП пустое.
         */
        public int min() {
            if (isEmpty()) {
                throw new NoSuchElementException("The tree is empty");
            }

            Node current = root;
            while (current.left != null) {
                current = current.left;
            }
            return current.value;
        }
        /**
         * Находит максимальное значение в БДП.
         * @return Максимальное значение.
         * @throws NoSuchElementException если БДП пустое.
         */
        public int max() {
            if (isEmpty()) {
                throw new NoSuchElementException("The tree is empty");
            }

            Node current = root;
            while (current.right != null) {
                current = current.right;
            }
            return current.value;
        }
        /**
         * Находит значение "предшественника" заданного значения в БДП.
         * @param value Значение, для которого ищется "предшественник".
         * @return Значение "предшественника".
         * @throws NoSuchElementException если не найдено значение меньше или равное заданному.
         */
        public int floor(int value) {
            Node current = root;
            Node floor = null;

            while (current != null) {
                if (value == current.value) {
                    return current.value;
                } else if (value < current.value) {
                    current = current.left;
                } else {
                    floor = current;
                    current = current.right;
                }
            }

            if (floor == null) {
                throw new NoSuchElementException("No value less than or equal to the specified value");
            }

            return floor.value;
        }
        /**
         * Находит значение "преемника" заданного значения в БДП.
         * @param value Значение, для которого ищется "преемник".
         * @return Значение "преемника".
         * @throws NoSuchElementException если не найдено значение больше или равное заданному.
         */
        public int ceiling(int value) {
            Node current = root;
            Node ceiling = null;

            while (current != null) {
                if (value == current.value) {
                    return current.value;
                } else if (value < current.value) {
                    ceiling = current;
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if (ceiling == null) {
                throw new NoSuchElementException("No value greater than or equal to the specified value");
            }

            return ceiling.value;
        }
        /**
         * Находит ранг заданного значения в БДП.
         * @param value Значение, для которого находится ранг.
         * @return Ранг заданного значения.
         */
        public int rank(int value) {
            Node current = root;
            int rank = 0;

            while (current != null) {
                if (value < current.value) {
                    current = current.left;
                } else if (value > current.value) {
                    rank += Size(current.left) + 1;
                    current = current.right;
                } else {
                    rank += Size(current.left);
                    return rank;
                }
            }

            return rank;
        }
        /**
         * Возвращает размер поддерева с корнем в данном узле.
         * @param node Корень поддерева.
         * @return Размер поддерева.
         */
        private int Size(Node node) {
            if (node == null) {
                return 0;
            }
            return node.nodeSize;
        }
        /**
         * Выбирает элемент по его рангу в БДП.
         * @param k Ранг элемента.
         * @return Элемент с заданным рангом.
         * @throws IllegalArgumentException если заданный индекс недопустим.
         * @throws NoSuchElementException если заданный индекс не найден.
         */
        public int select(int k) {
            if (k < 0 || k >= Size(root)) {
                throw new IllegalArgumentException("Invalid index");
            }

            Node current = root;

            while (current != null) {
                int leftSize = Size(current.left);
                if (k < leftSize) {
                    current = current.left;
                } else if (k > leftSize) {
                    k -= leftSize + 1;
                    current = current.right;
                } else {
                    return current.value;
                }
            }

            throw new NoSuchElementException("Invalid index");
        }
        /**
         * Внутренний класс, представляющий узел в БДП.
         */
        private class Node {
            private int value;
            private Node left;
            private Node right;
            private int nodeSize;
            /**
             * Создает узел с заданным значением.
             * @param value Значение, которое будет храниться в узле.
             */
            public Node(int value) {
                this.value = value;
                this.nodeSize = 1;
            }
        }
    }
}