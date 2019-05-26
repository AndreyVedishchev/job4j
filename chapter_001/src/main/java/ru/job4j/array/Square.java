package ru.job4j.array;

/**
 * возведение в квадрат элементов массива
 */
public class Square {

    /**
     * calculate
     * @param bound - размер массива
     * @return массив элементов в квадрате
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int k = 1;

        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int i = 0; i < bound; i++) {
            rst[i] = k * k++;
        }
        return rst;
    }
}