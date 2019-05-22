package ru.job4j.loop;

/**
 * Суммирует числа в цикле
 */
public class Counter {


    /**
     * add
     * @param start - стартовое число
     * @param finish - конечное число
     * @return сумма четных чисел в диапазоне
     */
    public int add(int start, int finish) {
        int sum = 0;

        for(int i = start; i <= finish; i++) {
            if(i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}