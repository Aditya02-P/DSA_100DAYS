public class SpiralMatTraversal {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  4,  5,  6},
                {20, 21, 22, 23, 24,  7},
                {19, 32, 33, 34, 25,  8},
                {18, 31, 36, 35, 26,  9},
                {17, 30, 29, 28, 27, 10},
                {16, 15, 14, 13, 12, 11}
        };

        spiralPrint(matrix);
    }

    public static void spiralPrint(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean flag=true;

        int i=0;
        int j=cols-1;
        int k=rows-1;
        int l=rows-1;





    }
}
