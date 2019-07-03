package ru.job4j.tracker.item;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingle1Test {

    @Test
    public void addSinglrObject() {
        TrackerSingle1 tracker = TrackerSingle1.INSTANCE;
        TrackerSingle1 tracker1 = TrackerSingle1.INSTANCE;
        assertThat(tracker, is(tracker1));
    }
}
