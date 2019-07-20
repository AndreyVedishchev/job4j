package ru.job4j.tracker.student;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Predicate;

public class SchoolTest {

    @Test
    public void addClassA() {
        School school = new School();
        List<Student> list = new ArrayList<>(
                Arrays.asList(
                        new Student(10, "s1"),
                        new Student(55, "s2"),
                        new Student(80, "s3"),
                        new Student(64, "s4"),
                        new Student(96, "s5"),
                        new Student(42, "s6")
                )
        );
        Predicate<Student> predicate = s -> s.score >= 70;
        Map<String, Student> res = school.collect(list, predicate);
        Map<String, Student> exp = new HashMap<>(
                Map.of(
                        "s3", new Student(80, "s3"),
                        "s5", new Student(96, "s5")
                )
        );
        assertThat(res.toString(), is(exp.toString()));
    }

    @Test
    public void addClassB() {
        School school = new School();
        List<Student> list = new ArrayList<>(
                Arrays.asList(
                        new Student(10, "s1"),
                        new Student(55, "s2"),
                        new Student(80, "s3"),
                        new Student(64, "s4"),
                        new Student(96, "s5"),
                        new Student(42, "s6")
                )
        );
        Predicate<Student> predicate = s -> s.score > 50
                && s.score < 70;
        Map<String, Student> res = school.collect(list, predicate);
        Map<String, Student> exp = new HashMap<>(
                Map.of(
                        "s2", new Student(55, "s2"),
                        "s4", new Student(64, "s4")
                )
        );
        assertThat(res.toString(), is(exp.toString()));
    }

    @Test
    public void addClassC() {
        School school = new School();
        List<Student> list = new ArrayList<>(
                Arrays.asList(
                        new Student(10, "s1"),
                        new Student(55, "s2"),
                        new Student(80, "s3"),
                        new Student(64, "s4"),
                        new Student(96, "s5"),
                        new Student(42, "s6")
                )
        );
        Predicate<Student> predicate = s -> s.score < 50;
        Map<String, Student> res = school.collect(list, predicate);
        assertThat(res.toString(), is(
                Map.of(
                        "s1", new Student(10, "s1"),
                        "s6", new Student(42, "s6")
                ).toString())
        );
    }
}
