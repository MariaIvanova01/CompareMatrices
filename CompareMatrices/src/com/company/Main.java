package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] firstmatrix = readMatrix(scan);
        int[][] secondmatrix = readMatrix(scan);

        boolean areEqual = compareMatrix(firstmatrix,secondmatrix);

        String output = areEqual ? "equal ": "not equal";
        System.out.println(output);

    }
    private static int[][] readMatrix(Scanner scan){
        int[] columnsAndRows = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int columns = columnsAndRows[1];
        int rows = columnsAndRows[0];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] array = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = array;

        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];

            for (int element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    private  static boolean compareMatrix (int[][] firstMatrix, int[][] secondMatrix ){
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length){
                return false;
            }
            for (int colomn = 0; colomn < firstMatrix[i].length; colomn++) {
                if (firstMatrix[i][colomn] != secondMatrix[i][colomn]){
                    return false;
                }
            }
        }
        return true;
    }
}
