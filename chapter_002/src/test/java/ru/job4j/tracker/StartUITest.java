package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.currentTimeMillis;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    /**
     * Получение поля с дефолтным выводом в консоль
     */
    private final PrintStream stdout = System.out;

    /**
     * буфер для результата
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenInvalidInput() {
        List<Integer> ranges = new ArrayList<>();
        ranges.add(0);
        ranges.add(1);
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Enter", ranges);
        assertThat(
                this.out.toString(),
                is(
                        String.format("Введите корректные данные.%n")
                )
        );
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), /*itemRepl.getId(),*/"test replace", "desc repl", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().size(), is(0));
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
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is("test name"));
    }

    @Test
    public void whenShowItems() {
        String menu = new StringBuilder()
                        .append("0 : Добавление новой заявки.")
                        .append(System.lineSeparator())
                        .append("1 : Показать все заявки.")
                        .append(System.lineSeparator())
                        .append("2 : Редактирование заявки.")
                        .append(System.lineSeparator())
                        .append("3 : Удаление заявки.")
                        .append(System.lineSeparator())
                        .append("4 : Поиск заявки по id.")
                        .append(System.lineSeparator())
                        .append("5 : Поиск заявки по Имени.")
                        .append(System.lineSeparator())
                        .append("6 : Выход из программы.")
                        .append(System.lineSeparator())
                        .toString();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", currentTimeMillis()));
        Input input = new StubInput(new String[]{"1", "6"});
        StartUI startUI = new StartUI(input, tracker);
        startUI.init();
        assertThat(this.out.toString(),
                is(menu + item.getId() + ". " + item.getName() + System.lineSeparator() + menu)
        );
    }

    @Test
    public void whenShowMenu() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();
        assertThat(this.out.toString(),
                is(
                        new StringBuilder()
                                .append("0 : Добавление новой заявки.")
                                .append(System.lineSeparator())
                                .append("1 : Показать все заявки.")
                                .append(System.lineSeparator())
                                .append("2 : Редактирование заявки.")
                                .append(System.lineSeparator())
                                .append("3 : Удаление заявки.")
                                .append(System.lineSeparator())
                                .append("4 : Поиск заявки по id.")
                                .append(System.lineSeparator())
                                .append("5 : Поиск заявки по Имени.")
                                .append(System.lineSeparator())
                                .append("6 : Выход из программы.")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }
}