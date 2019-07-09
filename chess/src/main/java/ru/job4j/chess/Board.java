package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class Board {
    final int sizeBoard = 32;
    Figure[] figures = new Figure[sizeBoard];
    int cnt = 0;

    public void add(Figure figure) {
        if (cnt <= sizeBoard - 1) {
            figures[cnt] = new Figure() {
                @Override
                public Cell position() {
                    return null;
                }

                @Override
                public Cell[] way(Cell source, Cell dest) {
                    return new Cell[0];
                }

                @Override
                public Figure copy(Cell dest) {
                    return null;
                }
            };
        }
    }
}
