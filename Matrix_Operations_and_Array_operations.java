import java.util.Scanner;

public class MatrixAndArrayOperations {

    // Method for matrix addition
    public static int[][] matrixAddition(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Method for matrix multiplication
    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Matrix multiplication not possible: Column of first matrix must be equal to row of second matrix.");
        }

        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to find the largest element in an array
    public static int findLargestElement(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Method to sort an array using bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then the array is sorted
            if (!swapped) break;
        }
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // Method to print an array
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Matrix addition
        System.out.println("Matrix Addition:");
        System.out.print("Enter number of rows for matrices: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns for matrices: ");
        int cols = scanner.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        System.out.println("Enter elements for matrix 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements for matrix 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        int[][] sumMatrix = matrixAddition(matrix1, matrix2);
        System.out.println("Result of Matrix Addition:");
        printMatrix(sumMatrix);

        // Matrix multiplication
        System.out.println("\nMatrix Multiplication:");
        System.out.print("Enter number of rows for matrix 1: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter number of columns for matrix 1 (and rows for matrix 2): ");
        int cols1 = scanner.nextInt();
        System.out.print("Enter number of columns for matrix 2: ");
        int cols2 = scanner.nextInt();

        int[][] matrixA = new int[rows1][cols1];
        int[][] matrixB = new int[cols1][cols2];

        System.out.println("Enter elements for matrix A:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements for matrix B:");
        for (int i = 0; i < cols1; i++) {
            for (int j = 0; j < cols2; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        try {
            int[][] productMatrix = matrixMultiplication(matrixA, matrixB);
            System.out.println("Result of Matrix Multiplication:");
            printMatrix(productMatrix);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Find largest element in an array
        System.out.println("\nFind Largest Element in Array:");
        System.out.print("Enter number of elements in the array: ");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];

        System.out.println("Enter array elements:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }

        int largestElement = findLargestElement(array);
        System.out.println("Largest element in the array: " + largestElement);

        // Bubble sort an array
        System.out.println("\nBubble Sort:");
        System.out.println("Array before sorting:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Array after sorting:");
        printArray(array);

        scanner.close();
    }
}
