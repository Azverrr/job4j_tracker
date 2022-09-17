package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void createItem() {
        String[] answers = {"problem"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("problem");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void editItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Edit item");
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId()), "Edit item"};
        StartUI.editItem(new StubInput(answer), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName()).isEqualTo("Edit item");
    }

    @Test
    void deleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("deleted item");
        tracker.add(item);
        String[] answer = {String.valueOf(item.getId()), "deleted item"};
        StartUI.deleteItem(new StubInput(answer), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted).isEqualTo(null);
    }
}