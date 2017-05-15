package com.company.hw2.task3and4;

public class Ruler extends Stationery {
    int length;

    public Ruler(String brand, double cost, int length) {
        super(brand, cost);
        this.length = length;
    }

    public void use() {
        System.out.println("Ruler was used.");
    }

    @Override
    public String toString() {
        return String.format("Ruler: \"%s\", length - %s cm, cost - %.2f $",
                brand, length, cost);
    }

    public int getLength() {
        return length;
    }
}
