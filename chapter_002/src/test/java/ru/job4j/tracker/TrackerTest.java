package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteElement() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1","testDescription",123L);
        Item second = new Item("test2","testDescription2",1234L);
        Item third = new Item("test3","testDescription3",12345L);
        Item four = new Item("test4","testDescription4",1345L);
        Item five = new Item("test5","testDescription5",1348L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(four);
        tracker.add(five);
        System.out.println(third.getName());
        tracker.delete(third.getId());
        System.out.println(third.getName());
    }

    @Test
    public void returnArrayWithoutNullElements() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1","testDescription",123L);
        Item second = new Item("test2","testDescription2",1234L);
        Item third = new Item("test3","testDescription3",12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        assertThat(tracker.findAll().length, is(3));
    }

    @Test
    public void returnArrayWhenFindByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1","testDescription",123L);
        Item second = new Item("test2","testDescription2",1234L);
        Item third = new Item("test3","testDescription3",12345L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        System.out.println(Arrays.toString(tracker.findByName("test2")));
    }
}