package task_36.scr.org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Диапазон длин списков. Напишите программу, которая вставляет N ключей int в таблицу размером N/100 с раздельными цепочками,
 * а затем определяет длину самого короткого и самого длинного списков для различных значений N.
 */
public class HashTableChainingExample {

    /**
     * Главный метод программы.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        int[] N_values = {1000, 10000, 100000, 1000000}; // Значения N

        for (int N : N_values) {
            int tableSize = N / 100;

            // Создаем таблицу размером tableSize с раздельными цепочками
            ArrayList<LinkedList<Integer>> hashTable = new ArrayList<>();
            for (int i = 0; i < tableSize; i++) {
                hashTable.add(new LinkedList<>());
            }

            // Вставляем N ключей int в таблицу
            Random random = new Random();
            for (int i = 0; i < N; i++) {
                int key = random.nextInt(N); // Генерируем случайный ключ
                int index = hash(key, tableSize);
                hashTable.get(index).add(key);
            }

            // Определяем длину самого короткого и самого длинного списка
            int shortestListLength = Integer.MAX_VALUE;
            int longestListLength = Integer.MIN_VALUE;

            for (LinkedList<Integer> list : hashTable) {
                int listLength = list.size();
                shortestListLength = Math.min(shortestListLength, listLength);
                longestListLength = Math.max(longestListLength, listLength);
            }

            // Выводим результаты
            System.out.println("N = " + N);
            System.out.println("Shortest List Length: " + shortestListLength);
            System.out.println("Longest List Length: " + longestListLength);
            System.out.println();
        }
    }

    /**
     * Хеширование ключа.
     * @param key ключ для хеширования
     * @param tableSize  размер хеш-таблицы
     * @return индекс в хеш-таблице, где ключ будет добавлен
     * @throws IllegalArgumentException если размер таблицы равен нулю
     */
    private static int hash(int key, int tableSize) {
        if (tableSize == 0) {
            throw new IllegalArgumentException("Table size cannot be zero.");
        }
        return key % tableSize;
    }
}