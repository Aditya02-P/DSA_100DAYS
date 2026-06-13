public class MissNRepNum {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 3};
        int n = 6;

        findMissRep(arr, n);
    }

    public static void findMissRep(int[] arr, int n) {
        if (arr == null || arr.length == 0) {
            return;
        }

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int num : arr) {
            actualSum += num;
            actualSquareSum += (long) num * num;
        }

        long diff = actualSum - expectedSum;                  // x - y
        long squareDiff = actualSquareSum - expectedSquareSum; // x² - y²

        long sumXY = squareDiff / diff; // x + y

        long repeating = (diff + sumXY) / 2;
        long missing = repeating - diff;

        System.out.println("Repeating Number: " + repeating);
        System.out.println("Missing Number: " + missing);
    }
}