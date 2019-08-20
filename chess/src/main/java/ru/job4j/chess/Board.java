package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

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

    boolean move(Cell source, Cell dest)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure temp = null;
        /*for (int i = 0; i < figures.length - 1; i++) {
            if (figures[i].position() == source) {

            }
        }*/

        return false;
    }

    public boolean isVert(Cell source, Cell dest) {
        return source.y == dest.y && source.x != dest.x;
    }

    public boolean isHor(Cell source, Cell dest) {
        return source.x == dest.x && source.y != dest.y;
    }
}
