package ru.job4j.array;

/**
 * вывод массива в обратном порядке
 */
public class Turn {

    /**
     * back
     * @param array - входящий массив
     * @return массив в обратном порядке
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length-index-1] = temp;
        }
        return array;
    }
}
