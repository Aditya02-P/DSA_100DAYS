import java.util.HashMap;
import java.util.Map;

public class LongestsubarrWithSum {
    public static void main(String[] args) {
        int[]arr={1,2,3,1,1,1,1,4,2,3};
        int k=3;
        int ans = findLongestArr3(arr,k);
        System.out.println("Longest length: "+ans);
    }

    public static int findLongestArr(int[] arr,int target){

        //This is a brute force approach which takes BigOh(n^3) time
        int sum=0;
        int longestLen=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for (int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum==target){
                    longestLen=Math.max(longestLen,j-i+1);
                    sum=0;
                    System.out.println(i+":"+j);
                }else{
                    sum=0;
                }
            }
        }
        return longestLen;
    }

    public static int findLongestArr2(int[] arr,int target){

        //This is a brute force approach which takes BigOh(n^2) time
        int sum=0;
        int longestLen=0;
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==target){
                    longestLen=Math.max(longestLen,j-i);
                    break;
                }
            }
        }
        return longestLen;
    }

    public  static int findLongestArr3(int[] arr,int target){
        //This is a better approach with time complexity of BigOh(n) but require extra space
        int sum=0;
        int longestLen=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==target){
                longestLen=Math.max(longestLen,i+1);
            }
            int rem = sum-target;
            if(map.containsKey(rem)){
                int len =  map.get(rem);
                longestLen=Math.max(longestLen,i-len+1);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return longestLen;
    }
}
