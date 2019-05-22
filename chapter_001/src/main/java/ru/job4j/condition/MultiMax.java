package ru.job4j.condition;

/**
 * Нахождение максимума из 3 чисел
 */
public class MultiMax {

    /**
     * max
     * @param first - 1 число
     * @param second - 2 число
     * @param third - 3 число
     * @return максимум из трех чисел
     */
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
            result = result > third ? result : third;

        return result;
    }
}