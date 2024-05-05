# Java-Algorithms
## Sonarcloud: https://sonarcloud.io/project/overview?id=Artiomsin_Java-Algorithms

# Задания
### 1.3 Контейнеры, очереди, стеки
  1) Задание 1.3.40 [Директория](1.3/task_40/scr/org/example) (PLAN: 0.8 FACT: 0.6)
     + **Условие:**
     Сдвиг в начало. Напишите программу для чтения символов из стандартного ввода и сохранения их в связном списке без повторов. При вводе символа, 
     который раньше не встречался, вставьте его в начало списка. При вводе уже знакомого символа удалите его из списка и снова вставьте в начало. 
     Назовите программу MoveToFront: она реализует известную стратегию сдвига в начало (move to front), которая удобна при кешировании, сжатии 
     данных и во многих других приложениях, где недавно обработанные элементы с большей вероятностьюмогут встретиться вновь.

  2) Задание 1.3.14 [Директория](1.3/task_14/scr/org/example) (PLAN: 0.5 FACT: 0.45)
     + **Условие:**
     Разработайте класс ResizingArrayQueue0fStrings, когорый реализует абстракцию очереди с массивом фиксированного размера, а потом добавьте в полученную 
     реализацию изменение размера массива, чтобы снять ограничение на размер.

  3) Задание 1.3.27 [Директория](1.3/task_27/scr/org/example) (PLAN: 0.3 FACT: 0.25)
     + **Условие:**
     Напишите метод mах(), который принимает в качестве аргумента первый узел связного списка и возвращает значение максимального элемента в этом списке. Все 
     элементы представляют собой положительные целые числа. В случае пустого списка нужно возвратить значение 0.
 
  4) Задание 1.3.28 [Директория](1.3/task_28/scr/org/example) (PLAN: 0.15 FACT: 0.1)
     + **Условие:**
     Разработайте рекурсивное решение предыдущего задания.

### 2.5 Применение сортировок
  1) Задание 2.5.6 [Директория](2.5/task_6/scr/org/example) (PLAN:0.15 FACT:0.1)
     + **Условие:**
     Реализуйте рекурсивную версию метода select().

  2) Задание 2.5.8 [Директория](2.5/task_8/scr/org/example) (PLAN: 0.35 FACT: 0.45)
     + **Условие:**
     Напишите программу Frequency, которая читает строки из стандартного ввода и выводит количество повторений каждой строки, по убыванию частот.

  3) Задание 2.5.16 [Директория](2.5/task_16/scr/org/example) (PLAN: 0.4 FACT: 0.4)
     + **Условие:**
     Выборы без предпочтений. Чтобы не ущемлять кандидатов, имена которых находятся в конце алфавита, на выборах губернатора Калифорнии в 2003 г.
     их упорядочили с помощью следующего набора символов:
     R W O J M V A H B S G Z X N T C I E K U P D Y E L
     Создайте тип данных, где этот порядок является естественным, и напишите клиент California с единственным статическим методом main(), который 
     упорядочивает строки в таком порядке. Считайте, что все строки содержат только прописные буквы.
 
  4) Задание 2.5.28 [Директория](2.5/task_28/scr/org/example) (PLAN: 0.2 FACT: 0.2)
     + **Условие:**
     Сортировка файлов по именам. Напишите программу FileSorter, которая принимает из командной строки имя каталога и выводит имена всех находящихся
     там файлов, упорядоченные по алфавиту. Совет: используйте тип данных File.

### 3.2 Деревья бинарного поиска
  1) Задание 3.2.6 [Директория](3.2/task_6/scr/org/example) (PLAN:0.45 FACT:0.35)
     + **Условие:**
     Добавьте в класс BST метод height( ) для вычисления высоты дерева. Разработайте две реализации: рекурсивный метод (требующий линейного времени и 
     памяти, пропорциональной высоте) и метод наподобие size(), для работы которого нужно дополнительное поле в каждом узле дерева (требующий линейного объема 
     памяти и константного времени на запрос).

  2) Задание 3.2.14 [Директория](3.2/task_14/scr/org/example) (PLAN: 1.1 FACT: 0.55)
     + **Условие:**
     Приведите нерекурсивные реализации методов min(), max(), floor(), ceiling(), rank() и select().

  3) Задание 3.2.21 [Директория](3.2/task_21/scr/org/example) (PLAN: 0.3 FACT: 0.25)
     + **Условие:**
     Добавьте в класс BST метод randomKey(), который возвращает из таблицы имен случайный ключ за время, в худшем случае пропорциональное высоте дерева.
 
  4) Задание 3.2.29 [Директория](3.2/task_29/scr/org/example) (PLAN: 0.45 FACT: 0.45)
     + **Условие:**
     Проверка бинарного дерева. Напишите рекурсивный метод isBinaryTree()
     который принимает в качестве аргумента узел Node и возвращает t r u e
     если счетчик узлов Nдля поддерева с указанным корнем верен, и f a l s e в противном случае.

