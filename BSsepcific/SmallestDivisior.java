public class SmallestDivisior {
    public static void main(String[] args) {
        int[] arr={1,2,5,9};
        int threshold=6;

        int ans = findSmDiv(arr,threshold);
        System.out.println("Smallest divisor is: "+ans);
    }

    public static int findSmDiv(int[] arr,int threshold){
        int ans=0;
        int max=arr[0];
        for (int j : arr) {
            max = Math.max(max, j);

        }

        int left=1,right=max;
        while(left<=right){
            int mid=(left+right)/2;
            if(oThreshold(arr,threshold,mid)){
                ans=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        System.out.println("Smallest divisor is: "+ans);
        return left;
    }

    private static boolean oThreshold(int[] arr,int threshold,int d){
        int sum=0;
        for (int num : arr) {
            sum += Math.ceilDiv(num, d);
        }

        return sum<=threshold;
    }
}
