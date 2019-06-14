package ru.job4j.tracker.figure;

public class Triangle implements Shape {

    /**
     * @author Andrey Vedishchev
     * @version $Id$
     * @since 0.1
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+\n");
        pic.append("++\n");
        pic.append("+ +\n");
        pic.append("+  +\n");
        pic.append("+   +\n");
        pic.append("+    +\n");
        pic.append("+++++++");
        return pic.toString();
    }
}
