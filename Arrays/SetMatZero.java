import java.util.Arrays;

public class SetMatZero {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1}
        };

        System.out.println("Before:");
        printMatrix(arr);

        setZeroes(arr);

        System.out.println("\nAfter:");
        printMatrix(arr);
    }
    // The below is the better method with space complexity of BigOh(m+n)
    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        // Find all rows and columns containing a zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Set cells to zero if their row or column is marked
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //The below is the brute force method

    public static void markZero(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    mark(arr, "row", i);
                    mark(arr, "col", j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void mark(int[][] mat, String target, int index) {
        int rows = mat.length;
        int cols = mat[0].length;

        if (target.equals("row")) {
            for (int j = 0; j < cols; j++) {
                if (mat[index][j] != 0) {
                    mat[index][j] = -1;
                }
            }
        } else {
            for (int i = 0; i < rows; i++) {
                if (mat[i][index] != 0) {
                    mat[i][index] = -1;
                }
            }
        }
    }

    //Optimal Approach

    public static void setZeroesOptimal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstColZero = false;

        // Mark rows and columns
        for (int i = 0; i < rows; i++) {

            if (matrix[i][0] == 0) {
                firstColZero = true;
            }

            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Fill from bottom-right
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (firstColZero) {
                matrix[i][0] = 0;
            }
        }
    }


    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}