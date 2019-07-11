package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    //private final Item[] items = new Item[10];
    private List<Item> items = new ArrayList<>();

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
        //this.items[this.position++] = item;
        this.items.add(position++, item);
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
        for (int i = 0; i < position; i++) {
            /*if (items[i].getId().equals(id)) {
                items[i] = item;
                item.setId(id);
                return true;
            }*/
            if (items.get(i).getId().equals(id)) {
                items.set(i, item);
                item.setId(id);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String id) {
    int counter = 0;
        for (int i = 0; i < position; i++) {
            counter++;
            /*if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, items.length - counter - 1);
                position--;
                return true;
            }*/
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public void edit(Item fresh) {
        /*for (int index = 0; index != items.length; ++index) {
            Item item = items[index];
            if (item.getId().equals(fresh.getId())) {
                items[index] = fresh;
                break;
            }
        }*/
        for (int index = 0; index != items.size(); ++index) {
            Item item = items.get(index);
            if (item.getId().equals(fresh.getId())) {
                items.set(index, fresh);
                break;
            }
        }
    }

    /*public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }*/

    public List<Item> findAll() {
        return items;
    }

    /*public Item[] findByName(String key) {
        Item[] arrayCopy = new Item[position];
        int counter = 0;
        for (int i = 0; i < position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                arrayCopy[counter++] = items[i];
            }
        }
        return Arrays.copyOf(arrayCopy, counter);
    }*/

    public List<Item> findByName(String key) {
        List<Item> arrayCopy = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                arrayCopy.add(item);
            }
        }
        return arrayCopy;
    }

    public Item findById(String id) {
        for (int i = 0; i < position; i++) {
            /*if (items[i].getId().equals(id)) {
                return items[i];
            }*/
            if (items.get(i).getId().equals(id)) {
                return items.get(i);
            }
        }
        return null;
    }
}