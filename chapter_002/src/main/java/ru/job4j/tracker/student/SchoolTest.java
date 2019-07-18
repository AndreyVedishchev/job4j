package ru.job4j.tracker.student;

import java.util.ArrayList;
import java.util.List;

public class SchoolTest {
    List<Student> addClassA(Student student) {
        List<Student> list = new ArrayList<>();
        list.add(student);
        System.out.println("A " + list);
        return list;
    }

    List<Student> addClassB(Student student) {
        List<Student> list = new ArrayList<>();
        list.add(student);
        System.out.println("B " + list);
        return list;
    }

    List<Student> addClassC(Student student) {
        List<Student> list = new ArrayList<>();
        list.add(student);
        System.out.println("C " + list);
        return list;
    }
}