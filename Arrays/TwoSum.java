import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr ={2,6,5,8,11};
        int target = 14;
        twoSumOp(arr,target);
    }

    public static void twoSum(int[] arr,int target){

        //It's a brute force approach with time complexity of BigOh(n^2)
        boolean flag=false;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){

                if(arr[i]+arr[j]==target){
                    System.out.println(arr[i]+" "+arr[j]);
                    flag=true;
                }
            }
            if(flag){
               break;
            }
        }
    }

    //The below method is two pointer approach if the array is sorted or if the original index of the element is not required
    public static void twoSumOp(int[] arr,int target){
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if(arr[i]+arr[j]==target){
                System.out.println(arr[i]+" "+arr[j]);
                i++;
                j--;
            }
            else if(arr[i]+arr[j]>target){
                j--;
            }else {
                i++;
            }
        }

    }


}
