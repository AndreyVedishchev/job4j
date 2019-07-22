package ru.job4j.list;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void listToMap() {
        UserConvert userConvert = new UserConvert();
        User dasha = new User(111, "Dasha", "X");
        User misha = new User(222, "Misha", "Y");
        User sasha = new User(333, "Sasha", "Z");

        List<User> users = new ArrayList<>(
                List.of(dasha, misha, sasha)
        );
        Map<Integer, User> result = userConvert.process(users);

        Map<Integer, User> expect = new HashMap<>(
                Map.of(
                        111, dasha,
                        222, misha,
                        333, sasha
                )
        );

        assertThat(result, is(expect));
    }
}
