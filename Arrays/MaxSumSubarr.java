public class MaxSumSubarr {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
//        int max = findMaxSum(arr);
//        System.out.println("The maximum sum is :" + max);
        findMaxSumWithIndex(arr);
    }

    //Time complexity - > BigOg(n3)

    public static int findMaxSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                System.out.println();
                max = Math.max(max, sum);
                sum = 0;
            }
        }

        return max;
    }

    //Time complexity - > BigOg(n2)
    public static int findMaxSum1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
            sum = 0;
        }

        return max;
    }

    //Most Optimal Algorithm

    public static int findMaxSum2(int[] arr) {
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

    public static void findMaxSumWithIndex(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        int start = 0;
        int end = 0;

        int tempStart = 0;

        for (int i = 0; i < arr.length; i++) {

            if(sum==0)
                tempStart = i;

            sum += arr[i];

            if (sum > max) {
                max = sum;
                start = tempStart;
                end = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println("Start: " + start + " End: " + end);
        System.out.println("Max: " + max);
    }
}

