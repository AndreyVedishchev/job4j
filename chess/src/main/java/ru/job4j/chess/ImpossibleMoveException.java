package ru.job4j.chess;

public class ImpossibleMoveException extends Exception {

    @Override
    public String toString() {
        return "Такой ход не предусмотрен.";
    }
}
