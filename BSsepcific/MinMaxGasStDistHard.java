public class MinMaxGasStDistHard {
    public static void main(String[] args) {
        int[] cords={1,13,17,23};
        int k=4;

        long MinMaxDist = findMinMaxDist(cords,k);

        System.out.println("The MinMax Distance is: "+MinMaxDist);
    }

    public static long findMinMaxDist(int[] cords, int gasStations) {
        if (cords.length == 0 || gasStations == 0) {
            return cords.length;
        }

        int n = cords.length;
        int[] howMuch = new int[n - 1];

        for (int i = 1; i <= gasStations; i++) {
            long maxSection = -1;
            int maxIndex = -1;

            for (int pos = 0; pos < n - 1; pos++) {

                long diff = cords[pos + 1] - cords[pos];
                long secLen = diff / (long) (howMuch[pos] + 1);

                if (secLen > maxSection) {
                    maxSection = secLen;
                    maxIndex = pos;
                }

            }

            howMuch[maxIndex]++;


        }

        long max = Integer.MIN_VALUE;
        for (int pos = 0; pos < n - 1; pos++) {

            long diff = cords[pos + 1] - cords[pos];
            long secLen = diff / (long) (howMuch[pos] + 1);
            max = Math.max(max, secLen);

        }

        return max;
    }

    public static double findMinMaxDistBS(int[] cords, int k) {
        int n = cords.length;

        double low = 0;
        double high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, cords[i + 1] - cords[i]);
        }

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;

            if (canPlace(cords, k, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    private static boolean canPlace(int[] cords, int k, double dist) {
        int count = 0;

        for (int i = 0; i < cords.length - 1; i++) {
            double gap = cords[i + 1] - cords[i];
            count += (int)(gap / dist);
        }

        return count <= k;
    }
}
