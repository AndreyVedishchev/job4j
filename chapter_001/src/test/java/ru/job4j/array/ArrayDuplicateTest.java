package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] arr = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(arr);
        assertThat(result, is(new String[]{"Привет", "Мир", "Супер"}));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate2() {
        String[] arr = {"Привет", "Привет", "Привет", "Привет", "Привет", "Привет"};
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(arr);
        assertThat(result, is(new String[]{"Привет"}));
    }
}
