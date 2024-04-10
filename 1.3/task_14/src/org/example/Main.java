package org.example;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings(3);

        System.out.println("Добавление элементов в очередь:");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Размер очереди: " + queue.size());

        System.out.println("Элементы очереди:");
        for (int i = 0; i < queue.size(); i++) {
            System.out.println("Элемент " + i + ": " + queue.get(i));
        }

        System.out.println("Обновление элемента с индексом 1:");
        queue.update(1, "D");

        System.out.println("Элементы очереди после обновления:");
        for (int i = 0; i < queue.size(); i++) {
            System.out.println("Элемент " + i + ": " + queue.get(i));
        }

        System.out.println("Извлечение элементов из очереди:");
        while (!queue.isEmpty()) {
            String item = queue.dequeue();
            System.out.println("Извлеченный элемент: " + item);
        }
        System.out.println("Размер очереди: " + queue.size());

        System.out.println("Добавление элементов в очередь после извлечения:");
        queue.enqueue("E");
        queue.enqueue("F");
        System.out.println("Размер очереди: " + queue.size());

        System.out.println("Элементы очереди после добавления:");
        for (int i = 0; i < queue.size(); i++) {
            System.out.println("Элемент " + i + ": " + queue.get(i));
        }
    }

}
