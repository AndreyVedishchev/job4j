package ru.job4j.chess;

public class OccupiedWayException extends Exception {

    @Override
    public String toString() {
        return "Путь для хода занят.";
    }
}
