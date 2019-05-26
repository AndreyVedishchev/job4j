package ru.job4j.array;

/**
 * поиск по массиву
 */
public class FindLoop {

    /**
     * indexOf
     * @param data - массив для поиска
     * @param el - искомый элемент
     * @return результат поиска
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}