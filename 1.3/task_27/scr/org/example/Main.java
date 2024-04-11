package task_27.scr.org.example;

/**
 * Главный класс приложения для решения задачи поиска максимального значения в связном списке.
 * Напишите метод {@code max()}, который принимает в качестве аргумента первый узел связного списка и
 * возвращает значение максимального элемента в этом списке. Все элементы представляют собой положительные
 * целые числа. В случае пустого списка нужно возвратить значение 0.
 */
public class Main {
    public static void main(String[] args) {


            // Создание связного списка: 1 -> 2 -> 3 -> 4 -> null
            Node node1 = new Node(1);
            Node node2 = new Node(2);
            Node node3 = new Node(3);
            Node node4 = new Node(4);

            node1.next = node2;
            node2.next = node3;
            node3.next = node4;

            int max = Node.Max(node1);
            System.out.println("Максимальное значение: " + max);



    }
}