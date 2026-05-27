package SpecialAlgos;

public class KadaneAlgo {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max = findMax(arr);
        System.out.println("The maximum sum is :" + max);
    }

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if(sum<0)
                sum = 0;
        }

        return max;
    }
}
