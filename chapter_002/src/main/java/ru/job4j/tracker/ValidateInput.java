package ru.job4j.tracker;

import java.util.List;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> ranges) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, ranges);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Введите номер действия из меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректные данные.");
            }
        }
        while (invalid);
        return value;
    }
}
