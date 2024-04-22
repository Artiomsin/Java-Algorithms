package task_6.scr.org.example;

public class BST {
    /**
     * класс BST метод h e i g h t ( ) для вычисления высоты дерева.
     * Две реализации: рекурсивный метод (требующий линейного времени и памяти, пропорциональной высоте)
     * метод наподобие size(), для работы которого нужно дополнительное поле в каждом узле дерева
     * (требующий линейного объема памяти и константного времени на запрос).
     */
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
    /**
     * Рекурсивный метод для вычисления высоты дерева.
     *
     * @return высота дерева
     */
    private Node root;

    public int recursiveHeight() {
        return recursiveHeight(root);
    }
    /**
     * Вспомогательный метод для рекурсивного вычисления высоты дерева.
     *
     * @param node узел, для которого вычисляется высота
     * @return высота дерева, начиная с данного узла
     */
    private int recursiveHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = recursiveHeight(node.left);
        int rightHeight = recursiveHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    /**
     * Метод, аналогичный size(), для вычисления высоты дерева.
     *
     * @return высота дерева
     */
    public int sizeBasedHeight() {
        return sizeBasedHeight(root);
    }
    /**
     * Вспомогательный метод для вычисления высоты дерева на основе размера.
     *
     * @param node узел, для которого вычисляется высота
     * @return высота дерева, начиная с данного узла
     */
    private int sizeBasedHeight(Node node) {
        if (node == null) {
            return -1;
        }

        return node.nodeSize - 1;
    }
    /**
     * Метод для вставки значения в дерево.
     *
     * @param value значение для вставки
     */
    public void insert(int value) {
        root = insertNode(root, value);
    }
    /**
     * Вспомогательный метод для рекурсивной вставки значения в дерево.
     *
     * @param node  текущий узел при рекурсивном обходе
     * @param value значение для вставки
     * @return узел, вставленный в дерево
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
     * Метод для вычисления размера поддерева.
     *
     * @param node узел поддерева
     * @return размер поддерева, начиная с данного узла
     */
    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return node.nodeSize;
    }
    /**
     * Метод для печати дерева.
     */
    public void printTree() {
        printTree(root, 0);
    }
    /**
     * Вспомогательный метод для печати дерева.
     *
     * @param node  текущий узел при рекурсивной печати
     * @param level текущий уровень дерева
     */
    private void printTree(Node node, int level) {
        if (node != null) {
            printTree(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(node.value);
            printTree(node.left, level + 1);
        }
    }
    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);
        bst.printTree();
        int recursiveHeight = bst.recursiveHeight();
        int sizeBasedHeight = bst.sizeBasedHeight();

        System.out.println("Recursive Height: " + recursiveHeight);
        System.out.println("Size-based Height: " + sizeBasedHeight);
    }
}
