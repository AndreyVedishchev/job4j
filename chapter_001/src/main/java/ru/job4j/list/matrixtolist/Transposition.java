package ru.job4j.list.matrixtolist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Transposition {
    public List<Integer> funck(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}