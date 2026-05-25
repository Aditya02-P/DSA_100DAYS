public class MaxConse1 {
    public static void main(String[] args) {
        int[]arr={1,1,0,1,1,1,0,1,1};
        int max = findConsecutiveOne(arr);
        System.out.println("Max Length of consecutive ones are: "+max);
    }
    public static int findConsecutiveOne(int[] arr){
        int numOfOnes=0;
        int max=0;
            for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                numOfOnes++;
            }
            else{
                max=Math.max(numOfOnes,max);
                numOfOnes=0;
            }
        }
        return max;
    }
}
