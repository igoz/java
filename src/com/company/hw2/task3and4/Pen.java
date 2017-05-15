package com.company.hw2.task3and4;

import com.company.hw2.task2.ColorEnum;

public class Pen extends WritingStationery implements Reloadable{
    private ColorEnum inkColor;
    private int inkLevel = 100;
    private double thickness;

    public Pen(String brand, double cost, ColorEnum inkColor, double thickness) {
        super(brand, cost);
        this.inkColor = inkColor;
        this.thickness = thickness;
    }

    @Override
    public void reload() {
        inkLevel = 100;
    }

    @Override
    public void use() throws OutOfInkException {
        System.out.println("Checking ink level...");
        if (inkLevel >= 25) {
            inkLevel -= 25;
            System.out.println("Pen was used.");
        } else {
            throw new OutOfInkException();
        }
    }

    @Override
    public String toString() {
        return String.format("Pen: \"%s\", ink color - %s, ink level - %d%%, thickness - %.1f mm, cost - %.2f $",
                brand, inkColor, inkLevel, thickness, cost);
    }

    public ColorEnum getInkColor() {
        return inkColor;
    }

    public double getThickness() {
        return thickness;
    }

    class OutOfInkException extends WritingStationeryException {
        public OutOfInkException() {
            System.out.println("Pen is out of ink, need to reload.");
        }
    }
}
