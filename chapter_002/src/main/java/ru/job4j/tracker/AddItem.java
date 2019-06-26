package ru.job4j.tracker;

import static java.lang.System.currentTimeMillis;

public class AddItem implements UserAction {

    @Override
    public int key() {
        return 0;//ADD;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        long time = currentTimeMillis();
        Item item = new Item(name, desc, time);
        tracker.add(item);
        System.out.println("------------ Новая заявка с id : " + item.getId() + " -----------");
    }

    @Override
    public String info() {
        return "Add new Item.";
    }
}