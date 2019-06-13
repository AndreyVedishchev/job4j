package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        /*Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));*/

        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        Item itemRepl = tracker.add(new Item("test replace", "desc repl", currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), itemRepl.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));
    }

    @Test
    public void whenFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getId(), is(item.getId()));
    }

    @Test
    public void whenFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName())[0].getName(), is("test name"));
    }

    @Test
    public void whenExitProgramm() {
        /*Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        Item item1 = tracker.add(new Item("test name1", "desc1", currentTimeMillis()));
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();*/
    }
}
