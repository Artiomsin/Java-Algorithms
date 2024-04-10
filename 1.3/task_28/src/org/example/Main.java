package org.example;
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