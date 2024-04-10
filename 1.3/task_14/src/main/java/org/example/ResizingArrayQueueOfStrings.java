package org.example;

import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings {
    private String[] queue;
    private int front; // Индекс начала очереди
    private int rear; // Индекс конца очереди
    private int size; // Текущий размер очереди

    public ResizingArrayQueueOfStrings(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int size() {
        return size;
    }

    public void enqueue(String item) {
        if (isFull()) {
            resize(2 * queue.length);
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Очередь пуста");
        }
        String item = queue[front];
        queue[front] = null; // Освобождаем ссылку на удаленный элемент
        front = (front + 1) % queue.length;
        size--;
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public void update(int index, String newItem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }
        int actualIndex = (front + index) % queue.length;
        queue[actualIndex] = newItem;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }
        int actualIndex = (front + index) % queue.length;
        return queue[actualIndex];
    }

    private void resize(int capacity) {
        String[] newQueue = new String[capacity];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = size - 1;
    }


}