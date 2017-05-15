package com.company.hw2.task3and4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StarterKit starterKit = new StarterKit();
        System.out.println(starterKit);

        starterKit.getRuler().use();

        try {
            starterKit.getPen().use();
        } catch (Pen.OutOfInkException e) {
            e.printStackTrace();
        }

        List<Stationery> sorted;
        Comparator<Stationery> brandComparator = new BrandComparator();
        Comparator<Stationery> biComparator = new BiComparator(brandComparator);

        System.out.println("\nBefore sorting: ");
        starterKit.toList().forEach(System.out::println);

        System.out.println("\nSorted by cost: ");
        sorted = starterKit.toList();
        Collections.sort(sorted);
        sorted.forEach(System.out::println);

        System.out.println("\nSorted by brand: ");
        sorted = starterKit.toList();
        Collections.sort(sorted, brandComparator);
        sorted.forEach(System.out::println);

        System.out.println("\nSorted by brand then cost: ");
        sorted = starterKit.toList();
        Collections.sort(sorted, biComparator);
        sorted.forEach(System.out::println);
    }
}

class BrandComparator implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}

class BiComparator implements Comparator<Stationery> {
    Comparator<Stationery> brandComparator = new BrandComparator();

    public BiComparator(Comparator<Stationery> brandComparator) {
        this.brandComparator = brandComparator;
    }

    @Override
    public int compare(Stationery o1, Stationery o2) {
        int res = brandComparator.compare(o1, o2);
        if (res == 0) return o1.compareTo(o2);
        return res;
    }
}
