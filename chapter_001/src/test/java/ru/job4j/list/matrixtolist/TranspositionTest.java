package ru.job4j.list.matrixtolist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TranspositionTest {

    @Test
    public void matrixToList() {
        Transposition tr = new Transposition();
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> result = tr.funck(matrix);
        List<Integer> expect = Arrays.asList(
                1, 2, 3, 4
        );
        assertThat(result, is(expect));
    }
}
