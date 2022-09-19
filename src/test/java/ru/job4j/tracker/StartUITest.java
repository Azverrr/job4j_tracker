package ru.job4j.tracker;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

    public class StartUITest {
        @Test
        public void whenCreateItem() {
            Output output = new ConsoleOutput();
            Input in = new StubInput(
                    new String[]{"0", "Item name", "1"}
            );
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(output),
                    new ExitAction()
            };
            new StartUI(output).init(in, tracker, actions);
            assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
        }

        @Test
        public void whenReplaceItem() {
            Tracker tracker = new Tracker();
            Output output = new ConsoleOutput();
            Item item = tracker.add(new Item("Replaced item"));
            String replacedName = "New item name";
            Input in = new StubInput(
                    new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
            );
            UserAction[] actions = {
                    new EditAction(output),
                    new ExitAction()
            };
            new StartUI(output).init(in, tracker, actions);
            assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
        }

        @Test
        public void whenDeleteItem() {
            Tracker tracker = new Tracker();
            Output output = new ConsoleOutput();
            Item item = tracker.add(new Item("Deleted item"));
            Input in = new StubInput(
                    new String[] {"0", String.valueOf(item.getId()), "1"}
            );
            UserAction[] actions = {
                    new DeleteAction(output),
                    new ExitAction()
            };
            new StartUI(output).init(in, tracker, actions);
            assertThat(tracker.findById(item.getId())).isNull();
        }

        @Test
        public void whenEditItemTestOutputIsSuccessfully() {
            Output out = new StubOutput();
            Tracker tracker = new Tracker();
            Item one = tracker.add(new Item("test1"));
            String replaceName = "New Test Name";
            Input in = new StubInput(
                    new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
            );
            UserAction[] actions = new UserAction[]{
                    new EditAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            String ln = System.lineSeparator();
            assertThat(out.toString()).isEqualTo(
                             "0. Edit item" + ln
                            + "1. Exit" + ln
                            + "=== Edit item ===" + ln
                            + "Заявка изменена успешно" + ln
                            + "0. Edit item" + ln
                            + "1. Exit" + ln
            );
        }

        @Test
        public void whenShowAllItemActionTestOutputIsSuccessfully() {
            Output out = new StubOutput();
            Tracker tracker = new Tracker();
            Item one = tracker.add(new Item("test1"));
            Input in = new StubInput(
                    new String[] {"0", "1"}
            );
            UserAction[] actions = new UserAction[]{
                    new ShowAllItem(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            String ln = System.lineSeparator();
            assertThat(out.toString()).isEqualTo(
                    "0. Show all items" + ln
                            + "1. Exit" + ln
                            + "=== Show all items ===" + ln
                            + one + ln
                            + "0. Show all items" + ln
                            + "1. Exit" + ln
            );
        }

        @Test
        public void whenFindByNameActionTestOutputIsSuccessfully() {
            Output out = new StubOutput();
            Tracker tracker = new Tracker();
            Item one = tracker.add(new Item("test1"));
            Input in = new StubInput(
                    new String[] {"0","test1", "1"}
            );
            UserAction[] actions = new UserAction[]{
                    new FindByNameAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            String ln = System.lineSeparator();
            assertThat(out.toString()).isEqualTo(
                    "0. Find items by name" + ln
                            + "1. Exit" + ln
                            + "=== Find items by name ===" + ln
                            + one + ln
                            + "0. Find items by name" + ln
                            + "1. Exit" + ln
            );
        }

        @Test
        public void whenFindByIdActionTestOutputIsSuccessfully() {
            Output out = new StubOutput();
            Tracker tracker = new Tracker();
            Item one = tracker.add(new Item("test1"));
            Input in = new StubInput(
                    new String[] {"0",String.valueOf(one.getId()), "1"}
            );
            UserAction[] actions = new UserAction[]{
                    new FindByIdAction(out),
                    new ExitAction()
            };
            new StartUI(out).init(in, tracker, actions);
            String ln = System.lineSeparator();
            assertThat(out.toString()).isEqualTo(
                    "0. Find item by id" + ln
                            + "1. Exit" + ln
                            + "=== Find item by id ===" + ln
                            + one + ln
                            + "0. Find item by id" + ln
                            + "1. Exit" + ln
            );
        }
    }