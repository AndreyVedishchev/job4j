package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.currentTimeMillis;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private final Consumer<String> output;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public List<UserAction> getActions() {
        return actions;
    }

    public void fillActions(StartUI ui) {
        this.actions.add(0, new MenuTracker.AddItem(0, "Добавление новой заявки."));
        this.actions.add(1, new MenuTracker.ShowItems(1, "Показать все заявки."));
        this.actions.add(2, new MenuTracker.EditItem(2, "Редактирование заявки."));
        this.actions.add(3, new MenuTracker.DeleteItem(3, "Удаление заявки."));
        this.actions.add(4, new MenuTracker.FindItemById(4, "Поиск заявки по id."));
        this.actions.add(5, new MenuTracker.FindItemByName(5, "Поиск заявки по Имени."));
        this.actions.add(6, new Exit(ui));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
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

    private class ShowItems extends BaseAction {

        protected ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                output.accept(
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
            List<Item> item = tracker.findByName(name);
            for (int i = 0; i < item.size(); i++) {
                System.out.println(item.get(i).toString());
            }

            if (item.size() < 1) {
                System.out.println("--------- Заявка с именем " + name + " не заведена --------");
            }
        }
    }
}
