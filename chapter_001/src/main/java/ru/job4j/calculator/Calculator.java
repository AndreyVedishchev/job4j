package ru.job4j.calculator;

/**
 * Class Класс для вычисления арифметических операций + - / *
 * @author Andrey Vedishchev
 * @since 19.05.2019
 * @version 1
 */
public class Calculator {

    /**
     * add
     * @param first - first value
     * @param second - second value
     * @return first + second
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * subtract
     * @param first - first value
     * @param second - second value
     * @return first - second
     */
    public double subtract(double first, double second) {
        return first - second;
    }

    /**
     * div
     * @param first - first value
     * @param second - second value
     * @return first / second
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * multiple
     * @param first - first value
     * @param second - second value
     * @return first * second
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}