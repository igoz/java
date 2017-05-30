package hw2.task2;

public abstract class Stationery {
    String brand;
    double cost;

    protected Stationery(String brand, double cost) {
        this.brand = brand;
        this.cost = cost;
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
