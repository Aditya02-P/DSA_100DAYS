public class MaxProSA {
    public static void main(String[] args) {
        int[] arr={2,3,-2,4};

        findMaxproduct(arr);
    }

    public static void findMaxproduct(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }

        int max =Integer.MIN_VALUE;
        int pro=1;

        for(int i=0;i<arr.length;i++){
            pro=1;
            for(int j=i;j<arr.length;j++){
                pro=pro*arr[j];
                max=Math.max(max,pro);
            }
        }

        System.out.println("The maximum value is: "+max);
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;

        int prefix = 1;
        int suffix = 1;
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }

        return maxProduct;
    }

    public static int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(nums[i], maxEndingHere * nums[i]);
            minEndingHere = Math.min(nums[i], minEndingHere * nums[i]);

            result = Math.max(result, maxEndingHere);
        }

        return result;
    }
}
