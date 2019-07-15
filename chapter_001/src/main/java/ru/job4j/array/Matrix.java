package ru.job4j.array;

/**
 * реализация двумерного массива
 */
public class Matrix {

    /**
     * multiple
     * @param size - размер
     * @return вывод двумерного массива
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }
}
