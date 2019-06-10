package ru.job4j.tracker;

import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[5];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random id = new Random();
        return String.valueOf(Math.abs(id.nextInt()));
    }

    public boolean replace(String id, Item item) {
        if (findById(id) != null) {
            findById(id).setTime(item.getTime());
            findById(id).setDecs(item.getDecs());
            findById(id).setName(item.getName());
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
    boolean res = false;
    int counter = 0;

        for (int i = 0; i < items.length; i++) {
           if (!items[i].getId().equals(id)) {
               counter++;
           } else {
               items[i] = null;
               System.out.println(items[i]);
               break;
           } res = true;
        }

        Item []result = new Item[items.length - 1];
        System.arraycopy(items, 0, result, 0, counter);
        System.arraycopy(items, counter, result, counter, items.length - counter - 1);

        return res;
    }

    public Item[] findAll() {
        int counter = 0;
        for (Item element : items) {
            if (element != null) {
                counter++;
            }
        }

        Item []arrayCopy = new Item[counter];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                arrayCopy[i] = items[i];
            }
        }
        return arrayCopy;
    }

    public Item[] findByName(String key) {
        Item []arrayCopy;
        int counter = 0;
        for (Item element : items) {
            if (element.getName().equals(key)) {
                counter++;
            }
        }

        arrayCopy = new Item[counter];
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                arrayCopy[i] = items[i];
            }
        }
        return arrayCopy;
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}