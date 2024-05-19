package task_20.scr.org.example;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс StringSET представляет набор строковых значений без повторений.
 */
public class StringSET {
    private Set<String> set;

    /**
     * Конструктор класса StringSET. Создает пустой набор строк.
     */
    public StringSET() {
        set = new HashSet<>();
    }

    /**
     * Добавляет строковое значение в набор.
     *
     * @param key строковое значение для добавления
     */
    public void add(String key) {
        set.add(key);
    }

    /**
     * Удаляет строковое значение из набора, если оно присутствует.
     *
     * @param key строковое значение для удаления
     */
    public void delete(String key) {
        set.remove(key);
    }

    /**
     * Проверяет, содержится ли указанное строковое значение в наборе.
     *
     * @param key строковое значение для проверки
     * @return true, если набор содержит указанное значение, иначе false
     */
    public boolean contains(String key) {
        return set.contains(key);
    }

    /**
     * Проверяет, содержится ли в наборе хотя бы одно значение, начинающееся с указанного префикса.
     *
     * @param prefix префикс для проверки
     * @return true, если набор содержит значение с указанным префиксом, иначе false
     */
    public boolean containsPrefix(String prefix) {
        for (String key : set) {
            if (key.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает итератор для перебора всех строковых значений в наборе.
     *
     * @return итератор по строковым значениям в наборе
     */
    public Iterable<String> keys() {
        return set;
    }
}