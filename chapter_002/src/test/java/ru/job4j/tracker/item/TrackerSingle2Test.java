package ru.job4j.tracker.item;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle2Test {

    @Test
    public void testSingleObject() {
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
        TrackerSingle2 tracker1 = TrackerSingle2.getInstance();
        assertThat(tracker, is(tracker1));
    }
}
