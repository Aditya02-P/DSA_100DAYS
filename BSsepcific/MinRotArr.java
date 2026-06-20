public class MinRotArr {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2,3,4};

        findMin(arr);
    }


    //This method keeps track of the min element in the sorted half than eliminate it
    public static void findMin(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }
        int left=0,right=arr.length-1;
        int ans = Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[left]<=arr[right]){
                ans=Math.min(ans,arr[left]);
                break;
            }
            if(arr[left]<=arr[mid]){
                ans=Math.min(ans,arr[left]);
                left=mid+1;
            }else{
                ans=Math.min(ans,arr[mid]);
                right=mid-1;
            }
        }

        System.out.println("The Minimum Element is "+ans);
    }
}
