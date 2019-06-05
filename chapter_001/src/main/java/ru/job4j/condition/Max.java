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
        int result = first > second ? first : second;
        return result = third > max(first, second) ? third : max(first, second);
    }

    public int max(int first, int second, int third, int fourth) {
        int result = fourth > max(first, second, third) ? fourth : max(first, second, third);
        return result;
    }
}