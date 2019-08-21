package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void checkPosition() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void checkCopy() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopCopy = bishopBlack.copy(Cell.C1);
        assertThat(bishopCopy, is(bishopBlack));
    }

    @Test
    public void checkWayIfDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cellArr = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.C1, Cell.G5), is(cellArr));
    }

    @Test
    public void checkWayIfNotDiagonal() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.way(Cell.C1, Cell.E3), is(
        new IllegalStateException(
                String.format("Could not move by diagonal from %s to %s", Cell.C1, Cell.E3)
            )
        ));
    }
}
