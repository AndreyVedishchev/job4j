package ru.job4j.array;

/**
 * проверка диагоналей двумерного массива
 */
public class MatrixCheck {

    /**
     * mono
     * @param data - входной массив
     * @return результат проверки
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;

        for (int i = 1, j = 1, k = 0, l = data.length - 1; i < data.length - 1; i++, j++, k++, l++) {
            if (data[i - 1][j - 1] != data[i][j] || data[k + 1][l - 1] != data[k][l]) {
                result = false;
                break;
            }
        }
        return result;
    }
}