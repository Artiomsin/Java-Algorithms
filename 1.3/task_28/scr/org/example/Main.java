package task_28.scr.org.example;

/**
 * Главный класс приложения для решения задачи поиска максимального значения в связном списке.
 * Напишите метод {@code max()}, который принимает в качестве аргумента первый узел связного списка и
 * возвращает значение максимального элемента в этом списке. Все элементы представляют собой положительные
 * целые числа. В случае пустого списка нужно возвратить значение 0.
 *Разработайте рекурсивное решение.
 */
public class Main {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println("Список:");
        // Вызов метода для поиска максимального значения
        int max = findMaxValue(node1);
        System.out.println("Максимальное значение: " + max);
    }
    /**
     * Метод findMaxValue рекурсивно находит и возвращает значение максимального элемента в связном списке.
     * Все элементы представляют собой положительные целые числа. В случае пустого списка возвращается значение 0.
     *
     * @param node Первый узел связного списка.
     * @return Значение максимального элемента в связном списке.
     */
    public static int findMaxValue(Node node) {

        if (node == null) {
            return 0;
        }
        System.out.println(node.value + " ");
        int currentValue = node.value;
        int nextMax = findMaxValue(node.next);//рекурсия

        return Math.max(currentValue, nextMax);
    }
}