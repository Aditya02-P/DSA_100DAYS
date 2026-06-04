import java.util.HashMap;

public class CountSubarrSum {
    public static void main(String[] args) {
        int[]arr={1,2,3,-3,1,1,1,4,2,-3};
        int k=3;
        countSubarr(arr,k);
    }

    //Time complexity is BigOh(n2)
    public static void countSubarr(int[] arr,int k){
        int sum;
        int count=0;
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                /*The loop is not broken after encountering a subarray sum,
                as the array might contain negatives number
                so there is a possibility of another subarray with sum k*/
                if(sum==k){
                    count++;
                    System.out.println("Index: "+i+" : "+j);
                }
            }
        }

        System.out.println("Total subarr count: "+count);
    }

    public static void countSubarr2(int[] arr,int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            prefixSum += num;

            count += map.getOrDefault(prefixSum - k, 0);

            /*It stores the number of occurrence of  prefixSum - k , it basically that there are get(prefixSum - k) no of subarray sum that exists
            that can be subtracted from current sum to get k.
             */

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println("Total subarr count: "+count);
    }
}
