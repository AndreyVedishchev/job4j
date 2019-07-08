package ru.job4j.array;
import java.util.Arrays;

public class CombArr {

    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;
        int i = 0;

        while (i < res.length) {
            res[i] = a[indexA] < b[indexB] ? a[indexA++] : b[indexB++];
            if (indexA == a.length) {
                System.arraycopy(b, indexB, res, ++i, b.length - indexB);
                break;
            }
            if (indexB == b.length) {
                System.arraycopy(a, indexA, res, ++i, a.length - indexA);
                break;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2, 4};
        System.out.println(Arrays.toString(merge(a, b)));
    }
}
