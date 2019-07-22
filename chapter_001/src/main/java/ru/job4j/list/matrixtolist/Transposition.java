package ru.job4j.list.matrixtolist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transposition {
    public List<Integer> funck(List<List<Integer>> matrix) {
        return Stream.of(matrix.stream().flatMap(Collection::stream).collect(Collectors.toList()))
                .flatMap(Collection::stream).collect(Collectors.toList());

    }
}