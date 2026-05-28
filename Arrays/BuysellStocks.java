public class BuysellStocks {
    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 5, 4};
        findDay(price);
    }

    public static void findDay(int[] arr) {
        int d1 = 0, d2 = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[j] - arr[i];
                if (diff >= 0 && diff > max) {
                    max = diff;
                    d1 = i;
                    d2 = j;
                }
            }
        }

        System.out.println("Day 1: " + d1);
        System.out.println("Day 2: " + d2);
    }

    public static void findDay1(int[] arr) {

        int minPrice = arr[0];
        int buyDay = 0;

        int d1 = 0, d2 = 0;
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {

            int profit = arr[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
                d1 = buyDay;
                d2 = i;
            }

            if (arr[i] < minPrice) {
                minPrice = arr[i];
                buyDay = i;
            }
        }

        System.out.println("Buy Day: " + d1);
        System.out.println("Sell Day: " + d2);
        System.out.println("Profit: " + maxProfit);
    }

}
