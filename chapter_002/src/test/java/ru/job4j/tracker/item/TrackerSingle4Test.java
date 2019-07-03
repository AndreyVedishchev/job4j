package ru.job4j.tracker.item;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle4Test {

    @Test
    public void testSingleObject() {
        TrackerSingle4 tracker = TrackerSingle4.getInstance();
        TrackerSingle4 tracker1 = TrackerSingle4.getInstance();
        assertThat(tracker, is(tracker1));
    }
}
