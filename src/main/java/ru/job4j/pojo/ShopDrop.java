package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int iondex) {
        for (int i = iondex; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
