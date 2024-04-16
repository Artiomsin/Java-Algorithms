
package task_16.scr.org.example;

import  java.util.Comparator;
import  java.util.Scanner;
/**
 * Программа California для упорядочивания строк в соответствии с порядком выборов губернатора Калифорнии в 2003 году.
 * их упорядочили с помощью следующего набора символов: R W O J M V A H B S G Z X N T C I E K U P D Y E L.
 */

public class Main {
    private static final String R="RWOOJMVAHBSGZXNTCIEKUPDYFL";
    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int count=scanner.nextInt();
        scanner.nextLine();

        String[] strings=new String[count];
        for (int i=0;i<count;i++){
            System.out.print("Введите строку"+(i+1)+": ");
            strings[i]=scanner.nextLine().trim();
        }

        CustomCollections. arraySort(strings,Comparator.comparingInt(Main::getIndex));

        System.out.println("Отсортированные строрки: ");
        for(String str: strings){

            System.out.println(str);
        }
        scanner.close();
    }
    /**
     * Получает индекс строки на основе индексов символов.
     *
     * @param str Строка, для которой вычисляется индекс.
     * @return Индекс строки на основе индексов символов.
     */
    private static int getIndex(String str){
        char[]chars=str.toCharArray();//преобразем строку в массив символов
        for (int i=0; i<chars.length; i++){
            char c=Character.toUpperCase(chars[i]);//приводим символ к верхнему регистру
            int index=R.indexOf(c);
            if(index>=0){

                return index;
            }


        }
        return 0;
    }
    public static class CustomCollections {
        /**
         * Сортирует массив с использованием заданного компаратора.
         *
         * @param array      Массив, который нужно отсортировать.
         * @param comparator Компаратор для сравнения элементов массива.
         * @param <T>        Тип элементов массива.
         */
        public static <T> void arraySort(T[] array, Comparator<? super T> comparator) {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (comparator.compare(array[j], array[j + 1]) > 0) {
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }
}
