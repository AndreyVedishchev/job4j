package ru.job4j.condition;

public class SqArea {
    public static int square(int p, int k) {

        double h = p / (2 / k + 2);
        double w = h / k;

        return (int) (w * h);
    }
}