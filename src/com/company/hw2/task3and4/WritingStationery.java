package com.company.hw2.task3and4;

public abstract class WritingStationery extends Stationery {
    protected WritingStationery(String brand, double cost) {
        super(brand, cost);
    }

    public abstract void use() throws WritingStationeryException;
}
