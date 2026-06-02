import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {  {1,   2,  3,  4},
                            {5,   6,  7,  8},
                            {9,  10, 11, 12},
                            {13, 14, 15, 16}};

        printMatrix(matrix);
        System.out.println();

//        int[][]rotated=rotateBy90(matrix);
            rotateBy90Optimzed(matrix);

        printMatrix(matrix);


    }
    //This uses a new matrix to store and return the new matrix increasing the space complexity
    public static int[][] rotateBy90(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [][] newMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newMatrix[j][cols-1-i] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    public static void rotateBy90Optimzed(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        TransPoseMatrix.trasnPose(matrix);

        for(int[] row:matrix){
            int i=0;
            int j=cols-1;
            while(i<j) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }

        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }
}
