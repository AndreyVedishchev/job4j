package ru.job4j.list.sort;

public class User implements Comparable<User> {
    private String age;
    private String name;

    public User(String age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User user) {
        return this.age.compareTo(user.age);
    }

    @Override
    public String toString() {
        return age + " -> " + name + '\n';
    }
}
