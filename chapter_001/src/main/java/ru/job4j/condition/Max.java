package ru.job4j.condition;

/**
 * Рассчет максимального числа из двух
 */
public class Max {

    /**
     * max
     * @param left - 1число
     * @param right - 2число
     * @return максимальное число
     */
    public int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }
}