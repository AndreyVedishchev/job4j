package ru.job4j.condition;

/**
 * Рассчет максимального числа из двух
 */
public class Max {

    /**
     * max
     * @param first - 1число
     * @param second - 2число
     * @return максимальное число
     */
    public int max(int first, int second) {
        int result = first > second ? first : second;
        return result;
    }

    public int max(int first, int second, int third) {
        return this.max(third, this.max(first, second));
    }

    public int max(int first, int second, int third, int fourth) {
        return this.max(fourth, this.max(first, second, third));
    }
}