package ru.job4j.tracker.streamapinew;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparator<Student> {

    private String name;
    private int scope;

    public Student() {

    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted(this)
                .takeWhile(v -> v.getScope() < bound).collect(Collectors.toList());
    }

    @Override
    public int compare(Student o1, Student o2) {
        int res;
        if (o1.getScope() == o2.getScope()) {
            res = 0;
        }

        if (o1.getScope() > o2.getScope()) {
            res = 1;
        } else {
            res = -1;
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope
                && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='"
                + name
                + '\''
                + ", scope="
                + scope
                + '}';
    }
}
