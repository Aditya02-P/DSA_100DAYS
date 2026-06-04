public class PascalTriangle {
    public static void main(String[] args) {
        int row=4;
        int col=3;

//        findPascalVal(row,col);

        printRowOptimized(row);
    }

    public static void findPascalVal(int row, int col) {
        row--;
        col--;

        if (col > row || row < 0 || col < 0) {
            return;
        }

        //It's the property of Combination col , row-col will yield same result.

        col = Math.min(col, row - col);

        long res = 1;

        for (int i = 0; i < col; i++) {
            res = res * (row - i) / (i + 1);
        }

        System.out.println("The Pascal Value at row: " +(row + 1) + " Col: " + (col + 1) +" is: " + res);
    }

    public static long findPascalVal2(int row, int col) {
        row--;
        col--;

        if (col > row || row < 0 || col < 0) {
            return-1;
        }

        col = Math.min(col, row - col);

        long res = 1;

        for (int i = 0; i < col; i++) {
            res = res * (row - i) / (i + 1);
        }

        return  res;
    }


    //Time complexity is BigOh(n*r)
    public static void printRow(int row) {
        for(int i = 1; i<= row; i++){
            long val = findPascalVal2(row,i);
            System.out.print(val+" ");
        }
    }

    // The time complexity is reduced from BigOh(n*r) to BigOh(n)
    public  static void printRowOptimized(int row) {
        //The value of first column of the nth row
        System.out.print(1);
        int res=1;
        for(int i = 1; i< row; i++){
            res=res*(row -i)/i;
            System.out.print(res);
        }
    }

    public static void printTriangle(int row) {
        for(int i = 1; i<= row; i++){
            printRow(i);
//            printRowOptimized(i);
            System.out.println();
        }
    }
}
