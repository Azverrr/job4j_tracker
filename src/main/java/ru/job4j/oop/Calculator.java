package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int minus(int y) {
        return y - x;
    }

    public static int sum(int y) {
        return x + y;
    }

    public double divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public double sumAllOperation(int y) {
        return minus(y) + divide(y) + multiply(y) + sum(y);
    }

    public static void main(String[] args) {
        int y = 10;
        Calculator calculator = new Calculator();
        System.out.println("Минус = " + minus(y));
        System.out.println("Деление = " + calculator.divide(y));
        System.out.println("Умножение = " + calculator.multiply(y));
        System.out.println("Сумма операций = " + calculator.sumAllOperation(y));
    }
}
