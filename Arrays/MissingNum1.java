public class MissingNum1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
        int miss = missedNum3(arr,5);
        System.out.println("Missing Element is: "+miss);

    }

    //Approach 1
    public static int missedNum(int[] arr, int num) {
        for(int i = 1; i < arr.length; i++){
            if((arr[i-1]+1)!=arr[i]){
                return arr[i-1]+1;
            }
        }

        return -1;
    }

    public static int missedNum2(int[] arr, int num) {
        int missing = 0;
        int total = (num)*(num+1)/2;
        for (int j : arr) {
            missing += j;
        }
        return total-missing;
    }

    //THE BEST APPROACH
    public static int missedNum3(int[] arr, int num) {
        int xor = num;

        for (int i = 0; i < arr.length; i++) {
            xor ^= (i + 1);
            xor ^= arr[i];
        }

        return xor;
    }

}
