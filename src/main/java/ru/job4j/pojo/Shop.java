package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int result = -1;
        for (int i = 0; i < products.length; i++) {
            Product tmp = products[i];
            if (tmp == null) {
                result = i;
                break;
            }
        }
        return result;
    }
}