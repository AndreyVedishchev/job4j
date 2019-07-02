package ru.job4j.tracker;

import static java.lang.System.currentTimeMillis;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public UserAction[] getActions() {
        return actions;
    }

    public void fillActions() {
        this.actions[0] = new MenuTracker.AddItem(0, "Добавление новой заявки.");
        this.actions[1] = new MenuTracker.ShowItems(1, "Показать все заявки.");
        this.actions[2] = new MenuTracker.EditItem(2, "Редактирование заявки.");
        this.actions[3] = new MenuTracker.DeleteItem(3, "Удаление заявки.");
        this.actions[4] = new MenuTracker.FindItemById(4, "Поиск заявки по id.");
        this.actions[5] = new MenuTracker.FindItemByName(5, "Поиск заявки по Имени.");
        this.actions[6] = new MenuTracker.ExitProgramm(6, "Выход из программы.");
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private static class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc, currentTimeMillis()));
        }
    }

    private static class ShowItems extends BaseAction {

        protected ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(
                        String.format("%s. %s", item.getId(), item.getName())
                );
            }
        }
    }

    private static class EditItem extends BaseAction {
        protected EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc, currentTimeMillis());
            item.setId(id);
            tracker.edit(item);
        }
    }

    private static class DeleteItem extends BaseAction {
        protected DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id заявки: ");
            if (tracker.delete(id)) {
                System.out.println("--------- Заявка с id " + id + " удалена --------");
            } else {
                System.out.println("--------- Заявка с id " + id + " не заведена --------");
            }
        }
    }

    private static class FindItemById extends BaseAction {
        protected FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("--------- Заявка с id " + id + " не заведена --------");
            }
        }
    }

    private static class FindItemByName extends BaseAction {
        protected FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки имени --------------");
            String name = input.ask("Введите имя заявки:");
            Item[] item = tracker.findByName(name);
            for (int i = 0; i < item.length; i++) {
                System.out.println(item[i].toString());
            }

            if (item.length < 1) {
                System.out.println("--------- Заявка с именем " + name + " не заведена --------");
            }
        }
    }

    private static class ExitProgramm extends BaseAction {
        protected ExitProgramm(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            StartUI.exit = false;
        }
    }
}
