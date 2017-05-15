package com.company.hw2.task2;

public class Pencil extends Stationery {
    ColorEnum color;

    public Pencil(String brand, double cost, ColorEnum color) {
        super(brand, cost);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pencil pencil = (Pencil) o;

        return color.equals(pencil.color);
    }

    @Override
    public int hashCode() {
        return color.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Pencil: \"%s\", color - %s, cost - %.2f $",
                brand, color, cost);
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public void write() {
    }

    private enum PencilEnum {

    }
}
