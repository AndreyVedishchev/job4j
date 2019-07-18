package ru.job4j.tracker.student;

public class Student {
    public int score;

    public Student(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}';
    }
}
