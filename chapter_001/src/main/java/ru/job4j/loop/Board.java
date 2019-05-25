package ru.job4j.loop;

/**
 * @author Andrey Vedishchev (avedishchev@list.ru)
 * @version $Id$
 * @since 0.1
 */
public class Board {

    /**
     * @param width - ширина
     * @param height - высота
     * @return выводит шахматную доску
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i <= height - 1; i++) {
            for (int j = 0; j <= width - 1; j++) {
                if ((j + i) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}