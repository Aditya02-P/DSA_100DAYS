public class FindPeak {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,8,5,1};

        findPeak(arr);
    }

    public static void findPeak(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]>arr[mid+1]){
                right = mid;
            }else if(arr[mid]<arr[mid+1]){
                left = mid+1;
            }
        }

        System.out.println(left);
        System.out.println(right);
    }
}
