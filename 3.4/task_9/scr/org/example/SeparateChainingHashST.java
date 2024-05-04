package task_9.scr.org.example;


import java.util.LinkedList;

/**
 * SeparateChainingHashST - реализация хеш-таблицы с методом Separate Chaining.
 * @param <Key>   тип ключа
 * @param <Value> тип значения
 */
public class SeparateChainingHashST<Key, Value> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private int capacity;
    private LinkedList<Node<Key, Value>>[] buckets;

    /**
     * Конструктор по умолчанию.
     */
    public SeparateChainingHashST() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Конструктор с заданной емкостью.
     * @param capacity емкость хеш-таблицы
     */
    public SeparateChainingHashST(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * Добавляет пару ключ-значение в хеш-таблицу.
     * @param key   ключ
     * @param value значение
     */
    public void put(Key key, Value value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node<Key, Value>> bucket = buckets[bucketIndex];

        for (Node<Key, Value> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        bucket.add(new Node<>(key, value));
        size++;

        if (size > capacity * 0.75) {
            resize(2 * capacity);
        }
    }

    /**
     * Возвращает значение, связанное с заданным ключом.
     * @param key ключ
     * @return значение, связанное с ключом, или null, если ключ не найден
     */
    public Value get(Key key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node<Key, Value>> bucket = buckets[bucketIndex];

        for (Node<Key, Value> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    /**
     * Удаляет ключ и связанное с ним значение из хеш-таблицы.
     * @param key ключ
     */
    public void delete(Key key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node<Key, Value>> bucket = buckets[bucketIndex];

        for (Node<Key, Value> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                size--;
                break;
            }
        }

        if (size < capacity * 0.25) {
            resize(capacity / 2);
        }
    }

    /**
     * Возвращает индекс ведра для заданного ключа.
     * @param key ключ
     * @return индекс ведра
     */
    private int getBucketIndex(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    /**
     * Изменяет емкость хеш-таблицы.
     * @param newCapacity новая емкость
     */
    private void resize(int newCapacity) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(newCapacity);

        for (LinkedList<Node<Key, Value>> bucket : buckets) {
            for (Node<Key, Value> node : bucket) {
                temp.put(node.key, node.value);
            }
        }

        this.capacity = temp.capacity;
        this.size = temp.size;
        this.buckets = temp.buckets;
    }

    /**
     * Узел, хранящий пару ключ-значение.
     * @param <Key>   тип ключа
     * @param <Value> тип значения
     */
    private static class Node<Key, Value> {
        private Key key;
        private Value value;

        /**
         * Конструктор узла с заданными ключом и значением.
         * @param key   ключ
         * @param value значение
         */
        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Тестовый метод для демонстрации использованияметодов хеш-таблицы.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SeparateChainingHashST<Integer, String> hashTable = new SeparateChainingHashST<>();

        // Добавление элементов в хеш-таблицу
        hashTable.put(1, "Value 1");
        hashTable.put(2, "Value 2");
        hashTable.put(3, "Value 3");

        // Вывод значений элементов до удаления
        System.out.println("Before deletion:");
        System.out.println("Key 1: " + hashTable.get(1));
        System.out.println("Key 2: " + hashTable.get(2));
        System.out.println("Key 3: " + hashTable.get(3));

        // Удаление элемента по ключу
        hashTable.delete(2);

        // Вывод значений элементов после удаления
        System.out.println("After deletion:");
        System.out.println("Key 1: " + hashTable.get(1));
        System.out.println("Key 2: " + hashTable.get(2));
        System.out.println("Key 3: " + hashTable.get(3));
    }
}