public class TwoSum {
    public static void main(String[] args) {
        int[] arr ={2,6,5,8,11};
        int target = 14;
        twoSum(arr,target);
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


}
