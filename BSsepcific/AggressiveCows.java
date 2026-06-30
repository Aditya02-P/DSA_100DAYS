import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int cows = 4;

        int ans = aggressiveCows(stalls, cows);
        System.out.println("Maximum minimum distance: " + ans);
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1; // Try for a larger minimum distance
            } else {
                high = mid - 1; // Reduce the distance
            }
        }

        return ans;
    }

    public static boolean canPlace(int[] stalls, int cows, int distance) {
        int count = 1;
        int lastPlaced = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= distance) {
                count++;
                lastPlaced = stalls[i];

                if (count == cows) {
                    return true;
                }
            }
        }

        return false;
    }
}