package com.company.hw1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int NUMBER_OF_ITERATIONS = 1_000_000;
    public static void main(String[] args) {
        System.out.print("Enter an ε: ");

        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            try {
                double epsilon = Double.parseDouble(sc.nextLine());
                sc.close();
                valid = true;
                findElement(epsilon);
            } catch (NumberFormatException e) {
                System.out.print("Not a number. Try again: ");
            }
        }
    }

    private static void findElement(double epsilon) {
        List<Double> seq = new ArrayList<>();

        boolean isFound = false;
        int i = 0;
        while (!isFound && i < NUMBER_OF_ITERATIONS) {
            seq.add(1 / Math.pow((i + 2), 2));
            if (seq.get(i) < epsilon) {
                System.out.println("Element index: " + i);
                System.out.println(seq);
                isFound = true;
            }
            i++;
        }
    }

    private static void findElementArray(double epsilon) {
        double[] seq = new double[NUMBER_OF_ITERATIONS];

        boolean isFound = false;
        int i = 0;
        while (!isFound && i < NUMBER_OF_ITERATIONS) {
            seq[i] = (1 / Math.pow((i + 2), 2));
            if (seq[i] < epsilon) {
                System.out.println("Element index: " + i);
                System.out.println(Arrays.toString(Arrays.copyOf(seq, i)));
                isFound = true;
            }
            i++;
        }
    }
}
