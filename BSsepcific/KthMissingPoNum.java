public class KthMissingPoNum {
    public static void main(String[] args) {
        int[] nums={2,3,4,7,11};
        int k=5;

        int ans = findKnum(nums,k);

        System.out.println("The : "+k+"th missing number is: "+ans);
    }

    public static int findKnum(int[] nums,int k){
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            int missing=nums[mid]-(mid+1);
            if(missing>=k){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return left+k;
    }
}
