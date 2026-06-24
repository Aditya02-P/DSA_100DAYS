public class KokoEB {
    public static void main(String[] args) {
        int[] pile={3,6,7,11};
        int h=8;

        findSpeed(pile,h);
    }

    public static void findSpeed(int[] pile,int h){
        if(pile.length==0 || h==0){
            return;
        }

        int perH=1;

        int max=Integer.MIN_VALUE;
            for (int j : pile) {
            if (j > max) {
                max = j;
            }
        }

        int left=1,right=max;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(time(pile,h,mid)){
                perH=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }

        System.out.println("Koko Requires To Eat At A Rate Of: "+perH);
    }

    private static boolean time(int[] pile, int h, int speed) {
        int hours = 0;

        for (int p : pile) {
            hours += (p + speed - 1) / speed;
        }

        return hours <= h;
    }
}
/*
public class KokoEB {

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int speed = findSpeed(piles, h);
        System.out.println("Minimum eating speed: " + speed);
    }

    public static int findSpeed(int[] piles, int h) {

        if (piles == null || piles.length == 0 || h <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int max = piles[0];
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid - 1;      // Try a smaller speed
            } else {
                left = mid + 1;       // Need a faster speed
            }
        }

        // left is the minimum valid speed
        return left;
    }

    private static boolean canFinish(int[] piles, int h, int speed) {

        int hours = 0;

        for (int pile : piles) {

            // Equivalent to Math.ceil((double) pile / speed)
            hours += (pile + speed - 1) / speed;

            // Early exit
            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}
 */