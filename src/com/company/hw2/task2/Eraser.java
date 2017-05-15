package com.company.hw2.task2;

public class Eraser extends Stationery {
    int depreciation = 0;

    public Eraser(String brand, double cost) {

        super(brand, cost);
    }

    public void use() throws FullyUsedException {
        if (depreciation < 100) {
            depreciation -= 25;
        } else {
            throw new FullyUsedException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Eraser eraser = (Eraser) o;

        return depreciation == eraser.depreciation;
    }

    @Override
    public int hashCode() {
        return depreciation;
    }

    @Override
    public String toString() {
        return String.format("Eraser: \"%s\", deprecation - %d%%, cost - %.2f $",
                brand, depreciation, cost);
    }

    public int getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(int depreciation) {
        this.depreciation = depreciation;
    }

    class FullyUsedException extends Exception {
        public FullyUsedException() {
            System.out.println("Eraser is fully used");
        }
    }
}
