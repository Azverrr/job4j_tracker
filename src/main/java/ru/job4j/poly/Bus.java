package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        boolean drive = true;
    }

    @Override
    public void passenger(int amount) {
        int amountOfPassenger = amount;
    }

    @Override
    public int fuel(int amountOfFuel) {
        int price = 1;
        return price * amountOfFuel;
    }
}
