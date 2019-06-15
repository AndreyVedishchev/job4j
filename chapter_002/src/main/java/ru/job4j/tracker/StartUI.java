package ru.job4j.tracker;

import static java.lang.System.currentTimeMillis;

/**
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для отображения всех заявок.
     */
    private static final String SHOW_ALL = "1";

    /**
     * Константа для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа для поиска заявки по id.
     */
    private static final String FIND_BY_ID = "4";

    /**
     * Константа для поиска заявки по имени.
     */
    private static final String FIND_BY_NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
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
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long time = currentTimeMillis();
        Item item = new Item(name, desc, time);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с id : " + item.getId() + " -----------");
    }

    /**
     * Метод отображает заведенные заявки
     */
    void showItems() {
        Item[] arr = this.tracker.findAll();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Заявка №" + (i + 1) + " ****** " + arr[i].toString());
        }
    }

    /**
     * Метод вызова редактирования
     */
    private void elementEdit() {
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
    }

    /**
     * Метод вызова удаления
     */
    private void elementDelete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки для удаления:");
        if (this.tracker.delete(id)) {
            System.out.println("--------- Заявка с id " + id + " удалена --------");
        } else {
            System.out.println("--------- Заявка с id " + id + " не заведена --------");
        }
    }

    /**
     * Метод вызова поиска по id
     */
    private void elementFindById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки:");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("--------- Заявка с id " + id + " не заведена --------");
        }
    }

    /**
     * Метод вызова поиска по имени
     */
    private void elementFindByName() {
        System.out.println("------------ Поиск заявки имени --------------");
        String name = this.input.ask("Введите имя заявки:");
        Item[] item = this.tracker.findByName(name);
        for (int i = 0; i < item.length; i++) {
            System.out.println(item[i].toString());
        }

        if (item.length < 1) {
            System.out.println("--------- Заявка с именем " + name + " не заведена --------");
        }
    }

    /**
     * Метод отображения пунктов меню
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}