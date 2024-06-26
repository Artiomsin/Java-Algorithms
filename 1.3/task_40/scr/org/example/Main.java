package task_40.scr.org.example;

import java.io.IOException;
/**
 * Главный класс приложения, реализующий решение задачи "Сдвиг в начало".
 * Программа читает символы из стандартного ввода и сохраняет их в связном списке без повторов.
 * При вводе символа, который ранее не встречался, он вставляется в начало списка.
 * При вводе уже знакомого символа он удаляется из текущей позиции и снова вставляется в начало списка.
 * Назовите программу MoveToFront: она реализует известную стратегию сдвига в начало (move to front),
 * которая удобна при кешировании, сжатии данных и во многих других приложениях, где недавно обработанные
 * элементы с большей вероятностью могут встретиться вновь.
 */
public class Main{
    public static void main(String[] args)throws IOException {

        MoveToFront moveToFront = new MoveToFront();
        moveToFront.processInput();
        moveToFront.printList();

    }

}
