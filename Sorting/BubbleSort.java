import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[]arr={13, 46, 24, 52, 20, 9};
        for(int i=0;i<arr.length-1;i++){
            //Flag used to detect if swap occurs in a given pass or not , if now we break the loop saving us cpu cycles.
            boolean flag=false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
/*
space complexity: BigOh(1)
Time complexity: BigOh(n^2) worst case
                 (n) for best case where array is sorted
 */
