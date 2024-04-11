package task_28.scr.org.example;
/**
 * Класс Node представляет узел связного списка.
 */
public class Node {
    int value;
    Node next;
    /**
     * Конструктор класса Node.
     *
     * @param value Значение узла.
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
