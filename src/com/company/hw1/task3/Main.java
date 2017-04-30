package com.company.hw1.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a, b, h: ");

        Scanner sc = new Scanner(System.in);

        boolean valid = false;
        while (!valid) {
            try {
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                double h = sc.nextDouble();

                valid = true;
                sc.close();
                printTable(a, b, h);
            } catch (InputMismatchException e) {
                System.out.print("Not a number. Try again: ");
                sc.nextLine();
            }
        }
    }

    private static void printTable(double a, double b, double h) {
        System.out.println("Printing values for function in range [" + a + ", " + b + "] with step h = " + h + ".");

        for (double i = a; i < b; i += h) {
            System.out.println(String.format("%.5f   %.5f", i, func(i)));
        }
    }

    private static double func(double x) {
        return Math.tan(2 * x - 3);
    }
}
