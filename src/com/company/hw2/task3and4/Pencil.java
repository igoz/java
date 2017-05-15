package com.company.hw2.task3and4;

import com.company.hw2.task2.ColorEnum;

public class Pencil extends WritingStationery {
    ColorEnum color;

    public Pencil(String brand, double cost, ColorEnum color) {
        super(brand, cost);
        this.color = color;
    }

    @Override
    public void use() {
        System.out.println("Pencil was used.");
    }

    @Override
    public String toString() {
        return String.format("Pencil: \"%s\", color - %s, cost - %.2f $",
                brand, color, cost);
    }

    public ColorEnum getColor() {
        return color;
    }
}
