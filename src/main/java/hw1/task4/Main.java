package hw1.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter an array of symbols delimited by space: ");

        Scanner sc = new Scanner(System.in);

        boolean valid = false;
        while (!valid) {
            try {
                String[] elements = sc.nextLine().split(" ");

                int size = elements.length;
                double[] array = new double[size];
                for (int i = 0; i < array.length; i++) {
                    array[i] = Double.parseDouble(elements[i]);
                }

                valid = true;
                sc.close();

                System.out.println("Max element = " + findMax(array));
            } catch (NumberFormatException e) {
                System.out.print("Invalid format. Try again: ");
            }
        }
    }

    private static double findMax(double[] array) {
        double max = Double.MIN_VALUE;
        int size = array.length;
        double sum = Double.MIN_VALUE;

        for (int i = 0; i < size; i += 2) {
            if (i < size - 1) {
                sum = array[i] + array[i + 1];
            } else if ((size % 2 != 0) && (i == size - 1) ) {
                sum = array[i];
            }

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }


}
