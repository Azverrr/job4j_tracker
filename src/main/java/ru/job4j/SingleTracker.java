package ru.job4j;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public final class SingleTracker {
    private static Tracker tracker = new Tracker();
    static SingleTracker singleTracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return findByName(key);
    }

    public Item findById(int id) {
        return findById(id);
    }

    public boolean replace(int id, Item item) {
        return replace(id, item);
    }

    private int indexOf(int id) {
        return indexOf(id);
    }

    public boolean delete(int id) {
        return delete(id);
    }
}
