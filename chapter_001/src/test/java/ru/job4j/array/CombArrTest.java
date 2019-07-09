package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CombArrTest {
    @Test
    public void twoArraysInOne () {
        int[] a = {1, 3};
        int[] b = {2, 4};
        assertThat(CombArr.merge(a, b), is(new int[] {1, 2, 3, 4}));
    }
}
