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
        int cut, temp = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    String t = array[j];
                    array[j] = array[temp];
                    array[temp] = t;
                    temp--;
                    break;
                }
            }
        }
        cut = array.length - temp;
        return Arrays.copyOf(array, cut);
    }
}
