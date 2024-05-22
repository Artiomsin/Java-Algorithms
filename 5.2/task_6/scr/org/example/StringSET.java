
package task_6.scr.org.example;
import java.util.ArrayList;
import java.util.List;
/**
 * Класс, представляющий набор строк.
 */
public class StringSET {
    private List<String> list;

    /**
     * Конструктор класса StringSET.
     * Инициализирует пустой список строк.
     */
    public StringSET() {
        list = new ArrayList<>();
    }

    /**
     * Добавляет строку в набор, если она еще не содержится в наборе.
     *
     * @param key добавляемая строка
     */
    public void add(String key) {
        if (!list.contains(key)) {
            list.add(key);
        }
    }

    /**
     * Удаляет указанную строку из набора, если она присутствует в наборе.
     *
     * @param key удаляемая строка
     */
    public void delete(String key) {
        list.remove(key);
    }

    /**
     * Проверяет, содержится ли указанная строка в наборе.
     *
     * @param key проверяемая строка
     * @return true, если строка содержится в наборе, иначе false
     */
    public boolean contains(String key) {
        return list.contains(key);
    }

    /**
     * Проверяет, является ли набор пустым.
     *
     * @return true, если набор пустой, иначе false
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Возвращает текущий размер набора.
     *
     * @return размер набора
     */
    public int size() {
        return list.size();
    }

    /**
     * Возвращает строковое представление набора.
     *
     * @return строковое представление набора
     */
    public String toString() {
        return list.toString();
    }
}