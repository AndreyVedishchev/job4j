package ru.job4j.tracker.figure;

/**
 * @author Andrey Vedishchev
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint p = new Paint();
        p.draw(new Square());
        p.draw(new Triangle());
    }
}
