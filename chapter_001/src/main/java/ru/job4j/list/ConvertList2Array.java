package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int coef = 0;
        int cells = list.size() / rows;
        cells = (list.size() % rows != 0) ? cells + 1 : cells;
        int[][] array = new int[rows][cells];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i + j + coef < list.size()) {
                    array[i][j] = list.get(i + j + coef);
                } else break;
            }
            coef += 2;
        }
        return array;
    }
}