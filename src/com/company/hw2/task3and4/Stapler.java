package com.company.hw2.task3and4;

public class Stapler extends Stationery implements Reloadable {
    private int staplesCount = 5;

    public Stapler(String brand, double cost) {
        super(brand, cost);
    }

    @Override
    public void reload() {
        staplesCount = 5;
    }

    public void use() throws StationeryException {
        System.out.println("Checking if stapler is empty...");
        if (staplesCount > 0) {
            staplesCount--;
            System.out.println("Stapler was used.");
        } else {
            throw new OutOfStaplesException();
        }
    }

    @Override
    public String toString() {
        return String.format("Stapler: \"%s\", staples inside - %d, cost - %.2f $",
                brand, staplesCount, cost);
    }

    class OutOfStaplesException extends StationeryException {
        public OutOfStaplesException() {
            System.out.println("Stapler is out of staples, need to reload.");
        }
    }
}
