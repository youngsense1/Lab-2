package edu.ntudp.fit.karpenko;

import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {
    // Константи для визначення діапазону рандомних чисел
    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix;
        int width, height;

        // Введення розмірів матриці
        System.out.print("Введіть ширину матриці (не більше 20): ");
        width = scanner.nextInt();
        System.out.print("Введіть висоту матриці (не більше 20): ");
        height = scanner.nextInt();

        // Обмеження розмірів матриці до 20x20
        width = Math.min(width, 20);
        height = Math.min(height, 20);

        // Вибір способу створення матриці
        System.out.println("Оберіть спосіб створення матриці:");
        System.out.println("1. Введення з клавіатури");
        System.out.println("2. Генерація випадкової матриці");
        int choice = scanner.nextInt();

        if (choice == 1) {
            matrix = createMatrixFromInput(scanner, width, height);
        } else {
            matrix = createRandomMatrix(width, height);
        }

        // Виведення матриці на екран
        System.out.println("Матриця:");
        printMatrix(matrix);

        // Пошук мінімального та максимального елементів
        int min = findMin(matrix);
        int max = findMax(matrix);
        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);

        // Розрахунок середнього арифметичного
        double average = calculateAverage(matrix);
        System.out.println("Середнє арифметичне: " + average);
    }

    // Метод для створення матриці з клавіатури
    private static int[][] createMatrixFromInput(Scanner scanner, int width, int height) {
        int[][] matrix = new int[height][width];
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Метод для генерації випадкової матриці
    private static int[][] createRandomMatrix(int width, int height) {
        int[][] matrix = new int[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrix[i][j] = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1) + MIN_RANDOM_VALUE;
            }
        }
        return matrix;
    }

    // Метод для виведення матриці на екран
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    // Метод для пошуку мінімального елементу в матриці
    private static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }

    // Метод для пошуку максимального елементу в матриці
    private static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    // Метод для розрахунку середнього арифметичного
    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += num;
                count++;
            }
        }
        return (double) sum / count;
    }
}