package org.example;


public class Node {

    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

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
