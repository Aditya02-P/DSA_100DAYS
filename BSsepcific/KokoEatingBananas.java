public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int ans = minEatingSpeed(piles, h);

        System.out.println("Minimum Eating Speed: " + ans);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                high = mid - 1;   // Try a smaller speed
            } else {
                low = mid + 1;    // Increase speed
            }
        }

        return low;
    }

    public static boolean canFinish(int[] piles, int h, int speed) {
        int totalHours = 0;

        for (int bananas : piles) {
            totalHours += (bananas + speed - 1) / speed;
            // Equivalent to Math.ceil((double) bananas / speed)
        }

        return totalHours <= h;
    }

    public static int findMax(int[] piles) {
        int max = piles[0];

        for (int bananas : piles) {
            if (bananas > max) {
                max = bananas;
            }
        }

        return max;
    }
}