package task_14.scr.org.example;

import java.util.NoSuchElementException;
/**
 * Класс, представляющий очередь на основе изменяемого массива строк.
 */
public class ResizingArrayQueueOfStrings {
    private String[] queue;
    private int front; // Индекс начала очереди
    private int rear; // Индекс конца очереди
    private int size; // Текущий размер очереди
    /**
     * Конструктор класса ResizingArrayQueueOfStrings.
     *
     * @param capacity начальная вместимость очереди.
     */
    public ResizingArrayQueueOfStrings(int capacity) {
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    /**
     * Проверяет, является ли очередь пустой.
     *
     * @return {@code true}, если очередь пуста, в противном случае - {@code false}.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Проверяет, является ли очередь полной.
     *
     * @return {@code true}, если очередь полна, в противном случае - {@code false}.
     */
    public boolean isFull() {
        return size == queue.length;
    }
    /**
     * Возвращает текущий размер очереди.
     *
     * @return размер очереди.
     */
    public int size() {
        return size;
    }
    /**
     * Добавляет элемент в конец очереди.
     *
     * @param item элемент, который нужно добавить в очередь.
     */
    public void enqueue(String item) {
        if (isFull()) {
            resize(2 * queue.length);
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = item;
        size++;
    }
    /**
     * Удаляет и возвращает элемент из начала очереди.
     *
     * @return элемент из начала очереди.
     * @throws NoSuchElementException если очередь пуста.
     */
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
    /**
     * Обновляет элемент в очереди по указанному индексу.
     *
     * @param index   индекс элемента в очереди.
     * @param newItem новое значение элемента.
     * @throws IndexOutOfBoundsException если указанный индекс недопустим.
     */
    public void update(int index, String newItem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс");
        }
        int actualIndex = (front + index) % queue.length;
        queue[actualIndex] = newItem;
    }
    /**
     * Возвращает элемент из очереди по указанному индексу.
     *
     * @param index индекс элемента в очереди.
     * @return элемент из очереди.
     * @throws IndexOutOfBoundsException если указанный индекс недопустим.
     */
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