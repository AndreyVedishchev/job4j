package ru.job4j.condition;

/**
 * Рассчет расстояния методу точками в системе координат.
 */

public class Point {

    /**
     * distance
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return расстояние
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        return Math.sqrt(first + second);
    }
}