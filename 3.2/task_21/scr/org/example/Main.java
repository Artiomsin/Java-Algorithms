package task_21.scr.org.example;

import java.util.Random;
import java.util.NoSuchElementException;


public class Main {
    /**
     * Метод main для демонстрации операций с BST.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);

        System.out.println("Random Key: " + bst.randomKey());
    }
    /**
     * Вложенный класс, представляющий BST
     * реализующий метод randomKey(),который возращает случайный ключ за время
     * в худшим случае пропорциональное высоте дерева
     */
    public static class BST {
        private class Node {
            private int value;
            private Node left;
            private Node right;
            private int nodeSize;
            /**
             * Конструктор класса Node.
             *
             * @param value значение, хранящееся в узле
             */
            public Node(int value) {
                this.value = value;
                this.nodeSize = 1;
            }
        }
        private Node root;
        private Random random;
        /**
         * Конструктор класса BST.
         */
        public BST() {
            random = new Random();
        }
        /**
         * Генерирует случайный ключ из BST.
         * @return Случайный ключ.
         * @throws NoSuchElementException если BST пустое.
         */
        public int randomKey() {
            if (isEmpty()) {
                throw new NoSuchElementException("The tree is empty");
            }

            int randomIndex = random.nextInt(size(root));
            Node randomNode = selectNode(root, randomIndex);

            return randomNode.value;
        }
        /**
         * Рекурсивно выбирает узел с заданным индексом в BST.
         * @param node Корень поддерева.
         * @param k Индекс узла.
         * @return Узел с заданным индексом.
         */
        private Node selectNode(Node node, int k) {
            int leftSize = size(node.left);

            if (k < leftSize) {
                return selectNode(node.left, k);
            } else if (k > leftSize) {
                return selectNode(node.right, k - leftSize - 1);
            } else {
                return node;
            }
        }
        /**
         * Возвращает размер поддерева с корнем в данном узле.
         * @param node Корень поддерева.
         * @return Размер поддерева.
         */
        private int size(Node node) {
            if (node == null) {
                return 0;
            }

            return node.nodeSize;
        }
        /**
         * Проверяет, пустое ли BST.
         * @return True, если BST пустое, в противном случае - false.
         */
        public boolean isEmpty() {
            return root == null;
        }
        /**
         * Вставляет значение в BST.
         * @param value Значение для вставки.
         */
        public void insert(int value) {
            root = insertNode(root, value);
        }
        /**
         * Рекурсивно вставляет узел с заданным значением в BST.
         * @param node Корень поддерева.
         * @param value Значение для вставки.
         * @return Корень поддерева с вставленным узлом.
         */
        private Node insertNode(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }

            if (value < node.value) {
                node.left = insertNode(node.left, value);
            } else if (value > node.value) {
                node.right = insertNode(node.right, value);
            }

            node.nodeSize = 1 + size(node.left) + size(node.right);

            return node;
        }
    }

}