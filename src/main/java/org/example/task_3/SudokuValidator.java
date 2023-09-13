package org.example.task_3;

public class SudokuValidator {
    public static boolean isValidSudoku(int[][] sudoku) {
        int N = sudoku.length;
        int square = (int) Math.sqrt(N);

        // Check rows and columns
        for (int i = 0; i < N; i++) {
            boolean[] rows = new boolean[N];
            boolean[] columns = new boolean[N];

            for (int j = 0; j < N; j++) {
                int rowIndex = sudoku[i][j] - 1;
                int columnIndex = sudoku[j][i] - 1;

                if (rowIndex >= 0 && rows[rowIndex]) {
                    return false;
                }
                if (columnIndex >= 0 && columns[columnIndex]) {
                    return false;
                }

                rows[rowIndex] = true;
                columns[columnIndex] = true;
            }
        }

        // Check small squares
        for (int i = 0; i < N; i += square) {
            for (int j = 0; j < N; j += square) {
                boolean[] squares = new boolean[N];

                for (int x = i; x < i + square; x++) {
                    for (int y = j; y < j + square; y++) {
                        int squareIndex = sudoku[x][y] - 1;

                        if (squareIndex >= 0 && squares[squareIndex]) {
                            return false;
                        }

                        squares[squareIndex] = true;
                    }
                }
            }
        }

        return true;
    }
}