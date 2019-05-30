package ru.job4j.array;

import java.util.Arrays;

/**
 * убирает повторы в массиве.
 */
public class ArrayDuplicate {

    /**
     * remove
     * @param array - вхлдной массив
     * @return - массив без повторов
     */
    public String[] remove(String[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - temp; j++) {
                if (array[i].equals(array[j])) {
                    while (j != array.length - temp - 1
                                && array[array.length - temp - 1].equals(array[j])) {
                        temp++;
                    }
                    String t = array[array.length - temp - 1];
                    array[array.length - temp - 1] = array[j];
                    array[j] = t;
                    temp++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - temp);
    }
}
