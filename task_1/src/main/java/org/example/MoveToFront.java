import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveToFront {
    private static class Node {
        char value;
        Node next;

        public Node(char value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    public MoveToFront() {
        head = null;
    }

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