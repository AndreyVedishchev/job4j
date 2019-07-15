package ru.job4j.loop;

/**
 * рассчет факториала n
 */
public class Factorial {

    /**
     * calc
     * @param n число
     * @return факториал для n
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}