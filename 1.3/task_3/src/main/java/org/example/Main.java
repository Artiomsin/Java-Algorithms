package org.example;


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

            // Вызов метода tah() для поиска максимального значения
            int max = Node.Max(node1);
            System.out.println("Максимальное значение: " + max);



    }
}