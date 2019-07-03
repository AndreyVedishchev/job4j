package ru.job4j.tracker.item;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle3Test {

    @Test
    public void testSingleObject() {
        TrackerSingle3 tracker = TrackerSingle3.getInstance();
        TrackerSingle3 tracker1 = TrackerSingle3.getInstance();
        assertThat(tracker, is(tracker1));
    }
}