import java.util.ArrayList;
import java.util.Collections;

public class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(countWaysBu2(5));
    }

    public static int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static int climbStairs2(int n) {
        ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(n + 1, -1));


        return countWaysTD(n, list);
    }

    private static int countWaysTD(int n, ArrayList<Integer> list) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (list.get(n) != -1) {
            return list.get(n);
        }

        list.set(n, countWaysTD(n - 1, list) + countWaysTD(n - 2, list));
        return list.get(n);
    }

    public static int countWaysBu(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int countWaysBu2(int n) {
        if (n <= 2) return n;
        int fs = 1, ss = 2;
        int totalWays = 0;
        for (int i = 3; i <= n; i++) {
            totalWays = fs + ss;
            fs = ss;
            ss = totalWays;
        }
        return totalWays;
    }
}
