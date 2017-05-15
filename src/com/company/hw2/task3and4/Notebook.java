package com.company.hw2.task3and4;

public class Notebook extends Stationery {
    int pageNumber;

    public Notebook(String brand, double cost, int pageNumber) {
        super(brand, cost);
        this.pageNumber = pageNumber;
    }
    @Override
    public String toString() {
        return String.format("Notebook: \"%s\", pages - %s, cost - %.2f $",
                brand, pageNumber, cost);
    }
}
