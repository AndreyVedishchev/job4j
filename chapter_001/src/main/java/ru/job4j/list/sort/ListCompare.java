package ru.job4j.list.sort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int res = 0;
        int index = left.length() > right.length() ? right.length() : left.length();
        
        for (int i = 0; i < index; i++) {
            if (left.charAt(i) == right.charAt(i)) {
                continue;
            }
            if (left.charAt(i) > right.charAt(i)) {
                res = 1;
                break;
            }
            if (left.charAt(i) < right.charAt(i)) {
                res = -1;
                break;
            }
        }

        if (res == 0 && left.length() != right.length()) {
            if (left.length() > right.length()) {
                res = 1;
            }
            if (left.length() < right.length()) {
                res = -1;
            }
        }
        return res;
    }
}