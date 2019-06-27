package ru.job4j.tracker;

import static java.lang.System.currentTimeMillis;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    public static boolean exit;

    /**
     * Константа меню для добавления новой заявки.
     */
    //private static final String ADD = "0";

    /**
     * Константа для отображения всех заявок.
     */
    //private static final String SHOW_ALL = "1";

    /**
     * Константа для редактирования заявки.
     */
    //private static final String EDIT = "2";

    /**
     * Константа для удаления заявки.
     */
    //private static final String DELETE = "3";

    /**
     * Константа для поиска заявки по id.
     */
    //private static final String FIND_BY_ID = "4";

    /**
     * Константа для поиска заявки по имени.
     */
    //private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    //private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Отображение пунктов меню.
     */
    public final StringBuilder showMenu = new StringBuilder()
            .append("Меню.")
            .append(System.lineSeparator())
            .append("0. Add new Item")
            .append(System.lineSeparator())
            .append("1. Show all items")
            .append(System.lineSeparator())
            .append("2. Edit item")
            .append(System.lineSeparator())
            .append("3. Delete item")
            .append(System.lineSeparator())
            .append("4. Find item by Id")
            .append(System.lineSeparator())
            .append("5. Find items by name")
            .append(System.lineSeparator())
            .append("6. Exit Program");

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        exit = true;
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select:"));
            //exit = (!"y".equals(this.input.ask("Exit?(y):")));
            menu.select(key);
        } while(exit);

        /*while (!exit) {
            //this.showMenu();
            System.out.println(this.showMenu);
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.elementEdit();
            } else if (DELETE.equals(answer)) {
                this.elementDelete();
            } else if (FIND_BY_ID.equals(answer)) {
                this.elementFindById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.elementFindByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }*/
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    /*private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long time = currentTimeMillis();
        Item item = new Item(name, desc, time);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с id : " + item.getId() + " -----------");
    }*/

    /**
     * Метод отображает заведенные заявки
     */
    /*private void showItems() {
        Item[] arr = this.tracker.findAll();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Заявка №" + (i + 1) + " ****** " + arr[i].toString());
        }
    }*/

    /**
     * Метод вызова редактирования
     */
    /*private void elementEdit() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки для замены:");
        String newId = this.input.ask("Введите id новой заявки:");
        Item item = this.tracker.findById(newId);
        if (item != null) {
            this.tracker.replace(id, item);
            System.out.println("---------- Заявка заменена на " + newId + " ----------");
        } else {
            System.out.println("--------- Заявка с id " + newId + " не заведена --------");
        }
    }*/

    /**
     * Метод вызова удаления
     */
    /*private void elementDelete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки для удаления:");
        if (this.tracker.delete(id)) {
            System.out.println("--------- Заявка с id " + id + " удалена --------");
        } else {
            System.out.println("--------- Заявка с id " + id + " не заведена --------");
        }
    }*/

    /**
     * Метод вызова поиска по id
     */
    /*private void elementFindById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки:");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("--------- Заявка с id " + id + " не заведена --------");
        }
    }*/

    /**
     * Метод вызова поиска по имени
     */
    /*private void elementFindByName() {
        System.out.println("------------ Поиск заявки имени --------------");
        String name = this.input.ask("Введите имя заявки:");
        Item[] item = this.tracker.findByName(name);
        for (int i = 0; i < item.length; i++) {
            System.out.println(item[i].toString());
        }

        if (item.length < 1) {
            System.out.println("--------- Заявка с именем " + name + " не заведена --------");
        }
    }*/

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}