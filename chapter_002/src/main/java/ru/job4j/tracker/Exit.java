package ru.job4j.tracker;

public class Exit implements UserAction {
    private final StartUI ui;

    public Exit(StartUI ui) {
        this.ui = ui;
    }

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        this.ui.stop();
    }

    @Override
    public String info() {
        return "6 : Выход из программы.";
    }
}
