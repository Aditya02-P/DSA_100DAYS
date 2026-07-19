import java.util.ArrayList;
import java.util.Collections;

public class MInCostStairs {
    public static void main(String[] args) {
        int[] arr = {23, 32, 34, 4, 234, 23, 24, 5, 5, 23};
        int n = 10;

        System.out.println(findMinCost3(arr, n));
    }

    private static int minCost(int[] arr, int n) {
        if (n <= 1) return 0;

        return Math.min(minCost(arr, n - 1) + arr[n - 1], minCost(arr, n - 2) + arr[n - 2]);
    }

    private static int minCost2(int[] cost, int n) {
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));

        return findMinCost(cost, dp, n);
    }

    //Top-Down DP
    private static int findMinCost(int[] cost, ArrayList<Integer> dp, int n) {
        if (n <= 1) return 0;

        if (dp.get(n) != -1) {
            return dp.get(n);
        }

        dp.set(n, Math.min(minCost(cost, n - 1) + cost[n - 1], minCost(cost, n - 2) + cost[n - 2]));

        return dp.get(n);
    }

    //Bottom-Up approach

    private static int findMinCost3(int[] cost, int n) {
        if (n <= 1) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(dp[1] + cost[1], dp[0] + cost[0]);

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

}


