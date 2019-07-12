package ru.job4j.list.sort;

import org.junit.Test;
import java.util.*;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void sortAgeUsers() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>(Arrays.asList(
                new User("27", "petr"),
                new User("33", "ivan"),
                new User("33", "ivan"),
                new User("44", "zuma"),
                new User("21", "zuma")
        ));

        Set<User> expect = new TreeSet<>(Arrays.asList(
                new User("21", "zuma"),
                new User("27", "petr"),
                new User("33", "ivan"),
                new User("44", "zuma")
        ));
        assertThat(sortUser.sort(list), is(expect));
    }
}
