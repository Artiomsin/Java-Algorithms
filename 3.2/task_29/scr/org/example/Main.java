package task_29.scr.org.example;

public class Main {
    /**
     * Вложенный класс, представляющий BST.
     */
    public static class BST {
        /**
         * Вложенный класс, представляющий узел BST.
         * Реализующий рекурсивный метод isBinaryTree() (проверка бинарного дерева)
         * который принимает в качестве аргумента узел Node и возвращает t r u e
         * если счетчик узлов N для поддерева с указанным корнем верен
         * и f a l s e в противном случае.
         */
        private static class Node {
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
        /**
         * Проверяет, является ли данное дерево бинарным деревом поиска.
         * @param node Корень дерева для проверки.
         * @return true, если дерево бинарное, в противном случае - false.
         */
        public boolean isBinaryTree(Node node) {
            return isBinaryTreeUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isBinaryTreeUtil(Node node, int min, int max) {
            if (node == null) {
                return true;
            }

            if (node.value < min || node.value > max) {
                return false;
            }

            return isBinaryTreeUtil(node.left, min, node.value - 1) &&
                    isBinaryTreeUtil(node.right, node.value + 1, max);
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
        /**
         * Отрисовывает BST.
         */
        public void drawTree() {
            drawTreeUtil(root, 0);
        }
        private void drawTreeUtil(Node node, int level) {
            if (node == null) {
                return;
            }

            drawTreeUtil(node.right, level + 1);

            if (level != 0) {
                for (int i = 0; i < level - 1; i++) {
                    System.out.print("    ");
                }
                System.out.print("|---");
            }

            System.out.println(node.value);

            drawTreeUtil(node.left, level + 1);
        }

    }
    /**
     * Метод main для демонстрации операций с BST.
     * @param args Аргументы командной строки (не используются).
     */
        public static void main(String[] args) {
            BST bst = new BST();
            // Добавление узлов в дерево
            bst.insert(5);
            bst.insert(2);
            bst.insert(7);
            bst.insert(1);
            bst.insert(3);
            bst.insert(6);
            bst.insert(8);
            // Создание не бинарного дерева
           
            bst.root.right.right.left = new BST.Node(9);
            bst.drawTree();
            // Проверка, является ли дерево бинарным
            boolean isBinary = bst.isBinaryTree(bst.root);
            System.out.println("Is Binary Tree: " + isBinary);

        }


}