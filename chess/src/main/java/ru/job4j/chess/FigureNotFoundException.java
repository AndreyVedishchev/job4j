package ru.job4j.chess;

public class FigureNotFoundException extends Exception {

    @Override
    public String toString() {
        return "Фигура не найдена.";
    }
}
