package ru.job4j.inheritance;

public class TextReport {
    public String generate(String name, String body) {
        return name + body;
    }

    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("name", "body");
        System.out.println(text);
    }
}
