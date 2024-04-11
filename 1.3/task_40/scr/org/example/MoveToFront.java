package task_40.scr.org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Класс MoveToFront реализует стратегию сдвига в начало ("move to front") при чтении символов из стандартного ввода
 * и сохранении их в связном списке без повторов.
 */
public class MoveToFront {
    /**
     * Вложенный класс, представляющий узел списка.
     */
    private static class Node {
        char value;
        Node next;
        /**
         * Конструктор класса Node.
         *
         * @param value Значение узла.
         */
        public Node(char value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    /**
     * Конструктор класса MoveToFront.
     * Инициализирует пустой список.
     */
    public MoveToFront() {
        head = null;
    }
    /**
     * Метод processInput считывает символы из стандартного ввода и выполняет стратегию сдвига в начало.
     *
     * @throws IOException Исключение, которое может возникнуть при обработке ввода-вывода.
     */
    public void processInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите символы (для выхода введите '1'):");

        while (true) {
            String input = reader.readLine();

            if (input.equals("1"))
                break;

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                handleInput(ch);
            }
        }

        reader.close();
    }
    /**
     * Приватный метод handleInput обрабатывает введенный символ.
     * Если символ уже присутствует в списке, он удаляется из текущей позиции и вставляется в начало списка.
     * Если символ новый, он добавляется в начало списка.
     *
     * @param input Введенный символ для обработки.
     */
    private void handleInput(char input) {
        Node previous = null;
        Node current = head;

        // Поиск символа в списке
        while (current != null && current.value != input) {
            previous = current;
            current = current.next;
        }

        // Если символ найден, удаляем его из текущей позиции
        if (current != null) {
            if (previous != null)
                previous.next = current.next;
            else
                head = current.next;
        }

        // Вставляем символ в начало списка
        Node newNode = new Node(input);
        newNode.next = head;
        head = newNode;
    }
    /**
     * Метод printList выводит содержимое списка на экран.
     */
    public void printList() {
        Node current = head;

        System.out.print("Список: ");

        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

        System.out.println();
    }


}