package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        int[] arr = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        BubbleSort bubbleSort = new BubbleSort();
        int[] exp = bubbleSort.sort(arr);
        assertThat(arr, is(exp));
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
    }
}