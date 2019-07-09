package ru.job4j.array;

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
}
