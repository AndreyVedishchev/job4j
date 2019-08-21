package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void whenMoveSuccess() {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C1);
        assertThat(logic.move(Cell.C1, Cell.G5), is(true));
    }

    @Test
    public void whenWayBusy() {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Figure pawnBlack = new PawnBlack(Cell.D2);
        assertThat(logic.move(Cell.C1, Cell.G5), is(false));
    }
}
