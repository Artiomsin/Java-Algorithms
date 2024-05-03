package task_34.scr.org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Генератор 2-3 деревьев.
 */
public class TwoThreeTreeGenerator {
    private static int nodeCounter = 1;

    /**
     * Метод main для тестирования генерации 2-3 деревьев различной высоты.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        int[] heights = { 2, 3, 4 };

        for (int height : heights) {
            List<Node> trees = generateTrees(height);
            System.out.println("Number of 2-3 trees with height " + height + ": " + trees.size());
            for (Node tree : trees) {
                System.out.println(tree);
            }
            System.out.println();
        }
    }

    /**
     * Генерирует список 2-3 деревьев заданной высоты.
     * @param height высота деревьев
     * @return список 2-3 деревьев заданной высоты
     */
    private static List<Node> generateTrees(int height) {
        List<Node> trees = new ArrayList<>();
        generateTrees(height, trees);
        return trees;
    }

    /**
     * Рекурсивно генерирует 2-3 деревья заданной высоты.
     * @param height высота деревьев
     * @param trees список, в который добавляются сгенерированные деревья
     */
    private static void generateTrees(int height, List<Node> trees) {
        if (height == 0) {
            Node leaf = new Node("Leaf" + nodeCounter++);
            trees.add(leaf);
        } else if (height == 1) {
            Node node = new Node("Node" + nodeCounter++);
            node.children.add(new Node("Leaf" + nodeCounter++));
            node.children.add(new Node("Leaf" + nodeCounter++));
            trees.add(node);
        } else {
            List<Node> subTrees = new ArrayList<>();
            generateTrees(height - 1, subTrees);
            for (Node subTree : subTrees) {
                Node node = new Node("Node" + nodeCounter++);
                node.children.add(subTree);
                trees.add(node);
            }
            for (int i = 0; i < subTrees.size() - 1; i++) {
                for (int j = i + 1; j < subTrees.size(); j++) {
                    Node node = new Node("Node" + nodeCounter++);
                    node.children.add(subTrees.get(i));
                    node.children.add(subTrees.get(j));
                    trees.add(node);
                }
            }
        }
    }

    /**
     * Узел 2-3 дерева.
     */
    private static class Node {
        private String name;
        private List<Node> children;

        /**
         * Конструктор узла.
         * @param name имя узла
         */
        public Node(String name) {
            this.name = name;
            children = new ArrayList<>();
        }

        /**
         * Возвращает строковое представление узла и его дочерних узлов.
         * @return строковое представление узла
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(sb, "", true);
            return sb.toString();
        }

        private void toString(StringBuilder sb, String prefix, boolean isTail) {
            sb.append(prefix).append(isTail ? "└── " : "├── ").append(name).append("\n");
            for (int i = 0; i < children.size() - 1; i++) {
                children.get(i).toString(sb, prefix + (isTail ? "    " : "│   "), false);
            }
            if (children.size() > 0) {
                children.get(children.size() - 1).toString(sb, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
}
