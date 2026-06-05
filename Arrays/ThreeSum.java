public class ThreeSum {
    public static void main(String[] args) {
        int[]arr={-1,0,-1,2,-1,-4};
        int target=0;
        threeSum(arr,target);
    }

    //This is a naive brute force approach with a time complexity of BigOh(n3)
    public static void threeSum(int[] arr,int target){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]==target){
                        System.out.println("Triplet: "+arr[i]+" : "+arr[j]+" : "+arr[k]);
                    }
                }
            }
        }
    }

    public static void twoSum1(int[] arr,int target){
        int sum=0;

    }
}
