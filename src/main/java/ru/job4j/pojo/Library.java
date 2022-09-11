package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Lord of the ring", 1200);
        books[1] = new Book("Война и мир", 1500);
        books[2] = new Book("Clean code", 500);
        books[3] = new Book("Проклятые короли", 600);
        for (Book tmp : books) {
            System.out.println("Название книги: " + tmp.getName() + ", " + "Количество страниц: "
                    + tmp.getNumberOfPage());
        }
        System.out.println("Replace index");
        Book temp = new Book("temp", 0);
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book tmp : books) {
            System.out.println("Название книги: " + tmp.getName() + ", " + "Количество страниц: "
                    + tmp.getNumberOfPage());
        }
        System.out.println("Show Clean code");
        for (Book tmp : books) {
            if ("Clean code".equals(tmp.getName())) {
                System.out.println("Название книги: " + tmp.getName() + ", " + "Количество страниц: "
                        + tmp.getNumberOfPage());
            }
        }
    }
}
