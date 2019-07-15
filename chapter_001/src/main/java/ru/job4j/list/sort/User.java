package ru.job4j.list.sort;

public class User implements Comparable<User> {
    private String age;
    private String name;
    private String nameSize;

    public User(String age, String name) {
        this.age = age;
        this.name = name;
        this.nameSize = String.valueOf(name.length());
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getNameSize() {
        return nameSize;
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
