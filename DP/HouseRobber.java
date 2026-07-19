import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HouseRobber {
    public static void main(String[] args) {
        int[] hs ={1,7,2,3,1,9};
        int ans = Math.max(
                robRound(hs, 0, hs.length - 1), // exclude last
                robRound(hs, 1, hs.length)      // exclude first
        );
    }

    private static int calcMaxAm(int[] hs,int index) {
        if(index>hs.length-1){
            return 0;
        }

        int yes=hs[index]+calcMaxAm(hs,index+2);
        int no=calcMaxAm(hs,index+1);

        return Math.max(yes,no);
    }
    private static int calcMaxAmDP(int[] hs) {
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(hs.length, -1));
        return maxAmDP(hs, dp, 0);
    }

    private static int maxAmDP(int[] hs, ArrayList<Integer> dp, int index) {
        if (index >= hs.length) {
            return 0;
        }

        if (dp.get(index) != -1) {
            return dp.get(index);
        }

        int yes = hs[index] + maxAmDP(hs, dp, index + 2);
        int no = maxAmDP(hs, dp, index + 1);

        dp.set(index, Math.max(yes, no));
        return dp.get(index);
    }

    //Bottom up Approach

    public static int calcMaxAmBU(int[] hs) {

        int[] dp = new int[hs.length + 2];

        for (int i = hs.length - 1; i >= 0; i--) {
            int yes = hs[i] + dp[i + 2];
            int no = dp[i + 1];

            dp[i] = Math.max(yes, no);
        }

        return dp[0];
    }


    public static int calcMaxAmOptimized(int[] hs) {

        int next = 0;      // dp[i+1]
        int nextNext = 0;  // dp[i+2]

        for (int i = hs.length - 1; i >= 0; i--) {
            int curr = Math.max(hs[i] + nextNext, next);

            nextNext = next;
            next = curr;
        }

        return next;
    }

    public static int calcMaxAmOptimizedFB(int[] hs) {

        int prev = Math.max(hs[0],hs[1]);      // dp[i+1]
        int prevPrev = hs[0];  // dp[i+2]
        int curr ;
        for(int i=2; i<hs.length; i++){
            curr = Math.max(hs[i] + prevPrev, prev);
            prevPrev = prev;
            prev = curr;
        }

        return prev;
    }

    private static int robRound(int[] hs, int index, int endIndex) {
        if (index >= endIndex) {
            return 0;
        }

        int yes = hs[index] + robRound(hs, index + 2, endIndex);
        int no = robRound(hs, index + 1, endIndex);

        return Math.max(yes, no);
    }

    private static int robRound(int[] hs, int index, int endIndex, int[] dp) {
        if (index >= endIndex) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int yes = hs[index] + robRound(hs, index + 2, endIndex, dp);
        int no = robRound(hs, index + 1, endIndex, dp);

        dp[index] = Math.max(yes, no);
        return dp[index];
    }

    public static int rob(int[] hs) {
        if (hs.length == 1) {
            return hs[0];
        }

        int[] dp1 = new int[hs.length];
        int[] dp2 = new int[hs.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int excludeLast = robRound(hs, 0, hs.length - 1, dp1);
        int excludeFirst = robRound(hs, 1, hs.length, dp2);

        return Math.max(excludeLast, excludeFirst);
    }
}
