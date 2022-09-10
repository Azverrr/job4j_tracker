package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book lordOfTheRing = new Book("Lord of the ring", 1200);
        Book warAndPeace = new Book("Война и мир", 1500);
        Book cleanCode = new Book("Clean code", 500);
        Book[] books = new Book[3];
        books[0] = lordOfTheRing;
        books[1] = warAndPeace;
        books[2] = cleanCode;
        for (Book tmp : books) {
            System.out.println("Название книги: " + tmp.getName() + ", " + "Количество страниц: "
                    + tmp.getNumberOfPage());
        }
        System.out.println("Replace index");
        books[2] = lordOfTheRing;
        books[0] = cleanCode;
        for (Book tmp : books) {
            System.out.println("Название книги: " + tmp.getName() + ", " + "Количество страниц: "
                    + tmp.getNumberOfPage());
        }
        System.out.println("Show Clean code");
        for (Book tmp : books) {
            if (tmp.getName().equals("Clean code")) {
                System.out.println("Название книги: " + tmp.getName() + ", " + "Количество страниц: "
                        + tmp.getNumberOfPage());
            }
        }
    }
}
