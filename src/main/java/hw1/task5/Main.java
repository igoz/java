package hw1.task5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter size of the matrix: ");

        Scanner sc = new Scanner(System.in);

        boolean valid = false;
        while (!valid) {
            try {
                int a = sc.nextInt();

                valid = true;
                sc.close();
                int[][] matrix = makeMatrix(a);
                printMatrix(matrix, a);
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.print("Invalid format. Try again: ");
                sc.nextLine();
            }
        }
    }

    private static int[][] makeMatrix(int a) {
        int[][] matrix = new int[a][a];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (i == a - 1 - j) {
                    matrix[i][j] = 1;
                }
            }

        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
