package ru.job4j.tracker.student;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.function.Predicate;

public class SchoolTest {

    @Test
    public void addClassA() {
        School school = new School();
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
        Predicate<Student> predicate = s -> s.score >= 70;
        List<Student> res = school.collect(list, predicate);
        assertThat(res.toString(), is(
                Arrays.asList(
                        new Student(80),
                        new Student(96)
                ).toString()
        ));
    }

    @Test
    public void addClassB() {
        School school = new School();
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
        Predicate<Student> predicate = s -> s.score > 50
                && s.score < 70;
        List<Student> res = school.collect(list, predicate);
        assertThat(res.toString(), is(
                Arrays.asList(
                        new Student(55),
                        new Student(64)
                ).toString()
        ));
    }

    @Test
    public void addClassC() {
        School school = new School();
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
        Predicate<Student> predicate = s -> s.score < 50;
        List<Student> res = school.collect(list, predicate);
        assertThat(res.toString(), is(
                Arrays.asList(
                        new Student(10),
                        new Student(42)
                ).toString()
        ));
    }
}
