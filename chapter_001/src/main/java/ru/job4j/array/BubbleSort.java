package ru.job4j.array;

/**
 * реализация сортировки пузырьком
 */
public class BubbleSort {

    /**
     * sort
     * @param arr - входной массив
     * @return отсортированный массив
     */
    public int[] sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }
}
