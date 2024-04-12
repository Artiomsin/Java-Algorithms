package task_8.scr.org.example;

import java.util.*;
/**
 * Программа F r e q u e n c y для подсчета частоты повторений строк.
 */
public class Frequency {
    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        List<String> Lines=new ArrayList<>();
System.out.println("Введите строки (для выхода введите 1)");
while(true){
            String line = in.nextLine();
if(line.equals("1")){
    break;
}
Lines.add(line);

        }
in.close();

        Comparator<String>characterCountcomparator=new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int count1=countRepeatedCharacters(o1);
                int count2=countRepeatedCharacters(o2);

                return Integer.compare(count1,count2);
            }
        };

Collections.sort(Lines,characterCountcomparator);
for (String str:Lines)
{

    System.out.println(str);
}
    }

    /**
     * Подсчитывает количество повторяющихся символов в строке.
     *
     * @param str Строка, в которой выполняется подсчет.
     * @return Количество повторяющихся символов в строке.
     */
    public static int countRepeatedCharacters(String str){
        Set<Character>unique=new HashSet<>();
        int count=0;
        for(char c: str.toCharArray()){
            if(!unique.add(c)){
                count++;
            }

        }
        return count;

    }

}
