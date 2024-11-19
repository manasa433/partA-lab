import java.util.Scanner;

public class MatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows for the matrix:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns for the matrix:");
        int cols = scanner.nextInt();
        
        // Read the matrix input
        int[][] inputMatrix = readMatrixInput(rows, cols, scanner);

        System.out.println("Input Matrix:");
        displayMatrix(inputMatrix);

        // Rotate the matrix 90 degrees clockwise
        int[][] rotatedMatrix = rotateMatrix(inputMatrix);

        // Reverse each row of the rotated matrix
        for (int i = 0; i < rotatedMatrix.length; i++) {
            reverseArray(rotatedMatrix[i]);
        }

        // Display the rotated and reversed matrix
        System.out.println("\nRotated and Reversed Matrix:");
        displayMatrix(rotatedMatrix);

        scanner.close();
    }

    // Method to read matrix input
    private static int[][] readMatrixInput(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements for the matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    // Method to rotate the matrix 90 degrees clockwise
    private static int[][] rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] rotatedMatrix = new int[cols][rows];

        // Perform the rotation (90 degrees clockwise)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedMatrix[j][rows - 1 - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    // Method to reverse an array (row in this case)
    private static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            // Swap elements at start and end indices
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            // Move indices towards the center
            start++;
            end--;
        }
    }

    // Method to apply custom logic (Optional, not used in this case)
    private static int[][] applyCustomLogic(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] finalMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Example logic: if the element is even, replace it with -1 (for demonstration)
                if (matrix[i][j] % 2 == 0) {
                    finalMatrix[i][j] = -1;
                } else {
                    finalMatrix[i][j] = matrix[i][j];
                }
            }
        }

        return finalMatrix;
    }

    // Method to display the matrix
    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
