import java.util.Arrays;

public class FrogJumpKDist {

    public static int findMinEnergy(int[] heights, int k) {
        return minEnergy(heights.length - 1, heights, k);
    }

    private static int minEnergy(int index, int[] heights, int k) {

        if (index == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int jump = 1; jump <= k && jump <= index; jump++) {

            result = Math.min(result, Math.abs(heights[index] - heights[index - jump])
                    + minEnergy(index - jump, heights, k));
        }
        return result;
    }

    public static int findMinEnergyDP(int[] heights, int k) {

        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);

        return minEnergy(heights.length - 1, heights, k, dp);
    }

    private static int minEnergy(int index, int[] heights, int k, int[] dp) {

        // Base case
        if (index == 0) {
            return 0;
        }

        // Return already computed answer
        if (dp[index] != -1) {
            return dp[index];
        }

        int result = Integer.MAX_VALUE;

        // Try every possible jump
        for (int jump = 1; jump <= k && jump <= index; jump++) {

            int energy = Math.abs(heights[index] - heights[index - jump])
                    + minEnergy(index - jump, heights, k, dp);

            result = Math.min(result, energy);
        }

        // Store and return
        dp[index] = result;
        return result;
    }


    public static void main(String[] args) {

        int[] heights = {10, 20, 40, 30};
        int k = 2;

        System.out.println(findMinEnergy(heights, k));

    }
}




