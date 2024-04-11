package task_27.scr.org.example;

/**
 * Класс, представляющий узел связного списка.
 */
public class Node {

    int value;
    Node next;
    /**
     * Конструктор класса Node.
     *
     * @param value значение узла.
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
    /**
     * Метод для поиска максимального значения в связном списке.
     *
     * @param firstNode первый узел связного списка.
     * @return максимальное значение в связном списке. Если список пуст, возвращается значение 0.
     */
    public static int Max(Node firstNode) {
        if (firstNode == null) {
            return 0;
        }

        int maxValue = firstNode.value;
        Node currentNode = firstNode;
System.out.println("Список:");
        while (currentNode != null) {

            System.out.println(currentNode.value+" ");
            if (currentNode.value > maxValue) {
                maxValue = currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return maxValue;
    }

}
