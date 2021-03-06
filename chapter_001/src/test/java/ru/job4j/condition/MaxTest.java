package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenLeft2Right1Max2() {
        Max max = new Max();
        int result = max.max(2, 1);
        assertThat(result, is(2));
    }

    @Test
    public void whenLeft2Right2Max2() {
        Max max = new Max();
        int result = max.max(2, 2);
        assertThat(result, is(2));
    }

    @Test
    public void when3Elem2Max() {
        Max max = new Max();
        int result = max.max(2, 5, 4);
        assertThat(result, is(5));
    }

    @Test
    public void when4Elem4Max() {
        Max max = new Max();
        int result = max.max(2, 5, 4,  7);
        assertThat(result, is(7));
    }
}