public class Bouquets {

    public static void main(String[] args) {

        int[] bloomDay = {7, 7, 7, 7, 13, 11, 12, 7};

        int m = 2; // Number of bouquets
        int k = 3; // Flowers per bouquet

        int minDays = findMinDays(bloomDay, m, k);

        System.out.println("Minimum days: " + minDays);
    }

    public static int findMinDays(int[] bloomDay, int m, int k) {

        // Not enough flowers to make m bouquets
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find the search space
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int left = min;
        int right = max;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean canMakeBouquets(int[] bloomDay, int m, int k, int dayLimit) {

        int flowers = 0;
        int bouquets = 0;

        for (int day : bloomDay) {

            if (day <= dayLimit) {
                flowers++;
            } else {
                flowers = 0;
            }

            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }

            if (bouquets >= m) {
                return true;
            }
        }

        return false;
    }
}