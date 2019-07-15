package ru.job4j.list;

import com.sun.javafx.binding.SelectBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int i = 0;
        int j = 0;
        int coef = 0;
        int cells = list.size() / rows;
        cells = (list.size() % rows != 0) ? cells + 1 : cells;
        int[][] array = new int[rows][cells];

        for (int[] ints : array) {
            for (int[] ints1 : array) {
                if (i + j + coef < list.size()) {
                    array[i][j] = list.get(i + j + coef);
                    j++;
                } else {
                    break;
                }
            }
            i++;
            j = 0;
            coef += 2;
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        int index = 0;
        List<Integer> listArr = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                listArr.add(index++, list.get(i)[j]);
            }
        }
        return listArr;
    }
}