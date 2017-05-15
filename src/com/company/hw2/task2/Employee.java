package com.company.hw2.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//TODO использование принадлежностей, проверка на пустоту и обработка исключений
public class Employee {
    String name;
    List<Stationery> stationeryStuff = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    public void writeSomethingWithPen() {
        System.out.printf("Employee %s wants to use a pen.\n", name);
        Iterator<Stationery> it = stationeryStuff.iterator();
        while (it.hasNext()) {
            Stationery currentStationery = it.next();
            if (currentStationery.getClass() == Pen.class) {
                try {
                    ((Pen) currentStationery).write();
                    System.out.printf("Employee %s wrote something with pen.\n", name);
                    return;
                } catch (Pen.OutOfInkException e) {
                    it.remove();
                    System.out.printf("Employee %s throws the pen into the trash.\n", name);
                }
            }
        }
        System.out.printf("Employee %s has no pen.\n", name);
    }

    public void writeSomethingWithPencil() {
        System.out.printf("Employee %s wants to use a pencil.\n", name);
        Iterator<Stationery> it = stationeryStuff.iterator();
        while (it.hasNext()) {
            Stationery currentStationery = it.next();
            if (currentStationery.getClass() == Pencil.class) {
                ((Pencil) currentStationery).write();
                System.out.printf("Employee %s wrote something with pencil.\n", name);
                return;
            }
        }
        System.out.printf("Employee %s has no pencil.\n", name);
    }

    public void useEraser() {
        System.out.printf("Employee %s wants to use an eraser.\n", name);
        Iterator<Stationery> it = stationeryStuff.iterator();
        while (it.hasNext()) {
            Stationery currentStationery = it.next();
            if (currentStationery.getClass() == Eraser.class) {
                try {
                    ((Eraser) currentStationery).use();
                    System.out.printf("Employee %s uses eraser.\n", name);
                    return;
                } catch (Eraser.FullyUsedException e) {
                    it.remove();
                }
            }
        }
        System.out.printf("Employee %s has no eraser.\n", name);
    }

    public void useStapler() {
        System.out.printf("Employee %s wants to use a stapler.\n", name);
        Iterator<Stationery> it = stationeryStuff.iterator();
        while (it.hasNext()) {
            Stationery currentStationery = it.next();
            if (currentStationery.getClass() == Stapler.class) {
                try {
                    ((Stapler) currentStationery).use();
                    System.out.printf("Employee %s uses stapler.\n", name);
                    return;
                } catch (Stapler.OutOfStaplesException e) {
                    System.out.printf("Employee %s can't use this stapler because it's empty.\n", name);
                }
            }
        }
        System.out.printf("Employee %s has no stapler.\n", name);
    }

    public void printStationeryStuffAndTotalCost() {
        System.out.printf("Employee %s has: \n", name);

        double sum = 0;
        for (Stationery stationery : stationeryStuff) {
            System.out.println(stationery);
            sum += stationery.getCost();
        }
        System.out.printf("Total cost: %.2f $\n", sum);
    }

    public Employee addStationery(Stationery stationery) {
        stationeryStuff.add(stationery);

        return this;
    }
}
