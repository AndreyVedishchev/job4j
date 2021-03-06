package ru.job4j.list.matrixtolist;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TranspositionTest {

    @Test
    public void matrixToList() {
        Transposition tr = new Transposition();
        Integer[][] matrix = new Integer[][]{{1, 2}, {3, 4}};
        List<Integer> result = tr.funck(matrix);
        List<Integer> expect = List.of(
                1, 2, 3, 4
        );
        assertThat(result, is(expect));
    }
}
