
package task_16.scr.org.example;

import java.util.Arrays;
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

Arrays.sort(strings,Comparator.comparingInt(Main::getIndex));

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

    }
