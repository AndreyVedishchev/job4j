package ru.job4j.tracker.student;

public class Student {
    public int score;
    public String surname;

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return  "score="
                + score
                + ", surname='"
                + surname
                + '\''
                + '}';
    }
}
