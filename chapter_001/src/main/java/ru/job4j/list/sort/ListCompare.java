package ru.job4j.list.sort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int res = 0;
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();
        int index = leftArr.length > rightArr.length ? rightArr.length : leftArr.length;

        for (int i = 0; i < index; i++) {
            if (Character.compare(leftArr[i], rightArr[i]) == 0) {
                continue;
            } else {
                res = Character.compare(leftArr[i], rightArr[i]);
            }
        }
        if (res == 0) {
            if (Integer.compare(leftArr.length, rightArr.length) > 0) {
                res = 1;
            }
            if (Integer.compare(leftArr.length, rightArr.length) < 0) {
                res = -1;
            }
        }
        return res;
    }
}