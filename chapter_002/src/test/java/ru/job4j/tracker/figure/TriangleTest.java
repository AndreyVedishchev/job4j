package ru.job4j.tracker.figure;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Vedishchev
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    @Test
    public void whenDrawSquare() {
        Triangle triangle = new Triangle();
        assertThat(
                triangle.draw(),
                is(
                        new StringBuilder()
                            .append("+\n")
                            .append("++\n")
                            .append("+ +\n")
                            .append("+  +\n")
                            .append("+   +\n")
                            .append("+    +\n")
                            .append("+++++++")
                                .toString()
                )
        );
    }
}
