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
        for (int i = 1; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                if (data[i - 1][j - 1] != data[i][j]) {
                    result = false;
                    break;
                }
            }
        }

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = data[i].length - 1; j >= 1; j--) {
                if (data[i + 1][j - 1] != data[i][j]) {
                    result = false;
                    break;
                } else i++;
            }
        }
        return result;
    }
}