### 3.3 Сбалансированные деревья поиска
  1) Задание 3.3.31 [Директория](3.3/task_31/scr/org/example) (PLAN:1.1 FACT:1.0)
     + **Условие:**
     Вычерчивание дерева. Добавьте в класс RedBlackBST метод draw(), который вычерчивает красно-черные ДБП.

  2) Задание 3.3.33 [Директория](3.3/task_33/scr/org/example) (PLAN: 1.1 FACT: 0.55)
     + **Условие:**
     Проверка. Добавьте в класс RedBlackBST метод is23() для выполнения проверки, что ни у одного узла нет двух красных ссылок и нет правых красных ссылок, и           метод isBalanced() для выполнения проверки, что все пути от корня к нулевым ссылкам содержат одинаковое количество черных ссылок. Объедините эти методы с          кодом isBST() из упражнения 3.2.32, чтобы получить метод isRedBlackBST(), который проверяет, что дерево является красно-черным деревом бинарного поиска.

  3) Задание 3.3.34 [Директория](3.3/task_34/scr/org/example) (PLAN: 0.55 FACT: 0.45)
     + **Условие:**
     Все 2-3-деревья. Напишите программу для генерации всех структурно различных 2-3-деревьев высотой 2, 3 и 4.
     Должно получиться 2, 7 и 122 таких деревьев соответственно. (Совет: воспользуйтесь таблицей имен.)

  4) Задание 3.3.42 [Директория](3.3/task_42/scr/org/example) (PLAN: 0.35 FACT: 0.45)
     + **Условие:**
     Подсчет красных узлов. Напишите программу, которая вычисляет процент красных узлов в заданном красно-черном ДБП. Проверьте работу программы, выполнив, по           крайней мере, 100 раз вставку N случайных ключей в первоначально пустое дерево, для N=10^4, 10^5 и 10^6.

### 3.4 Хеш-таблицы
  1) Задание 3.4.4 [Директория](3.4/task_4/scr/org/example) (PLAN:0.35 FACT:0.3)
     + **Условие:**
     Напишите программу для определения значений а и М с наименьшим M, чтобы хеш-функция (а * k) %М преобразования k-й буквы алфавита в индекс таблицы давала           различные значения (без коллизий) для ключей  S E A R C H X M P L.
     Такой результат называется идеальной хеш-функцией.

  2) Задание 3.4.9 [Директория](3.4/task_9/scr/org/example) (PLAN: 0.45 FACT: 0.5)
     + **Условие:**
     Реализуйте энергичный метод delete() для класса SeparateChainingHashST.

  3) Задание 3.4.32 [Директория](3.4/task_32/scr/org/example) (PLAN: 0.25 FACT: 0.2)
     + **Условие:**
     Хеш-атака. Найдите 2^N строк, каждая длиной 2^N, которые имеют одинаковое значение hashCode() для следующей реализации:
     public int hashCode )(
     int hash = 0;
     for (int i = 0; i < length(): i ++) hash = (hash * 31) + charAt (i) ;
     return hash;
     Подсказка: строки Аа и В дают одинаковые значения.

  4) Задание 3.4.36 [Директория](3.4/task_36/scr/org/example) (PLAN: 0.45 FACT: 0.4)
     + **Условие:**
     Диапазон длин списков. Напишите программу, которая вставляет N ключей int в таблицу размером N/100 с раздельными цепочками, а затем определяет длину самого        короткого исамого длинного списков, для N=10^3, 10^4, 10^5 и 10^6.


### 5.1 Сортировка строк
  1) Задание 5.1.7 [Директория](5.1/task_7/scr/org/example) (PLAN:0.5 FACT:0.5)
     + **Условие:**
     Разработайте реализацию распределяющего подсчета, в котором используется массив объектов Queue.

  2) Задание 5.1.9 [Директория](5.1/task_9/scr/org/example) (PLAN: 0.5 FACT: 0.55)
     + **Условие:**
     Разработайте реализацию LSD-сортировки строк, которая способна работать со строками переменной длины.

  3) Задание 5.1.14 [Директория](5.1/task_14/scr/org/example) (PLAN: 1.0 FACT: 1.0)
     + **Условие:**
     Сортировка массивов. Разработайте метод, в котором трехчастная быстрая сортировка строк применяется для ключей, представляющих собой массивы целых чисел.

  4) Задание 5.1.15 [Директория](5.1/task_15/scr/org/example) (PLAN: 1.0 FACT: 0.55)
     + **Условие:**
     Сублинейная сортировка. Разработайте реализацию сортировки для целочисленных значений,
     которая выполняет два прохода по сортируемому массиву: LSD-сортировка по старшим 16 битам ключей, а затем сортировка вставками.

### 5.2 Trie-деревья

### 5.3 Поиск подстрок

### 5.4 Регулярные выражения

