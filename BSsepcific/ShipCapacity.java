public class ShipCapacity {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        int minCapacity = findMinCapacity(weights, days);

        System.out.println("minCapacity = " + minCapacity);
    }

    public static int findMinCapacity(int[] weights, int days) {
        int left = Integer.MIN_VALUE, right = 0;

        for (int w : weights) {
            left = Math.max(w, left);
            right += w;
        }

        int minCapacity = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCarry(weights, days, mid)) {
                minCapacity = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return minCapacity;
    }

    private static boolean canCarry(int[] weights, int days, int capacity) {
        int dayTotal = 1;
        int currentCapacity = capacity;

        for (int w : weights) {
            if (w <= currentCapacity) {
                currentCapacity -= w;
            } else {
                dayTotal++;
                currentCapacity = capacity - w;

                if (dayTotal > days) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean canCarry1(int[] weights, int days, int capacity) {
        int dayTotal = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w <= capacity) {
                currentLoad += w;
            } else {
                dayTotal++;
                currentLoad = w;

                if (dayTotal > days) {
                    return false;
                }
            }
        }

        return true;
    }
}