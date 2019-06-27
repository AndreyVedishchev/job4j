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
        this.actions[0] = new MenuTracker.AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new MenuTracker.EditItem();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindItemById();
        this.actions[5] = new MenuTracker.FindItemByName();
        this.actions[6] = new MenuTracker.ExitProgramm();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for(UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private static class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc, currentTimeMillis()));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавление новой заявки.");
        }
    }

    private static class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(
                        String.format("%s. %s", item.getId(), item.getName())
                );
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки.");
        }
    }

    private static class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Редактирование заявки.");
        }
    }

    private static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удаление заявки.");
        }
    }


    private static class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по id.");
        }
    }

    private static class FindItemByName implements UserAction {
        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по Имени.");
        }
    }

    private static class ExitProgramm implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            StartUI.exit = false;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выход из программы.");
        }
    }
}
