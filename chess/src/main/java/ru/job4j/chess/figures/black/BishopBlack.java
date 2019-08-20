package ru.job4j.chess.figures.black;

import ru.job4j.chess.Board;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not move by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x;
        int deltaY = source.y;
        for (int index = 0; index < size; index++) {
            //steps[index] = new Cell(deltaX, deltaY);
            deltaX = source.x < dest.x ? deltaX++ : deltaX--;
            deltaY = source.y < dest.y ? deltaY++ : deltaY--;
        }

        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return dest.x - source.x == dest.y - source.y
                || dest.x - source.x == source.y - dest.y
                || dest.x + source.x == dest.y - source.y
                || dest.x + source.x == source.y - dest.y;
    }
}
