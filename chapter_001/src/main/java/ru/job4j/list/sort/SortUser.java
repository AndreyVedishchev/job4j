package ru.job4j.list.sort;

import java.util.*;

public class SortUser {
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getNameSize().compareTo(o2.getNameSize());
                    }
                }
        );
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        if (o1.getName().compareTo(o2.getName()) != 0) {
                            return o1.getName().compareTo(o2.getName());
                        } else {
                            return o1.getAge().compareTo(o2.getAge());
                        }
                    }
                }
        );
        return list;
    }

    public static void main(String[] args) {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("25", "Сергей"),
                new User("30", "Сергей"),
                new User("25", "Иван"),
                new User("30", "Иван")
        ));

        System.out.println(list);
        System.out.println(sortUser.sortByAllFields(list));
        System.out.println(sortUser.sortNameLength(list));
    }
}
