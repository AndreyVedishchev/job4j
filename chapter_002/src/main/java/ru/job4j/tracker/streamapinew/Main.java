package ru.job4j.tracker.streamapinew;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(
                Arrays.asList(
                        new Student("n1", 33),
                        new Student("n2", 54),
                        new Student("n3", 74),
                        null,
                        new Student("n5", 66)
                )
        );

        Student student = new Student();
        System.out.println(student.levelOf(list, 60).toString());
    }
}
