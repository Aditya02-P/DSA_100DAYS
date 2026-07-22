import java.util.Arrays;

public class SubSetWKSum {
    public static void main(String[] args) {
        int[] arr = {0  ,1,2,3,4,5};
        int k = 3;

        Boolean[][] dp =  new Boolean[arr.length+1][k+1];

        int ans = countSubsets(arr,k);

        System.out.println(ans);
    }

    private static boolean findSubset(int[] arr, Boolean[][] dp, int i, int k) {
        if(i<0){
            return false;
        }
        if(k<0){
            return false;
        }

        if(dp[i][k]!=null){
            return dp[i][k];
        }

        dp[i][k]=findSubset(arr,dp,i-1,k-arr[i]) || findSubset(arr,dp,i-1,k);

        return dp[i][k];
    }

    private static boolean checkSubsetWS(int[] arr, int k, int i) {

        if(i<0 || k<0) return false;

        if(k==0){
            return true;
        }
        return checkSubsetWS(arr,k-arr[i],i-1) || checkSubsetWS(arr,k,i-1);
    }

    //BottomUp Approach

    private static boolean findSubsetWS(int[] arr, int k) {
        int[][] dp = new int[arr.length][k+1];
        for(int i=0;i<arr.length;i++){
            dp[i][0]=1;
        }
        if (arr[0] <= k)
            dp[0][arr[0]] = 1;

        for(int i=1;i< arr.length;i++){
            for(int j=1;j<=k;j++){
                if(arr[i]<=j)
                    dp[i][j] =  (dp[i - 1][j] > 0 || dp[i - 1][j - arr[i]] > 0) ? 1 : 0;
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[arr.length-1][k]==1;
    }

    private static boolean subsetSum(int[] arr, int k) {

        boolean[][] dp = new boolean[arr.length][k + 1];

        // Sum 0 is always possible
        for (int i = 0; i < arr.length; i++)
            dp[i][0] = true;

        // First element
        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {

            for (int target = 1; target <= k; target++) {

                boolean notTake = dp[i - 1][target];

                boolean take = false;

                if (arr[i] <= target)
                    take = dp[i - 1][target - arr[i]];

                dp[i][target] = take || notTake;
            }
        }

        return dp[arr.length - 1][k];
    }

    private static int countSubsets(int[] arr, int k) {

        int[][] dp = new int[arr.length][k + 1];

        for (int i = 0; i < arr.length; i++)
            dp[i][0] = 1;

        if (arr[0] <= k)
            dp[0][arr[0]] = 1;

        for (int i = 1; i < arr.length; i++) {

            for (int j = 1; j <= k; j++) {

                int notTake = dp[i - 1][j];

                int take = 0;

                if (arr[i] <= j)
                    take = dp[i - 1][j - arr[i]];

                dp[i][j] = take + notTake;
            }
        }

        return dp[arr.length - 1][k];
    }

    private static int countSubsetsWZero    (int[] arr, int target) {

        int n = arr.length;
        int[][] dp = new int[n][target + 1];

        // Base case
        if (arr[0] == 0) {
            dp[0][0] = 2;      // {} and {0}
        } else {
            dp[0][0] = 1;      // {}
            if (arr[0] <= target)
                dp[0][arr[0]] = 1;
        }

        for (int i = 1; i < n; i++) {

            for (int sum = 0; sum <= target; sum++) {

                int notTake = dp[i - 1][sum];

                int take = 0;

                if (arr[i] <= sum)
                    take = dp[i - 1][sum - arr[i]];

                dp[i][sum] = take + notTake;
            }
        }

        return dp[n - 1][target];
    }

    private static boolean subsetSumSpaceOptimized(int[] arr, int k) {

        boolean[] prev = new boolean[k + 1];
        prev[0] = true;

        if (arr[0] <= k)
            prev[arr[0]] = true;

        for (int i = 1; i < arr.length; i++) {

            boolean[] curr = new boolean[k + 1];
            curr[0] = true;

            for (int sum = 1; sum <= k; sum++) {

                boolean notTake = prev[sum];

                boolean take = false;
                if (arr[i] <= sum)
                    take = prev[sum - arr[i]];

                curr[sum] = take || notTake;
            }

            prev = curr;
        }

        return prev[k];
    }



}
