package ru.job4j.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(i, array[i][j]);
            }
        }
        Collections.sort(list);
        return list;
    }
}