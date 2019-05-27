package ru.job4j.array;

import java.util.Arrays;

public class BubbleSort {
    public int[] sort (int[] arr) {
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

    public static void main(String[] args) {
        int []arr = {5,8,3,0,23,7};
        BubbleSort b = new BubbleSort();
        System.out.println(Arrays.toString(b.sort(arr)));
    }
}
