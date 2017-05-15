package com.company.hw2.task3and4;

public abstract class Stationery implements Comparable<Stationery> {
    String brand;
    double cost;

    protected Stationery(String brand, double cost) {
        this.brand = brand;
        this.cost = cost;
    }

    @Override
    public int compareTo(Stationery other) {
        return Double.compare(this.cost, other.cost);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
