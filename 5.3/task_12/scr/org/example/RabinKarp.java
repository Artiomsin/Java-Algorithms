package task_12.scr.org.example;
/**
 * Класс для выполнения алгоритма Рабина-Карпа для поиска подстроки.
 */
public class RabinKarp {
    private int m; // длина образца
    private long Q; // модуль хэширования
    private int R; // основание хэширования
    private long RM; // R^(m-1) % Q

    /**
     * Конструктор, инициализирующий параметры для алгоритма Рабина-Карпа.
     *
     * @param m длина образца
     * @param R основание хэширования
     * @param Q модуль хэширования
     */
    public RabinKarp(int m, int R, long Q) {
        this.m = m;
        this.R = R;
        this.Q = Q;
        this.RM = 1;
        for (int i = 1; i <= m - 1; i++) {
            this.RM = (this.R * this.RM) % this.Q;
        }
    }

    /**
     * Выполняет поиск образца в тексте, используя алгоритм Рабина-Карпа.
     *
     * @param pattern образец для поиска
     * @param text    текст, в котором производится поиск
     * @return индекс первого вхождения образца в текст или -1, если образец не найден
     */
    public int search(String pattern, String text) {
        int N = text.length();
        long patHash = 0;
        long textHash = 0;

        // Вычисление хэша для образца и для первой подстроки текста
        for (int i = 0; i < m; i++) {
            patHash = (R * patHash + pattern.charAt(i)) % Q;
            textHash = (R * textHash + text.charAt(i)) % Q;
        }

        // Поиск совпадений хэшей
        for (int i = 0; i <= N - m; i++) {
            // Если хэши совпадают, проверяем сами строки
            if (patHash == textHash) {
                if (check(pattern, text, i)) {
                    return i;
                }
            }

            // Обновление хэша для следующего подстроки текста
            if (i < N - m) {
                textHash = (R * (textHash - text.charAt(i) * RM) + text.charAt(i + m)) % Q;
                if (textHash < 0) {
                    textHash += Q;
                }
            }
        }
        return -1;
    }

    /**
     * Проверяет совпадение образца с подстрокой текста, начиная с заданного индекса.
     *
     * @param pattern образец для проверки
     * @param text    текст, в котором проверяется подстрока
     * @param start   индекс начала подстроки в тексте
     * @return true, если образец совпадает с подстрокой текста, иначе false
     */
    protected boolean check(String pattern, String text, int start) {
        for (int i = 0; i < m; i++) {
            if (pattern.charAt(i) != text.charAt(start + i)) {
                return false;
            }
        }
        return true;
    }
}
