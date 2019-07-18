package ru.job4j.tracker.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return null;
    }

    public static void main(String[] args) {
        School school = new School();
        SchoolTest schoolTest = new SchoolTest();
        List<Student> a;
        List<Student> b;
        List<Student> c;
        List<Student> list = new ArrayList<>(
                Arrays.asList(
                        new Student(10),
                        new Student(55),
                        new Student(80),
                        new Student(64),
                        new Student(96),
                        new Student(42)
                )
        );
        a = list.stream().filter(student -> student.score > 70).collect(Collectors.toList());
        b = list.stream().filter(student -> student.score > 50
                                            && student.score <= 70).collect(Collectors.toList());
        c = list.stream().filter(student -> student.score > 1
                                            && student.score <= 50).collect(Collectors.toList());

        a.forEach(schoolTest::addClassA);
        b.forEach(schoolTest::addClassB);
        c.forEach(schoolTest::addClassC);
    }
}
